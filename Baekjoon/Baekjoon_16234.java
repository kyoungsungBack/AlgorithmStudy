package Baekjoon_11주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_16234 {
	static int N;
	static int L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] mx = { -1, 1, 0, 0 };
	static int[] my = { 0, 0, -1, 1 };
	static Queue<Point> que;
	static ArrayList<Point> list;
	static int ans;
	static boolean isMove = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<>(); // 이동할 수 있는 구역확인
		list = new ArrayList<>(); // 이동이 발생한 구역 담기
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		// 이동이 발생하지 않을 때 까지 반복
		while (true) {
			isMove = false;
			visited = new boolean[N][N];
			// 모든 배열에 방문하지 않은 곳 방문
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			// 반복문 돌고 인구이동 있있으면 isMove->true
			if (!isMove) {
				break;
			} else {
				ans++;
			}
		}

		System.out.println(ans);
	}

	// 0. 매번 모든 칸을 확인하기 위해 맵을 돌고
	// 방문배열을 통해 -> 1. 방문했던 구역 확인
	// 1. 인구차이가 L이상 R이하인 칸을 찾는다
	// 2. 찾은 칸의 평균을 구해 해당되는 칸에 갱신한다.
	// 3. 모든 칸이 조건을 만족하지 않으면 종료한다.
	static void bfs(int i, int j) {
		// que에 무엇을 담을 것인지? -> 인구이동이 발생할 구역
		que.add(new Point(i, j));
		list.add(new Point(i, j));
		visited[i][j] = true;

		while (!que.isEmpty()) {
			Point cur = que.poll();

			for (int k = 0; k < 4; k++) {
				int py = cur.y + my[k];
				int px = cur.x + mx[k];
				if (py >= 0 && py < N && px >= 0 && px < N) {
					if (!visited[py][px]) {
						if (Math.abs(map[py][px] - map[cur.y][cur.x]) >= L
								&& Math.abs(map[py][px] - map[cur.y][cur.x]) <= R) {
							isMove = true;
							visited[py][px] = true;
							que.add(new Point(py, px));
							list.add(new Point(py, px));
						}
					}
				}
			}
		}
		divide();
	}

	static void divide() {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			sum += map[p.y][p.x];
		}

		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			map[p.y][p.x] = sum / list.size();
		}

		list.removeAll(list);
	}
}

class Point {
	int y;
	int x;

	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}
