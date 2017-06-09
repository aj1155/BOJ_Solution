package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

class Node_1854 implements Comparable<Node_1854> {

    int node;
    int cost;

    Node_1854(int node, int cost) {

        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node_1854 o) {

        return this.cost < o.cost ? -1 : 1;
    }
}

public class Solution_1854_K_NUM {
	
	static final int INF = 100000000;

    public static void main(String[] args) throws IOException {

        int N, M, K;
        int[][] W = new int[1001][1001];

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N + 1];


        for (int i = 0; i < N + 1; i++) {

            distQueue[i] = new PriorityQueue<Integer>(K,Collections.reverseOrder());
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            W[a][b] = c;
        }

        // solve
        PriorityQueue<Node_1854> pq = new PriorityQueue<>();

        pq.add(new Node_1854(1, 0));
        distQueue[1].add(0);

        while (!pq.isEmpty()) {

            Node_1854 u = pq.poll();


            for (int adjNode = 1; adjNode <= N; adjNode++) {

                // 연결된 모든 노드에 대하여
                if (W[u.node][adjNode] != 0) {

                    // 저장된 경로가 K개가 안될 경우 그냥 추가한다.
                    if (distQueue[adjNode].size() < K) {

                        distQueue[adjNode].add(u.cost + W[u.node][adjNode]);

                        pq.add(new Node_1854(adjNode, u.cost + W[u.node][adjNode]));
                    }
                    // 저장된 경로가 K개이고, 현재 가장 큰 값보다 작다면
                    else if (distQueue[adjNode].peek() > u.cost + W[u.node][adjNode]) {

                        distQueue[adjNode].poll();
                        distQueue[adjNode].add(u.cost + W[u.node][adjNode]);

                        pq.add(new Node_1854(adjNode, u.cost + W[u.node][adjNode]));
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {

            if (distQueue[i].size() == K) {
            	System.out.println(distQueue[i].peek());

            } else {
            	System.out.println(-1);
            }
        }


    } // ~main
}
