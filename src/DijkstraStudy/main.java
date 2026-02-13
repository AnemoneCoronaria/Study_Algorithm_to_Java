package DijkstraStudy;

public class main {
	/*
	 * 그래프 최단 경로 공부 (6번)
	 * 다익스트라 알고리즘 (Dijkstra's Algorithm)
	 * 
	 * 하나의 시작 정점에서 다른 모든 정점까지의 최단 거리를 찾는 알고리즘
	 * 음수 간선이 없을 때만 사용 가능
	 * 
	 * 방법:
	 * 1. 시작 정점 선택, 시작점 거리는 0, 나머지는 무한대(INF)로 초기화
	 * 2. 방문하지 않은 정점 중 가장 거리가 짧은 정점을 선택
	 * 3. 선택한 정점을 거쳐 다른 정점으로 가는 거리가 기존 거리보다 짧으면 갱신
	 * 4. 모든 정점이 방문될 때까지 2~3 반복
	 * 
	 * 빅오:
	 * 시간복잡도 -> O(V^2) (인접행렬 기준), O((V+E) log V) (우선순위 큐 사용 시)
	 * 공간복잡도 -> O(V) (거리 배열 + 방문 배열)
	 * 안정성 -> 안정 정렬 개념 없음
	 * 
	 * Study of Shortest Path in Graph (6)
	 * Dijkstra's Algorithm finds the shortest path from a single source vertex 
	 * to all other vertices in a weighted graph without negative edges.
	 * 
	 * Steps:
	 * 1. Initialize distances: start vertex = 0, others = INF
	 * 2. Pick the unvisited vertex with the smallest distance
	 * 3. Update distances of neighbors through the selected vertex
	 * 4. Repeat until all vertices are visited
	 * 
	 * Time Complexity -> O(V^2) with adjacency matrix, O((V+E) log V) with priority queue
	 * Space Complexity -> O(V)
	 * Unstable algorithm (no concept of stability)
	 */


	public static void main(String[] args) {
		Graph g = new Graph(6);
		
		g.link(0, 1, 3);
		g.link(0, 2, 6);
		g.link(1, 2, 11);
		g.link(1, 3, 8);
		g.link(1, 4, 2);
		g.link(2, 4, 17);
		g.link(2, 5, 4);
		g.link(3, 1, 8);
		g.link(3, 4, 15);
		g.link(4, 5, 1);
		
		g.dijkstra(0);
		System.out.println("--------------------------");
		g.dijkstra(5);
	}

}
