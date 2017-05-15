package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computers = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int count=0;
		int[][] arr = new int[computers+1][computers+1];
		boolean[] visited = new boolean[computers+1];
		Arrays.fill(visited, false);
		for(int i=0;i<edge;i++){
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			arr[v1][v2] = 1;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		while(!q.isEmpty()){
			int c = q.poll();
			for(int i=1;i<=computers;i++){
				if(arr[c][i]==1 && !visited[i]){
					count++;
					visited[i] = true;
					q.offer(i);
				}
			}
			
		}
		System.out.println(count);
		/*
		for(int i=0;i<=computers;i++){
			for(int j=0;j<=computers;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		*/
	}

}
