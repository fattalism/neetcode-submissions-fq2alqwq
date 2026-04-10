// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
         quickSortHelper(pairs, 0, pairs.size() - 1);
         return pairs;
    }

    public void quickSortHelper(List<Pair> pairs, int s, int e){
        if(e - s + 1 <= 1)
        return;

        // choosing the pivot
        Pair pivot = pairs.get(e);
        int left = s;

        // sorting left of the pivot
        for(int i = left; i<e; i++){
            if(pairs.get(i).key < pivot.key){
                Pair temp = pairs.get(left);
                pairs.set(left, pairs.get(i));
                pairs.set(i, temp);
                left++;
            }
        }

        // move pivot to its place
        pairs.set(e, pairs.get(left));
        pairs.set(left, pivot);

        quickSortHelper(pairs, s, left - 1);
        quickSortHelper(pairs, left + 1, e);
    }
}
