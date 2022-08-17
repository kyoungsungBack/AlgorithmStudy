package Baekjoon_11주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_14502 {
	static int N, M;
	static int[] mx = { -1, 1, 0, 0 };
	static int[] my = { 0, 0, -1, 1 };
	static Queue<Node> que;
	static int[][] map;
	static int[][] mapBuild;
	static int ans;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapBuild = new int[N][M];
		// 0: 빈칸
		// 1: 벽
		// 2: 바이러스
		// 벽 세우기 -> dfs
		// 바이러스가 퍼짐 -> bfs
		// 벽 세우기 -> 바이러스 퍼지기 -> 안전영역 개수확인

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		build(0);
		System.out.println(ans);
	}

	static void build(int cnt) {
		if (cnt == 3) {
			virus();
			ans = Math.max(ans, safeCount());
			return;
		}
		// dfs에서 배열에 따라 2중반복문도 가능
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					build(cnt + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	static void virus() {
		que = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mapBuild[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mapBuild[i][j] == 2) {
					que.add(new Node(i, j));
				}
			}
		}

		while (!que.isEmpty()) {
			Node cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int py = cur.y + my[i];
				int px = cur.x + mx[i];
				if (py >= 0 && py < N && px >= 0 && px < M) {
					if (mapBuild[py][px] == 0) {
						mapBuild[py][px] = 2;
						que.add(new Node(py, px));
					}
				}
			}
		}

	}

	static int safeCount() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mapBuild[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
}

class Node {
	int y;
	int x;

	public Node(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}
