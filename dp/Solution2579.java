package dp;

/***
 * 계단을 밟는 경우는 i-3번째 + i-2 + i
 * i-3 + i-1 + i 이렇게 2가지
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int step = Integer.parseInt(br.readLine());
		int[] arr = new int[step+1];
		arr[0] = 0;
		for(int i=1;i<=step;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[step+1];
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[1]+arr[2];
		for(int i=3;i<=step;i++){
			dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[step]);
	}

}
