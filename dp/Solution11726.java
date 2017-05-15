package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==1){
			System.out.println(1);
			return;
		}
		long [] dp = new long[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=n;i++){
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %=10007;
		}
		System.out.println(dp[n]);
		// 11 + 2 + 8 + 15 
	}
}
