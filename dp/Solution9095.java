package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution9095 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[] = {1,2,3};
		int count = Integer.parseInt(br.readLine());
		int num[] = new int[count];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<count;i++){
			num[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, num[i]);
		}
		arr = solution(arr,max);
		for(int i : num){
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int[] solution(int[] numberType,int N){
		int[] result = new int[N+1];
		result[0] = 1;
		
		for(int i=1;i<=N;i++){
			if(i>=1){
				result[i] += result[i-1];
			}
			if(i>=2){
				result[i] += result[i-2];
			}
			if(i>=3){
				result[i] += result[i-3];
			}
		}
		
		/*
		for(int i=0;i<numberType.length;i++){
			for(int j=1;j<=N;j++){
				if(j>=numberType[i]){
					result[j] += result[j-numberType[i]];
				}
			}
		}
		*/
		return result;
		
	}

}
