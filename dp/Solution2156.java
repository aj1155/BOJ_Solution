package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/***
 * 
 * @author USER
 * 해당 잔을 안마시는 경우를 고려 해야 함 즉 dp[i-1] = 해당잔을 안마셔도 그 순간 최대가 되는 경우가 있음
 */

public class Solution2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] arr = new int[count+1];
		int[] dp = new int[count+1];
		for(int i=1;i<=count;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(count==1){
			System.out.println(arr[1]);
			return;
		}
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[1]+arr[2];
		int max = dp[2];
		for(int i=3;i<=count;i++){
			dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
			max = Math.max(max, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(max);
	}

}
