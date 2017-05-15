package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution13398 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+2];
		int[][] dp = new int[2][100010];
		st = new StringTokenizer(br.readLine());
		for(int i=2;i<=n+1;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		for(int i=2;i<=n+1;i++){
			dp[0][i] = Math.max(dp[0][i-1] + arr[i], arr[i]);
			dp[1][i] = Math.max(dp[0][i-2] + arr[i], dp[1][i-1]+arr[i]);
			max = Math.max(Math.max(dp[0][i], max),dp[1][i]);
		}
		System.out.println(max);
	
	}
	
}
