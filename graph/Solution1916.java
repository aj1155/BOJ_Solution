package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;


public class Solution1916 {
	
	public static final int INF = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int city = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Vector<Element>[] adj = new Vector[1001];
		boolean[] visited = new boolean[1001];
		int[] result = new int[1001];
		for(int i=0;i<adj.length;i++){
			adj[i] = new Vector<>();
		}
		
		for(int i=0;i<bus;i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[start-1].add(new Element(end-1,weight));
		}
		for(int i=0;i<city;i++){
			result[i] = INF;
			visited[i] = false;
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int arrive = Integer.parseInt(st.nextToken());
		PriorityQueue<Element> pq = new PriorityQueue<>();
		
		result[start-1] = 0; 
		pq.offer(new Element(start-1,0));
		while(!pq.isEmpty()){
			int curVertex = pq.poll().vertex;
			visited[curVertex] = true;
			if(visited[arrive-1]==true && result[arrive-1]<INF){
				break;
			}
			for(Element n : adj[curVertex]){
				if(!visited[n.vertex] && result[n.vertex]>(n.value+result[curVertex])){
					result[n.vertex] = (n.value+result[curVertex]);
					pq.offer(new Element(n.vertex,result[n.vertex]));
				}
			}
		}
		System.out.println(result[arrive-1]);
		

	}

}

