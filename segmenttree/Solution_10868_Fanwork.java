package segmenttree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



class SegmentTree_Min {
    Node[] tree;
	private int maxsize;
	private int height;
	
	private final int STARTINDEX = 0;
	private final int ENDINDEX;
	private final int ROOT = 0;
	
	public SegmentTree_Min(int size) {
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
	
	public long getMin(int queryStart, int queryEnd){
	    if(queryStart < 0 || queryEnd > tree.length){
	           return -1;
	    }
	     
	    return getMinUtil(STARTINDEX,ENDINDEX,queryStart, queryEnd, ROOT);
	}
	
    public void update(int update, int updatePos, long[] elements) {
	        elements[updatePos] = update;
	        updateTreeUtil(STARTINDEX, ENDINDEX, updatePos, update, ROOT);
	}
	
	
	
	private long constructSegmentTreeUtill(long[] elements, int startIndex, int endIndex,int current){
		
		if(startIndex == endIndex){
			tree[current] = new Node(startIndex,endIndex,elements[startIndex]);
			return tree[current].val;
		}
		int mid = mid(startIndex,endIndex);
		
		tree[current] = new Node(startIndex,endIndex,Math.min(constructSegmentTreeUtill(elements,startIndex,mid,leftchild(current)),
				constructSegmentTreeUtill(elements,mid+1,endIndex,rightchild(current)))); 
		
		return tree[current].val;
	}
	
	private long getMinUtil(int startIndex,int endIndex,int queryStart,int queryEnd,int current){		
		if (endIndex < queryStart || startIndex > queryEnd){
            return Long.MAX_VALUE;
        }
		if(queryStart<=tree[current].left && queryEnd>=tree[current].right){
			return tree[current].val;
		}
				
		int mid = mid(startIndex,endIndex);
		
		return Math.min(getMinUtil(startIndex,mid,queryStart,queryEnd,leftchild(current)), 
				getMinUtil(mid+1,endIndex,queryStart,queryEnd,rightchild(current)));
	}
	
	private void updateTreeUtil(int startIndex,int endIndex,int updatePos, long update, int current){
		if(updatePos < startIndex || updatePos > endIndex){
			return;
		}
		tree[current].val = Math.min(tree[current].val ,update);
		if(startIndex != endIndex){
			int mid = mid(startIndex,endIndex);
			updateTreeUtil(startIndex,mid,updatePos,update,leftchild(current));
			updateTreeUtil(mid+1, endIndex, updatePos, update, rightchild(current));
		}
	}
	
	private class Node {
		int left;
		int right;
		long val = Long.MAX_VALUE;
		
		public Node(int left,int right,long val){
			this.left = left;
			this.right = right;
			this.val = val;
		}
		
		@Override
		public String toString(){
			return String.format("left %d,right %d,val %d", left,right,val);
		}
	}
	
}

public class Solution_10868_Fanwork {
	


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Long> list = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		
		long[] elements = new long[N];
		for(int i=0;i<N;i++){
			elements[i] = Integer.parseInt(br.readLine());
		}
		
		 SegmentTree_Min segmentTree = new SegmentTree_Min(N);
	        segmentTree.constructSegmentTree(elements);
		while(M>0){
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			list.add(segmentTree.getMin(i-1, j-1));
			M--;
		}
		list.forEach(System.out::println);
		

	}
	
	

}
