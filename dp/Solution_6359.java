package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_6359 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0;i<test;i++){
			int row = Integer.parseInt(br.readLine());
			System.out.println(escape(row));
		}
	}
	
	public static int escape(int row) {
		int[] dp = new int[row+1];
		for(int i=1;i<=row;i++){
			int index = i;
			for(int j=index;j<=row;j++){
				if(j%index==0){
					if(dp[j]==1) dp[j] = 0;
					else dp[j] = 1;
				}
			}
		}
		int sum = Arrays.stream(dp).parallel().sum();
		return sum;
	}

}
