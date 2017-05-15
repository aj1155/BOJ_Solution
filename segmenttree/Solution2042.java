package segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class SegmentTree {
    Node[] tree;
	private int maxsize;
	private int height;
	
	private final int STARTINDEX = 0;
	private final int ENDINDEX;
	private final int ROOT = 0;
	
	public SegmentTree(int size) {
		height = (int)(Math.ceil(Math.log(size) / Math.log(2)));
		maxsize = 2 * (int) Math.pow(2, height) - 1;
		tree = new Node[maxsize];
		ENDINDEX = size - 1;
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
	
	public long getSum(int queryStart, int queryEnd){
	    if(queryStart < 0 || queryEnd > tree.length){
	           return -1;
	    }
	     
	    return getSumUtil(STARTINDEX,ENDINDEX,queryStart, queryEnd, ROOT);
	}
	
    public void update(int update, int updatePos, long[] elements) {
	        long updatediff = update - elements[updatePos];
	        elements[updatePos] = update;
	        updateTreeUtil(STARTINDEX, ENDINDEX, updatePos, updatediff, ROOT);
	}
	
	
	
	private long constructSegmentTreeUtill(long[] elements, int startIndex, int endIndex,int current){
		
		if(startIndex == endIndex){
			tree[current] = new Node(startIndex,endIndex,elements[startIndex]);
			return tree[current].sum;
		}
		
		int mid = mid(startIndex,endIndex);
		
		tree[current] = new Node(startIndex,endIndex,constructSegmentTreeUtill(elements,startIndex,mid,leftchild(current)) +
				constructSegmentTreeUtill(elements,mid+1,endIndex,rightchild(current))); 
		
		return tree[current].sum;
	}
	
	private long getSumUtil(int startIndex,int endIndex,int queryStart,int queryEnd,int current){		
		if (endIndex < queryStart || startIndex > queryEnd){
            return 0;
        }
		if(queryStart<=tree[current].left && queryEnd>=tree[current].right){
			return tree[current].sum;
		}
				
		
		int mid = mid(startIndex,endIndex);
		
		return getSumUtil(startIndex,mid,queryStart,queryEnd,leftchild(current)) +
				getSumUtil(mid+1,endIndex,queryStart,queryEnd,rightchild(current));
	}
	
	private void updateTreeUtil(int startIndex,int endIndex,int updatePos, long update, int current){
		if(updatePos < startIndex || updatePos > endIndex){
			return;
		}
		tree[current].sum = tree[current].sum + update;
		if(startIndex != endIndex){
			int mid = mid(startIndex,endIndex);
			updateTreeUtil(startIndex,mid,updatePos,update,leftchild(current));
			updateTreeUtil(mid+1, endIndex, updatePos, update, rightchild(current));
		}
	}
	
	private class Node {
		int left;
		int right;
		long sum;
		
		public Node(int left,int right,long sum){
			this.left = left;
			this.right = right;
			this.sum = sum;
		}
		
		@Override
		public String toString(){
			return String.format("left %d,right %d,sum %d", left,right,sum);
		}
	}
	
}

public class Solution2042 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] elements = new long[N];
		for(int i=0;i<N;i++){
			elements[i] = Integer.parseInt(br.readLine());
		}
        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.constructSegmentTree(elements);
        long num = segmentTree.getSum(1, 5);
        List<Long> list = new ArrayList<>();
        while(K>0 || M>0){
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		if(a==1){
    			M--;
    			segmentTree.update(c, b-1,elements);
    		}
    		else if(a==2){
    			K--;
    			list.add(segmentTree.getSum(b-1, c-1));
    		}
        }
        list.forEach(System.out::println);
	}

}
