package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1238 {
	
	public static final int INF = 9999999;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arrive = Integer.parseInt(st.nextToken());
		
		
		
		int[][] arr = new int[1001][1001];
		for(int i=0;i<=N;i++){
			for(int j=0;j<=N;j++){
				if(i!=j)
				arr[i][j] = INF;
			}
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[start][end] = weight;
		}
		
		for(int k=1;k<=N;k++){
			for(int i=1;i<=N;i++){
				for(int j=0;j<=N;j++){
					if (arr[i][k] == INF || arr[k][j] == INF)
	                    continue;
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k]+arr[k][j];
				}
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=N;i++){
			int value = arr[i][arrive] + arr[arrive][i];
			max = Math.max(max, value);
		}
		System.out.println(max);

	}

}
