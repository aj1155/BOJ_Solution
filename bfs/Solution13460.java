package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Ball {
	int x;
	int y;
	public Ball(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution13460 {
	
	private static String[][] arr;
	private static Ball rea;
	private static Ball blue;
	private static Ball out;

	public static void main(String[] args) {
		// TOaO Auto-generatea methoa stub
		int N,M;
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		input.nextLine();
		arr = new String[N][M];
		for(int i=0;i<N;i++){
			String s = input.nextLine();
			for(int j=0;j<M;j++){
				arr[i][j] = s.substring(j, j+1);
				if(arr[i][j].equals("R")){
					rea = new Ball(i,j);
				}
				else if(arr[i][j].equals("B")){
					blue = new Ball(i,j);
				}
				else if(arr[i][j].equals("O")){
					out = new Ball(i,j);
				}
			}
		}
				
	}
	
	public static int search(int ax,int ay,int count){
		int rx = rea.x;
		int ry = rea.y;
		int bx = blue.x;
		int by = blue.y;
		
		if((ay==1 && by>ry) || (ay==-1 && by<ry)){
			for (int y = by+ay;; y=y+ay) {
				if(arr[y][bx].equals("O")) {return count;}
				else if(arr[y][bx]=="." && !(bx==rx && y==ry)) by=y;
				else break;
			}
			for (int y = ry+ay;; y=y+ay) {
				if(arr[y][rx].equals("O")) {count+=1; return count;}
				else if(arr[y][rx]=="." && !(bx==rx && y==by)) ry=y;
				else break;
			}
		}else if((ay==1 && by<=ry) || (ay==-1 && by>=ry)){
			for (int y = ry+ay;; y=y+ay) {
				if(arr[y][rx].equals("O")) {count+=1; rx=0;ry=0;}
				else if(arr[y][rx]=="." && !(bx==rx && y==by)) ry=y;
				else break;
			}
			for (int y = by+ay;; y=y+ay) {
				if(arr[y][bx].equals("O")) {count+=1; return count;}
				else if(arr[y][bx]=="." && !(bx==rx && y==ry)) by=y;
				else break;
			}
		}else if((ax==1 && bx>=rx) || (ax==-1 && bx<=rx)){
			for (int x = bx+ax;; x=x+ax) {
				if(arr[by][x].equals("O")) {return count;}
				else if(arr[by][x]=="." && !(by==ry && x==rx)) bx=x;
				else break;
			}
			for (int x = rx+ax;; x=x+ax) {
				if(arr[ry][x].equals("O")) {count+=1; return count;}
				else if(arr[ry][x]=="." && !(by==ry && x==bx)) rx=x;
				else break;
			}
		}else if((ax==1 && bx<rx) || (ax==-1 && bx>rx)){
			for (int x = rx+ax;; x=x+ax) {
				if(arr[ry][x]=="O") {count+=1; rx=0;ry=0;}
				else if(arr[ry][x]=="." && !(by==ry && x==bx)) rx=x;
				else break;
			}
			for (int x = bx+ax;; x=x+ax) {
				if(arr[by][x]=="O") {count+=1; return count;}
				else if(arr[by][x]=="." && !(by==ry && x==rx)) bx=x;
				else break;
			}
		}
		return count;
	}

}
