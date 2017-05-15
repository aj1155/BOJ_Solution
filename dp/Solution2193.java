package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 그 전에 값에서 뒤에 0을 추가 하는 경우와,1을 추가 하는 2가지 경우가 있음
 * 0을 추가 하는 경우는 바로 그전 dp값을 그대로 더해주면 되고 1을 추가 하는 경우는
 * 그전에 값에서 0으로 끝나는 경우인데 그전에 값에서 0으로 끝나는 값은 그 이전 이전 값이니
 * d[i-1] + d[i-2]를 해주면 됌 결국은 피보나치임
 */
public class Solution2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[1000001];
		
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i=3;i<=n;i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[n]);
	}

}
