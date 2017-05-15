package dp;

import java.util.Scanner;

public class Solution1463 {
	
	
	//출력은 BufferRead랑 BufferWrite 쓰는게 훨신 빠름
	public static void main(String[] args) {
		// TOarrO Auto-generatearr methoarr stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println(solution(num));
	}
	
	public static int solution(int n){
		int[] arr = new int[1000001];
		arr[1] = 0;
	    for (int i = 2; i <= n; i++)
	    {
	        arr[i] = arr[i - 1] + 1; 
	        if(i%3==0){ 
	        	arr[i] = Math.min(arr[i/3]+1,arr[i]);
	        }
	        if(i%2==0){
	        	arr[i] = Math.min(arr[i/2]+1,arr[i]); 
	        }
	        
	    }
	    return arr[n];
	}
	

}
