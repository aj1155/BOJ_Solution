package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Board{
	
	int x,y;
	
	public Board(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class BaekJoon2048 {
	
	static boolean[][] col;
	static List<Board> boards = new ArrayList<>();
	static int max;
	static int maxCount;
	static int gameCount;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[][] arr = new int[N][N];
		col = new boolean[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				arr[i][j] = input.nextInt();
				max = Math.max(max, arr[i][j]);
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(arr[i][j]==max){
					boards.add(new Board(i,j));
					maxCount++;
				}
			}
		}
		
		solution(arr,4,N);
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void solution(int[][] arr,int g,int N){
		if(g==4){
			for(int i=0;i<N;i++){
				for(int j=N-1;j>0;j--){
					if(arr[i][j]==arr[i][j-1] && col[i][j]==true){
						arr[i][j-1] += arr[i][j];
						arr[i][j]=0;
						col[i][j-1] = false;
					}
					while(arr[i][j]!=0 && arr[i][j-1]==0 && j>0){
						arr[i][j-1] = arr[i][j];
						arr[i][j] = 0;
						j--;
						if(j==0){
							break;
						}
					}
				}
			}
		}
		else if(g==6){
			for(int i=0;i<N;i++){
				for(int j=0;j<N-1;j++){
					if(arr[i][j]==arr[i][j+1]){
						arr[i][j+1] += arr[i][j];
						arr[i][j] = 0;
						j +=2;
					}
					while(arr[i][j]==0){
						arr[i][j] = arr[i][j-1];
						j++;
					}
				}
			}
		}
		else if(g==8){
			for(int j=0;j<N;j++){
				for(int i=N-1;i>0;i--){
					if(arr[i][j]==arr[i-1][j]){
						arr[i-1][j] += arr[i][j];
						arr[i][j] = 0;
						i -=2;
					}
					while(arr[i][j]==0){
						arr[i][j] = arr[i+1][j];
						i--;
					}
				}
			}
		}
		else if(g==2){
			for(int j=0;j<N;j++){
				for(int i=0;i<N-1;i++){
					if(arr[i][j]==arr[i+1][j]){
						arr[i+1][j] += arr[i][j];
						arr[i][j] = 0;
						i +=2;
					}
					while(arr[i][j]==0){
						arr[i][j] = arr[i-1][j];
						i++;
					}
				}
			}
		}
	}

}
