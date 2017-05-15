package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Street {
	int x,y;
	
	public Street(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution2667 {
	
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		input.nextLine();
		arr = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];
		String s = "";
		List<Integer> result = new ArrayList<>();
		for(int i=1;i<=N;i++){
			s = input.nextLine();
			for(int j=1;j<=N;j++){
				arr[i][j] = s.charAt(j-1) - '0';
				visited[i][j] = false;
			}
		}
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				if(arr[i][j]==1 && visited[i][j]==false){
					result.add(bfs(i,j));
				}
				
			}
		}
		/*
		for(int i=0;i<=N+1;i++){
			for(int j=0;j<=N+1;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		*/
		Integer[] print = result.toArray(new Integer[0]);
		Arrays.sort(print);
		System.out.println(result.size());
		for(int num : print){
			System.out.println(num);
		}
		

	}
	
	public static int bfs(int i,int j){
		Queue<Street> q = new LinkedList<>();
		q.offer(new Street(i,j));
		int count=0;
		while(!q.isEmpty()){
			Street st = q.poll();
			if(visited[st.x][st.y]==false){
				count++;
				visited[st.x][st.y] = true;
			}
			if(arr[st.x-1][st.y]==1 && visited[st.x-1][st.y]==false){
				q.offer(new Street(st.x-1,st.y));
			}
			if(arr[st.x][st.y-1]==1 && visited[st.x][st.y-1]==false){
				q.offer(new Street(st.x,st.y-1));
			}
			if(arr[st.x+1][st.y]==1 && visited[st.x+1][st.y]==false){
				q.offer(new Street(st.x+1,st.y));
			}
			if(arr[st.x][st.y+1]==1 && visited[st.x][st.y+1]==false){
				q.offer(new Street(st.x,st.y+1));
			}
			
		}
		return count;
	}

}
