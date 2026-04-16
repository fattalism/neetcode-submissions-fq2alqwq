class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable {
    int size; // how many nodes are actually there
    int capacity; // how many nodes can the table hold
    Node[] table;

    public HashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.table = new Node[this.capacity];
    }

    public int hashfunction(int key){
    return (key % this.capacity + this.capacity) % this.capacity;
    }

    public void insert(int key, int value) {
        int index = this.hashfunction(key);
        Node node = this.table[index];

        if(node == null){
            //there isn't a node there yet
            this.table[index] = new Node(key, value);
            this.size++;
        } else{
            Node prev = null;
            while(node != null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                prev = node; 
                node = node.next;
            }
            prev.next = new Node(key, value);
            this.size++;
        }
        if((double) this.size / this.capacity >= 0.5){
            this.resize();
        }

    }

    public int get(int key) {
        int index = this.hashfunction(key);
        Node node = this.table[index];
        while(node != null){
            if(node.key == key)
            return node.value;

            node = node.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int index = this.hashfunction(key);
        Node node = this.table[index];

        Node prev = null;
        while(node != null){
            if(node.key == key){
                if(prev == null){
                    table[index] = node.next;
                }else{
                    prev.next = node.next;
                }
                this.size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;

    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;

    }

    public void resize() {
        int newCap = this.capacity * 2;
        Node[] newTable = new Node[newCap];

        for(Node node : this.table){
            while(node != null){
                int index = node.key % newCap;
                if(newTable[index] == null){
                    newTable[index] = new Node(node.key, node.value);
                }else{
                    Node newNode = newTable[index];
                    while(newNode.next != null){
                        newNode = newNode.next;
                    }
                    newNode.next = new Node(node.key, node.value);
                }
                node = node.next;
            }
        }
        this.capacity = newCap;
        this.table = newTable;
    }
}
