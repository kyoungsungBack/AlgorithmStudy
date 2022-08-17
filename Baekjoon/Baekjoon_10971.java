package Baekjoon_10주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_10971 {
	static int[][] list;
	static int result = Integer.MAX_VALUE;
	static int N;
	static boolean[] visited;
	static PriorityQueue<Integer> pq;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		list = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int c = Integer.parseInt(st.nextToken());
				list[i][j] = c;
			}
		}
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			backtraking(i, i, 0, 0);
			visited[i] = false;
		}

		System.out.println(result);
	}

	static public void backtraking(int start, int now, int cnt, int cost) {
		if (cnt == N - 1) {
			if (list[now][start] != 0) {
				cost += list[now][start];
				result = Math.min(cost, result);
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && list[now][i] != 0) {
				visited[i] = true;
				backtraking(start, i, cnt + 1, cost + list[now][i]);
				visited[i] = false;
			}

		}
	}

}
