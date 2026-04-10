// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size() -1);
    
    }

    public List<Pair> mergeSortHelper(List<Pair> pairs, int s, int e){
        //check for base case
        if(e - s + 1 <=1)
        return pairs;

        // get middle point
        int m = (s+e)/2;

        // divide into singular arrays
        mergeSortHelper(pairs, s, m);
        mergeSortHelper(pairs,m + 1, e);

        // sort them
        merge(pairs, s, m ,e);

        return pairs;

    }
    public void merge(List<Pair> pairs, int s, int m, int e){

        // copy left and right parts of the array
List<Pair> left = new ArrayList<>(pairs.subList(s, m + 1));
List<Pair> right = new ArrayList<>(pairs.subList(m + 1, e + 1));

        // init new points

        int i = 0;
        int j = 0;
        int k = s; // array pointer to sort in place

        // merge the halves
        while(i< left.size() && j< right.size()){
            if(left.get(i).key <= right.get(j).key){
                pairs.set(k,left.get(i));
                i++;
            } else{
                pairs.set(k,right.get(j));
                j++;
            }
            k++;
        }

        // if one of the halves still  has anyy
                while (i < left.size()) {
            pairs.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            pairs.set(k, right.get(j));
            j++;
            k++;
        }



    }
}
