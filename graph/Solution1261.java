package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

class Block implements Comparable{
	int x;
	int value;
	
	public Block(int x,int value){
		this.x = x;
		this.value = value;
	}

	@Override
	public int compareTo(Object o) {
		Block b = (Block)o;
		return this.value - b.value;
	}
	
	@Override
	public String toString(){
		return String.format("x:%d distance:%d", this.x,this.value);
	}
}

public class Solution1261 {
	
	public static final int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M,N;
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[10001];
		int[] result = new int[10001];
		Vector<Block>[] adj = new Vector[M*N+1];
		StringBuilder s = new StringBuilder();
		for(int i=1;i<=N*M;i++){
			result[i] = INF;
			visited[i] = false;
		}
		for(int i=0;i<N;i++){
			String temp = br.readLine();
			s.append(temp);
		}
		for(int i=0;i<M*N+1;i++){
			adj[i] = new Vector<>();
		}
		for(int i=1;i<=N*M;i++){
			int spot = s.charAt(i-1) - '0';
			if(i%M!=0){
				adj[i+1].add(new Block(i,spot));
			}
			if(i%M!=1){
				adj[i-1].add(new Block(i,spot));
			}
			if(i<=M*(N-1)){
				adj[i+M].add(new Block(i,spot));
			}
			if(i>M){
				adj[i-M].add(new Block(i,spot));
			}
		}
		/*
		for(int i=1;i<adj.length;i++){
			System.out.println(i);
			for(int j=0;j<adj[i].size();j++){
				System.out.println(adj[i].get(j));
			}
		}
		*/
		PriorityQueue<Block> pq = new PriorityQueue<>();
		
		result[1] = 0; 
		int arrive = N*M;
		pq.offer(new Block(1,0));
		while(!pq.isEmpty()){
			int curx = pq.poll().x;
			visited[curx] = true;
			if(visited[arrive]==true && result[arrive]<INF){
				break;
			}
			for(Block n : adj[curx]){
				if(!visited[n.x] && result[n.x]>(n.value+result[curx])){
					result[n.x] = (n.value+result[curx]);
					pq.offer(new Block(n.x,result[n.x]));
				}
			}
		}
		System.out.println(result[arrive]);
		
	}

}
