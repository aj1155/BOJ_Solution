package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution11058 {
	
	static long[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		dp = new long[101];
		for(int i=0;i<6;i++){
			dp[i] = i;
		}
		if(num>5){
			for(int i=6;i<=num;i++){
				dp[i]++;
				dp[i] = Math.max(dp[i], maxSolution(i-3,2));
				//System.out.println(i+" "+dp[i]);
			}
		}
		System.out.println(dp[num]);
	}
	
	public static long maxSolution(int N,int j){
		if (N == 3) {
            return dp[3]*j;
        }
        return Math.max(dp[N]*j, maxSolution(N-1,++j));
      
	}

}
