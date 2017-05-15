package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1126 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[num+1];
		int[][] dp = new int[52][500005];
		for(int i=1;i<=num;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 500002; j++) {
				dp[i][j] = -2;  //ÃÊ±âÈ­
			}
		}
	}

}
