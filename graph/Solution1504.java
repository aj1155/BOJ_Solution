package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

class Element implements Comparable{
	int vertex;
	int value;
	
	public Element(int vertex,int value){
		this.vertex = vertex;
		this.value = value;
	}
	
	@Override
	public int compareTo(Object o){
		Element n = (Element)o;
		return this.value - n.value;
	}
	
	@Override
	public String toString(){
		return String.format("vertex:%d value:%d", this.vertex,this.value);
	}
}

public class Solution1504 {
	
	static final int INF = 100000000;
	static Vector<Element>[] list;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int firstSearch = 0;
		int secondSearch = 0;
		list = new Vector[N];
		visited = new boolean[N];
		result = new int[N];
		for(int i=0;i<list.length;i++){
			list[i] = new Vector<>();
		}
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[v1-1].add(new Element(v2-1,w));
			list[v2-1].add(new Element(v1-1,w));
		}
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken())-1;
		int second = Integer.parseInt(st.nextToken())-1;
		int between = dstra(first,second);
		firstSearch+=dstra(0,first);
		firstSearch+=dstra(second,N-1);
		secondSearch+=dstra(0,second);
		secondSearch+=dstra(first,N-1);
		if(result[N-1]>=INF){
			System.out.println(-1);
			return;
		}
		int print = Math.min(between+firstSearch, between+secondSearch);
		System.out.println(print>=INF ? -1 : print);

		
	}
	public static int dstra(int start,int arrive){
		for(int i=0;i<list.length;i++){
			visited[i] = false;
			result[i] = INF;
		}
		PriorityQueue<Element> pq = new PriorityQueue<>();
		result[start] = 0;
		pq.offer(new Element(start,0));
		while(!pq.isEmpty()){
			int c = pq.poll().vertex;
			visited[c] = true;
			if(visited[arrive]==true && result[arrive]<INF){
				break;
			}
			for(Element e : list[c]){
				if(!visited[e.vertex] && result[e.vertex]>result[c]+e.value){
					result[e.vertex] = result[c]+e.value;
					pq.offer(e);
				}
			}
		}
		return result[arrive];
	}

}
