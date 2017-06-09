package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_2493 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		Stack<Integer> origin = new Stack<>();
		Stack<Integer> tmp = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[count+1];
		int item = Integer.parseInt(st.nextToken());
		origin.push(item);
		arr[1] = 0;
		for(int i=2;i<=count;i++){
			item = Integer.parseInt(st.nextToken());
			tmp.addAll(origin);
			int pCount = i-1;
			while(!tmp.isEmpty()){
				int popNum = tmp.pop();
				if(popNum>=item){
					arr[i] = pCount;
					break;
				}
				pCount--;
			}
			origin.push(item);
		}
		for(int i=1;i<arr.length;i++){
			System.out.println(arr[i]);
		}

	}

}
