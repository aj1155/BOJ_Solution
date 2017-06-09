package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1010_nCm_Combination {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		List<BigInteger> result = new ArrayList<>();
		BigInteger bigNum;
		while(count>0){
		   	st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        bigNum = new BigInteger("1");
	        if(N!=M){
	        	for (int i = M; i > M - N; i--) {
	        		bigNum = bigNum.multiply(BigInteger.valueOf(i));
	            }

	            for (int i = N; i > 0; i--) {
	                bigNum = bigNum.divide(BigInteger.valueOf(i));
	            }

	        }
	        result.add(bigNum);
	        count--;
		}
		result.forEach(System.out::println);
	}

}
