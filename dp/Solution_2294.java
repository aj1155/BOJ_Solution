package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2294 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		int[] dp = new int[K+1];
		for(int i=0;i<N;i++){
			coins[i] = Integer.parseInt(br.readLine());
		}
		for(int i=1;i<=K;i++){
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		for(int coin : coins){
			for(int i=coin;i<=K;i++){
				if(dp[i-coin]!=Integer.MAX_VALUE){
					dp[i] = Math.min(dp[i], dp[i-coin] +1);
				}
			}
		}
		System.out.println((dp[K]!=Integer.MAX_VALUE) ? dp[K] : -1);
		
	}

}
