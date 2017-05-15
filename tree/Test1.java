package tree;

import java.util.Arrays;

class Tree {
    long[] tree;
	private int maxsize;
	private int height;
	private int result;
	
	private final int STARTINDEX = 0;
	private final int ENDINDEX;
	private final int ROOT = 0;
	private final int a;
	private final int b;
	
	public Tree(int size,int a ,int b) {
		height = (int)(Math.ceil(Math.log(size) / Math.log(2)));
		maxsize = 2 * (int) Math.pow(2, height) - 1;
		tree = new long[maxsize];
		ENDINDEX = size - 1;
		this.a = a;
		this.b = b;
	}
	
	private int leftchild(int pos){
		return 2 * pos +1;
	}
	
	private int rightchild(int pos){
		return 2 * pos +2;
	}
	
	private int mid(int start, int end){
		return (start + (end - start) / 2);
	}
	
	public void constructSegmentTree(long[] elements) {
	     constructSegmentTreeUtill(elements, STARTINDEX, ENDINDEX, ROOT);	
	}
	
	public int getResult(){
		return result;
	}
	

	
	private long constructSegmentTreeUtill(long[] elements, int startIndex, int endIndex,int current){
		
		if(startIndex == endIndex){
			tree[current] = elements[startIndex];
			return tree[current];
		}
		
		int mid = mid(startIndex,endIndex);
		
		long num1 = constructSegmentTreeUtill(elements,startIndex,mid,leftchild(current));
		long num2 = constructSegmentTreeUtill(elements,mid+1,endIndex,rightchild(current));
		if((num1==a && num2==b) || (num1==b && num2==a)){
			result = height-(int)(Math.log(current+1) / Math.log(2));
		}
		if(num1==a || num1==b){
			tree[current] = num1;
			return tree[current];
		}
		if(num2==a || num2==b){
			tree[current] = num2;
			return tree[current];
		}
		tree[current] =
				num1; 
		
		return tree[current];
	}
	

	
}


public class Test1 {

	public static void main(String[] args) {
		System.out.println(solution(8,4,7));
	}
	
	public static int solution(int n, int a, int b)
    {
        
        long[] elements = new long[n];
        for(int i=0;i<n;i++){
            elements[i] = i+1;
        }
        
		Tree tree = new Tree(8,a,b);
		tree.constructSegmentTree(elements);
		int answer = tree.getResult();

        return answer;
    }
	
	

}
