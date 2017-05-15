package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11048 {

	public static void main(String[] args) throws IOException {
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
			}
		}
		dp[1][1] = arr[1][1];
		for(int i=2;i<=M;i++){
			dp[1][i] = dp[1][i-1]+arr[1][i];
		}
		for(int i=2;i<=N;i++){
			dp[i][1] = dp[i-1][1]+arr[i][1];
			for(int j=2;j<=M;j++){
				dp[i][j] = Math.max(dp[i][j-1]+arr[i][j],dp[i-1][j] + arr[i][j]);
				dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]);
			}
		}
		System.out.println(dp[N][M]);
	}

}
