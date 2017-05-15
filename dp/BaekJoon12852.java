package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BaekJoon12852 {
	


	public static void main(String[] args) throws IOException {	
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String num = br.readLine();
		int n = Integer.parseInt(num);
		int[] arr = new int[n+1];
		String[] str = new String[n+1];
		StringBuilder sb = new StringBuilder();
		arr[1] = 0;
		str[1] = "1";
	    for (int i = 2; i <= n; i++)
	    {
	        arr[i] = arr[i - 1] + 1;
	        sb.append(i+" "+str[i-1]);
	        if(i%3==0){
	        	if(arr[i/3]+1<arr[i]){
	        		arr[i] = arr[i/3]+1;
	        		sb.delete(0, sb.length()).append(i + " " + str[i/3]);
	        	}
	        }
	        if(i%2==0){
	        	if(arr[i/2]+1<arr[i]){
	        		arr[i] = arr[i/2]+1;
	        		sb.delete(0, sb.length()).append(i + " " + str[i/2]);
	        	}
	        }
	        str[i] = sb.toString();
	        sb.delete(0, sb.length());
	        
	    }
	    bw.write(String.valueOf(arr[n])+"\n");
	    bw.write(String.valueOf(str[n]));
		bw.flush();
		br.close();
		bw.close();


	}	
}
