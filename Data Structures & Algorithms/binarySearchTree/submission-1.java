    class TreeNode{
        int value;
        int key;
        TreeNode left;
        TreeNode right;
        public TreeNode(int key, int value){
            this.value = value;
            this.key = key;
        }
    }


class TreeMap {

    private TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int value) {
        if(root == null) {
            root = new TreeNode(key, value);
            return;
        }

        TreeNode curr = root;
        while(true){
            if(key < curr.key){
                if(curr.left == null){
                    curr.left = new TreeNode(key, value);
                    return;
                }
                curr = curr.left;
            }
            else if(key > curr.key){
                if(curr.right == null){
                    curr.right = new TreeNode(key, value);
                    return;
                }
                curr = curr.right;
            }
            else {
                curr.value = value;
                return;
            }
        }
    }

    public int get(int key) {
        TreeNode curr = root;

        while(curr != null){
            if(curr.key > key){
                curr = curr.left;
            }
            else if (curr.key < key){
                curr = curr.right;
            }
            else
            return curr.value;
        }

        return -1;

    }

    public int getMin() {
        TreeNode curr = root; 
        while(curr != null && curr.left != null){
            curr = curr.left;
        }
        return curr != null? curr.value: -1;

    }

    public TreeNode findMin(TreeNode curr) {
        while(curr != null && curr.left != null){
            curr = curr.left;
        }
        return curr;

    }

    public int getMax() {
        TreeNode curr = root; 
        while(curr != null && curr.right != null){
            curr = curr.right;
        }
        return curr != null ? curr.value : -1;

    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    private TreeNode removeHelper(TreeNode curr, int key) {
        if (curr == null) {
            return null;
        }

        if (key > curr.key) {
            curr.right = removeHelper(curr.right, key);
        } else if (key < curr.key) {
            curr.left = removeHelper(curr.left, key);
        } else {
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            } else {
                TreeNode minNode = findMin(curr.right);
                curr.key = minNode.key;
                curr.value = minNode.value;
                curr.right = removeHelper(curr.right, minNode.key);
            }
        }
        return curr;
    }

     public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.key);
            inorderTraversal(root.right, result);
        }
    }
}