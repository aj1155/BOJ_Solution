package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1786 {
	
	private static final int max = 1000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String find = br.readLine();
		int[] fail = new int[find.length()];
		char[] S = Arrays.copyOf(origin.toCharArray(),origin.length()+1);
		char[] W =  Arrays.copyOf(find.toCharArray(), find.length()+1);
		List<Integer> result = new ArrayList<>();
		int N = origin.length();
		int M = find.length();
		
		for(int i=1,j=0;i<M;i++){
			while(j > 0 && W[i] != W[j]) j = fail[j-1];
			if(W[i] == W[j]) fail[i] = ++j;
		}
		for(int i=0,j=0;i<N;i++){
			while(j > 0 && S[i] != W[j]) j = fail[j-1];
			
			if(S[i] == W[j]){
				if(j == M-1){
					result.add(i-M+2);
					j = fail[j];
				}
				else j++;
			}
		}
		System.out.println(result.size());
		result.forEach(row -> System.out.print(row+" "));
	}

}
