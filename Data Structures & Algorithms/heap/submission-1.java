class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public void push(int val) {
        this.heap.add(val);
        this.heapifyUp(); // put it in it's right place
    }

    public Integer pop() {
        if (heap.isEmpty()) return -1;
        int item = this.heap.get(0); // get item
        swap(0, this.heap.size() - 1); // swap last element to first place
        this.heap.remove(this.heap.size() - 1);
        this.heapifyDown();

        return item;
    }

    public Integer top() {
        return heap.size() > 0? heap.get(0) : -1;

    }

    public void heapify(List<Integer> nums) {
        this.heap = new ArrayList<>(nums);
        for (int i = (heap.size() / 2) - 1; i >= 0; i--) {
        heapifyDownFromIndex(i);
    }
    }

    public void heapifyDownFromIndex(int index) {
    while (getLeftChild(index) < heap.size()) {
        int smallestChild = getLeftChild(index);

        if (getRightChild(index) < heap.size() &&
            heap.get(getRightChild(index)) < heap.get(smallestChild)) {
            smallestChild = getRightChild(index);
        }

        if (heap.get(index) <= heap.get(smallestChild)) {
            break;
        }

        swap(index, smallestChild);
        index = smallestChild;
    }

    }
    // HELPER METHODS
    public void heapifyUp(){
        int index = this.heap.size() - 1; // the last element added
        while(getParent(index) >= 0 && this.heap.get(index) < this.heap.get(getParent(index)))
        {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }
    public void heapifyDown(){
        int index = 0; //get root
        while(getLeftChild(index) < this.heap.size()) {
        int smallestChildIndex = getLeftChild(index);
        if(getRightChild(index) < this.heap.size()&& this.heap.get(getRightChild(index)) < this.heap.get(getLeftChild(index))){
            smallestChildIndex = getRightChild(index);
        }
        if(this.heap.get(index) <= this.heap.get(smallestChildIndex)){
            break;
        }else{
            swap(index, smallestChildIndex);
        }
        index = smallestChildIndex;
        
        }
    }


    public void swap(int index1, int index2){
        int temp = this.heap.get(index1);
        this.heap.set(index1, this.heap.get(index2));
        this.heap.set(index2, temp);
    }
    public int getLeftChild(int index){
        return index * 2 + 1;}
    public int getRightChild(int index){
        return index * 2 + 2;}
    public int getParent(int index){
        return (index - 1 ) / 2;
    }
}
