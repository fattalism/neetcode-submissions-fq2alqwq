class Node{
    public int val;
    public Node nxt;

    public Node(int val){
    this.val = val;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
    //init empy linked list
    this.head = null;
    this.tail = null;
    }

    public int get(int index) {
        if(head == null) // is empty?
        return -1;

        Node curr = head; //pointer
        int i = 0; // counter
        while(i < index && curr != null){
            curr = curr.nxt;
            i++;
        }
        if(curr != null)
        return curr.val;

        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.nxt = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.nxt = newNode;
            tail = newNode;
        }
    }

    public boolean remove(int index) {
        if(head == null) // is empty?
        return false;
        if (index == 0) {
            if (head == tail) tail = null;
            head = head.nxt;
            return true;
        }

        Node curr = head; //pointer
        int i = 0; // counter
        while(i < index - 1 && curr != null){
            curr = curr.nxt;
            i++;
        }
        if(curr != null && curr.nxt != null){
            if (curr.nxt == tail) tail = curr;
            curr.nxt = curr.nxt.nxt;
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList();
        Node curr = head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.nxt;
        }
        return list;
    }
}