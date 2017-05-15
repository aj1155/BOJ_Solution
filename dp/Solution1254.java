package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1254 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if(s.length()==1){
			System.out.println(s.length());
			return;
		}
		char[] W = s.toCharArray();
		StringBuilder sb = new StringBuilder(s);
		char[] RS = sb.reverse().toString().toCharArray();
		if(sb.toString().equals(s)){
			System.out.println(s.length());
			return;
		}
		int[] fail = new int[s.length()];
		int max = Integer.MIN_VALUE;
		for(int i=1,j=0;i<s.length();i++){
			if(j > 0 && W[i] != RS[j]) j = 0;
			if(W[i] == RS[j]){
				fail[i] = ++j;
				max = Math.max(max, fail[i]);
			}
		}
		String temp = sb.substring(max);
		sb = new StringBuilder(s);
		System.out.println(sb.append(temp).length());
		
		
	}

}
