package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2167 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i][j-1] + arr[i][j];
				
			}
		}
		int count = Integer.parseInt(br.readLine());
		List<Integer> result = new ArrayList<>();
		while(count>0){
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int sum = 0;
	        for (int row = i; row <= x; row++) {
	            sum += dp[row][y] - dp[row][j-1];
	        }
			result.add(sum);
			count--;
		}
		result.forEach(System.out::println);
	}

}
