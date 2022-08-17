package Baekjoon_11주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_16918 {
	static int R, C, N;
	static char[][] map;
	static int[][] boomCount;
	static int[] mx = { -1, 1, 0, 0 };
	static int[] my = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		boomCount = new int[R][C];
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == 'O') {
					map[i][j] = str.charAt(j);
					boomCount[i][j] = 3;
				} else {
					map[i][j] = str.charAt(j);
				}

			}
		}

		bfs(1);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	static void bfs(int count) {

		while (count <= N) {
			// 짝수인 경우 - > build
			if (count % 2 == 0) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == '.') {
							map[i][j] = 'O';
							boomCount[i][j] = count + 3;
						}
					}
				}
				count++;
			}
			// 홀수인 경우 -> boom
			else if (count % 2 == 1) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						// 3초가 지난 폭탄 boom
						if (boomCount[i][j] == count) {
							// 본인 boom
							map[i][j] = '.';
							// 본인 주변 boom
							// 빈칸인 경우 - 냅두고
							// 폭탄인데 설치시간이 같은 경우 - 냅두고
							// 폭탄인데 설치시간이 다른 경우 - 터진다.
							
							for (int h = 0; h < 4; h++) {
								int py = i + my[h];
								int px = j + mx[h];
								// 연쇄적으로 터져야 하므로 주변이 폭탄일 경우는 안바꿈

								if (py >= 0 && py < R && px >= 0 && px < C) {
									if (map[py][px] == 'O' && boomCount[py][px] != count) {
										map[py][px] = '.';
										boomCount[py][px] = 0;
									}
								}
							}
						}
					}
				}

				count++;
			}
		}

	}

	@SuppressWarnings("unused")
	private static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
