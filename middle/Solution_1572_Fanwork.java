package middle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;




public class Solution_1572_Fanwork {
	
	static long[] tree;
	static int[] arr;
	private static int maxsize;
	private static int height;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Long> list = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		height = (int)(Math.ceil(Math.log(N) / Math.log(2)));
		maxsize = 2 * (int) Math.pow(2, height) - 1;
		tree = new long[N+1];
		arr = new int[N+1];
		for(int i=1; i<=N; i++){
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			update(tree,i,num);
		}
		System.out.println(Arrays.toString(tree));
		while(K>0 || M>0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==1){
				update(tree,b,c-arr[b]);
				arr[b] = c;
				M--;
			}
			else if(a==2){
				list.add(sum(tree,c) - sum(tree,b-1));
				K--;
			}
	
		}
		list.forEach(System.out::println);
	}
	
	public static long sum(long[] tree,int i){
		long ans = 0;
		while(i > 0){
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
	
	public static void update(long[] tree,int i,long diff) {
		while (i < tree.length) {
			tree[i] += diff;
			i += (i & -i);
		}
	}

}
