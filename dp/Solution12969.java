package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution12969 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		String[] arr = s.split(" ");
		bw.write(solution(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])));
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	public static String solution(int N,int K){
		char[] arr = new char[N];
		StringBuilder sb = new StringBuilder();
		char temp;
		int i,j,k;
		int val;
		for(i=0;i<N/3;i++) arr[i] = 'C';
		val = (N+1)/3 + i;
		for(;i<val;i++) arr[i] = 'B';
		for(;i<N;i++) arr[i] = 'A';
		for(i=0;i<K;i++){
			for(j=0;j<N-1;j++) if(arr[j]>arr[j+1]) break;
			if(j==N-1){
				return "-1";
			}
			temp = arr[j];
			arr[j] = arr[j+1];
			arr[j+1] = temp;
		}
		for(i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		return sb.toString();
	}


}
