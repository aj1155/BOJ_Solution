package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2239 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		int[] dp = new int[K+1];
		dp[0] = 1;
		for(int i=0;i<N;i++){
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for(int coin : coins){
			for(int i=1;i<=K;i++){
				if(i>=coin){
					dp[i] += dp[i-coin];
				}
			}
		}
		System.out.println(dp[K]);
		

	}

}
