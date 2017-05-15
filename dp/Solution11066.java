package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11066 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<test;i++){
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[num];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<num;j++){
				arr[j] = Integer.parseInt(st.nextToken());
			}
		}
		

	}
	public static void solution(int[] arr){
		int[][] dp = new int[arr.length+3][arr.length+3];
		int len = arr.length;
		
	}

}
