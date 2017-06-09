package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution_1922_min_spaning {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rslt = 0;
        // 컴퓨터의 수
        int N = Integer.parseInt(br.readLine());       
        // 간선의 수
        int M = Integer.parseInt(br.readLine());    
        int[][] map = new int[N+1][N+1];      
        for(int i = 0; i < M; i++)   {
            String line = br.readLine();      
            String[] sec = line.split(" ");
             
            int s = Integer.parseInt(sec[0]); // start
            int e = Integer.parseInt(sec[1]); // end
            int c = Integer.parseInt(sec[2]); // cost
             
            map[s][e] = map[e][s] = c;
        }
         
        // passed computer
        int[] passedComputer = new int[N];
        passedComputer[0] = 1;
         
        int passedComputerCnt = 1;
        while(passedComputerCnt < N) {
            int min = Integer.MAX_VALUE;
            int minComputerFrom = 0;
            int minComputerTo = 0;
            for(int i = 0; i < passedComputerCnt; i++)   {
                for(int j = 1; j <= N; j++)  {
                    if(map[passedComputer[i]][j] < min && map[passedComputer[i]][j] != 0)    {
                         
                        boolean isCycle = false;
                        for(int k = 0; k < passedComputerCnt; k++)   {
                            if(passedComputer[k] == j)  {
                                isCycle = true;
                                map[passedComputer[i]][j] = 0;
                                map[j][passedComputer[i]] = 0;
                                break;
                            }
                        }
                         
                        if(!isCycle){
                            min = map[passedComputer[i]][j];
                            minComputerFrom = passedComputer[i];
                            minComputerTo = j;
                        }
                    }
                }
            }
 
            passedComputer[passedComputerCnt] = minComputerTo;
            passedComputerCnt++;
            rslt = rslt + min;
        }
        System.out.println(rslt);

	}
	
	

}
