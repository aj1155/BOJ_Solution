package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;
class Node implements Comparable{
	int vertex;
	int value;
	
	public Node(int vertex,int value){
		this.vertex = vertex;
		this.value = value;
	}

	@Override
	public int compareTo(Object o) {
		Node n = (Node)o;
		return this.value - n.value;
	}
	
	@Override
	public String toString(){
		return String.format("%d %d", vertex,value);
	}
	
}
public class Solution1753 {
	
	public static final int INF = 10000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nVertex = Integer.parseInt(st.nextToken());
		int nEdge = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()) -1;
		
		Vector<Node>[] adj = new Vector[nVertex];
		for(int i=0;i<adj.length;i++){
			adj[i] = new Vector<>();
		}
		
		for(int i=0;i<nEdge;i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adj[start-1].add(new Node(end-1,weight));
		}
		br.close();
		int[] result = new int[nVertex];
		boolean[] visited = new boolean[nVertex];
		
		for(int i=0;i<nVertex;i++){
			result[i] = INF;
			visited[i] = false;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		result[K] = 0;
		pq.offer(new Node(K,0));
		
		while(!pq.isEmpty()){
			int curVertex = pq.poll().vertex;
			visited[curVertex] = true;
			for(Node n : adj[curVertex]){
				if(!visited[n.vertex] && result[n.vertex]>(n.value+result[curVertex])){
					result[n.vertex] = (n.value+result[curVertex]);
					pq.offer(new Node(n.vertex,result[n.vertex]));
				}
			}
		}
		for(int num : result){
			System.out.println(num == INF ? "INF" : num);
		}
	
	}
}
