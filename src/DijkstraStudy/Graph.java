package DijkstraStudy;

import java.util.Arrays;

public class Graph {
	/*
	 * 전체적인 순서 정리
	 	초기 상태: distance = [0, INF, INF, ...]
		반복 1: 시작점 방문 → 시작점과 연결된 거리 갱신
		반복 2: 방문 안 한 정점 중 최소 거리 선택 → 그 정점 거쳐 다른 거리 갱신
		...
		반복 끝: distance = 최단 거리 배열 완성

	 */

	private int vertices;	// 정점의 개수
	private int graphs[][];	// 인접 행렬 (가중치 저장)
	
	// 생성자: 정점 개수 n을 받아 그래프를 초기화
	public Graph(int n) {
		this.vertices = n;
		graphs = new int[vertices][vertices];
		
		for (int i = 0; i < n; i++) {		// 모든 간선 가중치를 무한대로 고치화 (연결 안 된 상태)
			for (int j = 0; j < n; j++) {
				graphs[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	public void link(int x, int y, int w) {		// 두 정점 사이에 간선 연결 (무방향 그래프)
		graphs[x][y] = w;
		graphs[y][x] = w;
	}
		
	public void dijkstra(int start) { 			// 다익스트라 알고리즘
		int distance[] = new int[vertices];		// 시작점으로부터의 i 정점까지 최단 거리 배열
		boolean[] isVisited = new boolean[vertices];	// i 정점 방문 여부 체크 배열
		
		for (int i = 0; i < vertices; ++i) {	// 모든 정점까지의 거리를 무한대로 초기화
			distance[i] = Integer.MAX_VALUE;
		}
		
		// 시작 정점 초기화
		distance[start] = 0;		// 시작점 -> 시작점 거리는 0
		isVisited[start] = true;	// 시작점 방문 처리
		
		for (int i = 0; i < vertices; ++i) {	
			if (distance[i] == Integer.MAX_VALUE) {	// Integer.MAX_VALUE를 하드코딩하면 2147483647
				System.out.print("INF ");
			} else {
				System.out.print(distance[i] + " ");
			}
		}
		
		System.out.println("");
		
		for (int i = 0; i < vertices; ++i) {	// 시작 정점과 직접 연결된 정점 거리 갱신 (아직 방문 안 된 정점만)
			if (!isVisited[i] && graphs[start][i] != Integer.MAX_VALUE) {
				distance[i] = graphs[start][i];
			}
		}
		
		for (int i = 0; i < vertices; ++i) {	// 시작점과 직접 연결된 정점 거리를 갱신 (아직 방문 안 된 정점만)
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.print("INF ");
			} else {
				System.out.print(distance[i] + " ");
			}
		}
		
		System.out.println(" ");
		
		// 한 단계씩 최단 거리 정점 선책 -> 다른 정점 거리 갱신 반복
		for (int a = 0; a < vertices-1; a++) {	// 정점 개수 -1 만틈 반복 (총 vertices-1 번 반복하면 모든 정점 처리)
			
			// 여기서부터 isVistied[min_index] = true;(96번) 까지 방문하지 않은 최소 거리 정점 선택
			// 더 이상 여녈된 정점 없으면 반복 종료
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			
			for (int i = 0; i < vertices; ++i) {	// 방문하지 않은 정점 중 최소 거리 정점 찾기
				if (!isVisited[i]) {
					if (distance[i] < min) {
						min = distance[i];
						min_index = i;
					}
				}
			}
			
			if (min_index == -1) {	// 안정하게 하기 위한 조건문 (바로 밑에)
				break;
			}	// 더 이상 갈 수 있는 정점이 없으면 종료
			
			// 해당 정점 방문 처리
			isVisited[min_index] = true; // min_index가 -1이면 ArrayIndexOutOfBoundsException 발생 가능함
			
			
			for (int i = 0; i < vertices; ++i) {	// 해당 정점을 거쳐서 가는 거리 갱신
				/*
				 * 아직 방문하지 않았고,
				 * 연결되어 있으며, 기존 거리보다 더 짧은 경우 갱신
				 */
				
				if (!isVisited[i] && graphs[min_index][i] != Integer.MAX_VALUE) {
					if (distance[min_index] + graphs[min_index][i] < distance[i]) {
						distance[i] = distance[min_index] + graphs[min_index][i];
					}
				}
			}
			
			// 출력 (매 단계마다 현재 최단 거리 배열 출력 [INF: 아직 갈 수 없는 정점])
			for (int i = 0; i < vertices; ++i) {
				if (distance[i] == Integer.MAX_VALUE) {
					System.out.print("INF ");
				} else {
					System.out.print(distance[i] + " ");
				}
			}
			
			System.out.println("");
		}
		
		System.out.println("결과: " + Arrays.toString(distance));
	}

}
