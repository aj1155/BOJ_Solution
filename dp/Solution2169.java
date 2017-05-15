package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2169 {
	
	static int[][] result;
	static int[][] arr;
	static int[][] tmp;
	static int N,M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = new int[N+1][M+1];
		tmp = new int[2][M+2];
		result[1][1] = arr[1][1];
		for(int i=2;i<=M;i++){
			result[1][i] = result[1][i-1] + arr[1][i];
		}
		
		for(int i=2;i<=N;i++){
			tmp[0][0] = result[i-1][1];
			for(int j=1;j<=M;j++){
				tmp[0][j] = Math.max(tmp[0][j - 1], result[i - 1][j]) + arr[i][j];
			}
			tmp[1][M+1] = result[i - 1][M];
			for (int j = M; j >= 1; j--){
				tmp[1][j] = Math.max(tmp[1][j + 1], result[i - 1][j]) + arr[i][j];
			}		    
			for(int j=1;j<=M;j++){
				result[i][j] = Math.max(tmp[0][j], tmp[1][j]);
			}
		}
		for(int i=1;i<=N;i++){
			for(int j=1;j<=M;j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(result[N][M]);
	}
	

}
