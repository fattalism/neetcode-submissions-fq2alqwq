class Graph {

    private HashMap<Integer, HashSet<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
       adjList.putIfAbsent(src, new HashSet<>());
       adjList.putIfAbsent(dst, new HashSet<>());
       adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        // fist check if an edge exist in the first place
        if(adjList.containsKey(src)){
            if(adjList.get(src).contains(dst)){
                adjList.get(src).remove(dst);
                return true;
            }
        }
        //return false if it doesn't exist
        return false;
    }

    public boolean hasPath(int src, int dst) {
        return hasPathHelper(src, dst, new HashSet<>());
    }
    private boolean hasPathHelper(int current, int dst, HashSet<Integer> visited) {
    // base case
    if (current == dst) return true;

    // avoid infinite loops (cycles)
    if (visited.contains(current)) return false;
    visited.add(current);

    // if node doesn't exist
    if (!adjList.containsKey(current)) return false;

    // explore neighbors
    for (int neighbor : adjList.get(current)) {
        if (hasPathHelper(neighbor, dst, visited)) {
            return true;
        }
    }

    return false;
}
}
