package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1932 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		int arr[][] = new int[num+1][num+1];
		int dp[][] = new int[num+1][num+1];
		
		for(int i=1;i<=num;i++){
			Arrays.fill(arr[i], 0);
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=1;i<=num;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][1] = arr[1][1];
		for(int i=2;i<=num;i++){
			for(int j=1;j<=i;j++){
				dp[i][j] = dp[i-1][j-1] + arr[i][j];
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + arr[i][j]);
			}
		}
		int max = -1;
		for(int i=1;i<=num;i++){
			max = Math.max(max, dp[num][i]);
		}
		System.out.println(max);
	}

}
