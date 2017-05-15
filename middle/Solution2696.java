package middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Solution2696 {
	
	static List<Integer>[] result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		result = new ArrayList[test];
		for(int i=0;i<test;i++){
			int num = input.nextInt();
			int[] arr = new int[num];
			result[i] = new ArrayList<>();
			for(int j=0;j<num;j++){
				arr[j] = input.nextInt();
			}
			quickSelction(arr,i);
		}
		for(List<Integer> list : result){
			System.out.println(list.size());
			for(int i=0;i<list.size();i++){
				if(i>0 && i%10==0) System.out.println();
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}

	}
	
	public static void quickSelction(int[] arr,int index){
		int mid = arr[0];
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); 
		PriorityQueue<Integer> right = new PriorityQueue<>();
		result[index].add(mid);
		for(int i=1;i<arr.length;i++){
			if(arr[i]>mid){
				right.offer(arr[i]);
			}
			else if(arr[i]<mid){
				left.offer(arr[i]);
			}
			if(i%2==0){
				if(left.size()>right.size()){
					right.offer(mid);
					mid = left.poll();
				}
				else if(right.size()>left.size()){
					left.offer(mid);
					mid = right.poll();
				}
				result[index].add(mid);
			}
			
		}
			
	}
	

}
