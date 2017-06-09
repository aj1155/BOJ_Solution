package segmenttree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_10999_Fanwork {
	
	static long[] tree;
	static int[] arr;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Long> list = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		tree = new long[N+1];
		
		for(int i=1; i<=N; i++){
			int num = Integer.parseInt(br.readLine());
			update(tree,i,num);
		}
		while(K>0 || M>0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==1){
				int d = Integer.parseInt(st.nextToken());
				update(tree,d,b);
				update(tree,-d,c+1);
				M--;
			}
			else if(a==2){
				list.add(sum(tree,c) - sum(tree,b-1));
				K--;
			}
	
		}
		list.forEach(System.out::println);
	}
	
	public static void update(long[] tree,int diff,int index){
		while(index<tree.length){
			tree[index] +=diff;
			index += (index & -index);
		}
	}
	
	public static long sum(long[] tree,int index){
		long ans = 0;
		while(index>0){
			ans += tree[index];
			index -= (index & -index);
		}
		return ans;
	}

}
