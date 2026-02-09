class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean[] vis = new boolean[n];

        dfs(0, rooms,vis);
        for(int i=0; i<n; i++){
            if(!vis[i]) return false;
        }
        return true;
    }

    private static void dfs(int node, List<List<Integer>> rooms, boolean[] vis ){
        
        vis[node] = true;
        for(Integer it: rooms.get(node)){
            if(!vis[it]){
                dfs(it, rooms, vis);
            }
        }
    }
}