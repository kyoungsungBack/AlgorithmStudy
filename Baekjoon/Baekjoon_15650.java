package Baekjoon_10주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15650 {
	static int N, M;
	static StringBuilder sb;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		arr = new int[M];

		backtraking(0);
		System.out.println(sb.toString());
	}

	static public void backtraking(int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && isOk(depth, i + 1)) {
				visited[i] = true;
				arr[depth] = i + 1;
				backtraking(depth + 1);
				visited[i] = false;
			}
		}
		/*
		 * 다른방법
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				backtraking(i + 1, depth + 1);
				visited[i] = false;
			}
		}
		*/
	}

	static public boolean isOk(int depth, int k) {
		// 오름차순이 될 조건
		// 이전에 들어있던 수들 중 이번에 들어갈 값보다 큰게 있으면 false
		for (int i = 0; i < depth; i++) {
			if(arr[i] > k) {
				return false;
			}
		}
		return true;
	}
}
