package Baekjoon_10주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15649 {
	static int N, M; // N은 수열범위 M은 길이
	static StringBuilder sb;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N]; // 수들의 중복을 방지하기 위한 방문배열 
		arr = new int[M]; // 수열에 들어갈 수를 나열
		
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
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				backtraking(depth + 1);
				visited[i] = false; 
			}
		}
	}
}
