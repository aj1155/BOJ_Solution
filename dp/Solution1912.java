package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* �ڱ� �ڽ�, ���� dp���� �ڱ� �ڽŰ��� �� ������ ū ��� 
 * 
 */
public class Solution1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max;
		dp[0] = arr[0];
		max = dp[0];
		for(int i=1;i<n;i++){
			dp[i] = arr[i];
			if(arr[i]<dp[i-1]+arr[i]){
				dp[i] = arr[i] + dp[i-1];
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
