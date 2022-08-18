package Baekjoon_11주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_13549 {
	static int N, K;
	static int result = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] move = { 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];

		// 같은 위치가 될 때 까지 반복 -> while(!que.isEmpty)
		// 수빈이가 작을 땐 -> 2배가 효과적 -> if(N < K)
		// 수빈이의 이동방향 -> -1 / +1 / 2배
		// 동생이 작을 땐 -> -1이 효과적 -> else if(N > K)

		bfs(0);
		System.out.println(result);
	}

	static void bfs(int cnt) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(N, 0));
		visited[N] = true;
		// 모든 값에 대해 확인
		// 최소를 찾아가는 과정이 다익스트라와 유사
		// 시작 -> 이동한 좌표 확인 -> 확인이 더 필요(범위o, 방문x) -> 방문체크 후 큐에 넣기
		while (!que.isEmpty()) {
			Point cur = que.poll();
			if (cur.x == K) {
				result = Math.min(result, cur.time);
			}

			for (int i = 0; i < 3; i++) {
				int p = 0;
				if (i == 0) {
					p = cur.x * move[i];
				} else {
					p = cur.x + move[i];
				}

				if (p >= 0 && p <= 100000) {
					if (!visited[p]) {
						if (i == 0) {
							visited[p] = true;
							que.add(new Point(p, cur.time));
						} else {
							visited[p] = true;
							que.add(new Point(p, cur.time + 1));
						}
					}
				}
			}
		}
	}
	static class Point {
		int x;
		int time;

		public Point(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
	}
}

