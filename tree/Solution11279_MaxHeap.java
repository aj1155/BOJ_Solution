package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class MaxHeap {
	
	private int[] heap = new int[1000001];
    private int count = 0;
    
    public void offer(int num){
    	int i = (count+1);
    	
    	while(i > 1){
    		if(heap[i/2] >= num){
    			break;
    		}
    		else{
    			heap[i] = heap[i/2];
    			i /=2;
    		}
    	}
    	
    	heap[i] = num;
    	count++;
    }
    
    public int poll(){
    	
    	if( count == 0){
    		return 0;
    	}
    	
    	int out = heap[1];
    	heap[1] = heap[count];
    	//1 2 3 4 5 6 7 8 9
    	for(int i=1; i*2 < count ;){
    		int maxValue = Math.max(heap[i],Math.max(heap[i*2], heap[i*2+1]));
    		if(heap[i] == maxValue){
    			break;
    		}
    		else if(maxValue == heap[i*2]){
    			swap(heap,i,i*2);
    			i*=2;
    		}
    		else {
    			swap(heap,i,i*2+1);
    			i = i*2 +1;
    		}
    	}
    	count--;
    	return out;
    }
    
    private void refactoring(){
    	heap = Arrays.copyOf(heap, heap.length*2+1);
    }
    
    private void swap(int[] arr,int index1,int index2){
    	int temp = arr[index1];
    	arr[index1] = arr[index2];
    	arr[index2] = temp;
    }
}

public class Solution11279_MaxHeap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		MaxHeap mh = new MaxHeap();
		while(count>0){
			int num = Integer.parseInt(br.readLine());
			if(num==0){
				list.add(mh.poll());
			}else{
				mh.offer(num);
			}
			count--;
		}
		list.forEach(System.out::println);
		
	}

}
