class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {

        ArrayList<ArrayList<Integer>> l=new ArrayList<>();
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<=n;i++) l.add(new ArrayList<>());
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            l.get(u).add(v);
            l.get(v).add(u);
        }

        boolean[] visited=new boolean[n+1];
        Queue<Double> p=new LinkedList<>();

        q.offer(new int[]{1,0});
        visited[1]=true;
        p.offer(1.0);

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int node=curr[0];
            int time=curr[1];
            double count=0.0;
            double prob=p.poll();
            if(time>t){
                break;
            }

            for(int a:l.get(node)){
                if(!visited[a]){
                    count++;
                }
            }

            if(node==target){
                
                if(t==time || count==0.0){
                    return prob;
                }

                else return 0.0;
                
                
            }

            for(int a:l.get(node)){
                if(!visited[a]){
                    q.offer(new int[]{a,time+1});
                    p.offer(prob/count);
                    visited[a]=true;

                }
                
            }
        }

        return 0.0;
    }
}