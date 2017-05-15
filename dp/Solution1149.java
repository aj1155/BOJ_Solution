package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[3];
		int[][] dp = new int[N+1][3];
		int min = Integer.MAX_VALUE;
		String st;
		for(int i=1;i<=N;i++){
			st = br.readLine();
			arr = st.toString().split(" ");
			dp[i][0] = Math.min(dp[i-1][1]+Integer.parseInt(arr[0]),dp[i-1][2]+Integer.parseInt(arr[0]));
			dp[i][1] = Math.min(dp[i-1][0]+Integer.parseInt(arr[1]),dp[i-1][2]+Integer.parseInt(arr[1]));
			dp[i][2] = Math.min(dp[i-1][1]+Integer.parseInt(arr[2]),dp[i-1][0]+Integer.parseInt(arr[2]));	
			if(i==N){
				min = Math.min(Math.min(dp[i][0], dp[i][1]),dp[i][2]);
			}
		}
		System.out.println(min);
	}

}
