package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_11437_LCA {
	
	 static final int M = 20;
	 static int[] depth;
	 static int[][] parent; 
	 static ArrayList<Integer>[] adj;
	 static ArrayList<Integer> result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        adj = (ArrayList[])new ArrayList[n + 1];
        for(int i = 1; i <= n; ++i) adj[i] = new ArrayList<Integer>();
        depth = new int[n + 1];
        parent = new int[M + 1][n + 1];
        for(int i = 0; i < n - 1; ++i){
        	st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(1, 1, 0);
         
        for(int i = 0; i < M - 1; ++i){
            for(int j = 1; j <= n; ++j){
                parent[i + 1][j] = parent[i][parent[i][j]];
            }
        }
        int m = Integer.parseInt(br.readLine());
        result = new ArrayList<>();
        for(int i = 0; i < m; ++i){
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            result.add(LCA(x,y));           
        }
        
        result.forEach(System.out::println);

	}
	
	static void dfs(int cur, int d, int p)
    {
		//System.out.println(cur+" "+d+" "+p);
        depth[cur] = d;
        parent[0][cur] = p;
        for(int nxt : adj[cur]){
            if(nxt != p){
                dfs(nxt, d + 1, cur);
            }
        }
    }
     
    static int LCA(int u, int v)
    {
        if(depth[u] < depth[v]) return LCA(v, u);
        int d = depth[u] - depth[v];
        for(int i = 0; i < M; ++i){
            if((d & 1 << i) > 0){
                u = parent[i][u];
            }
        }
         
        if(u == v) return u;
        for(int i = M - 1; i >= 0; --i){
            if(parent[i][u] != parent[i][v]){
                u = parent[i][u];
                v = parent[i][v];
            }
        }
        return parent[0][u];
    }

}
