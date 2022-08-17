package Baekjoon_11주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2580 {
	static int[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		// 각 빈칸은 1-9까지의 수를 넣어볼 수 있음
		// 방문하지 않은 수 한번씩 대입
		// 1. 가로/세로 줄에 중복 숫자가 없다. ->
		// 2. 3x3 행렬 내에 중복 숫자가 없다. -> 0의 위치정보가 필요
		// 3. 0이 채워진 숫자에 값을 추론한다. -> 0일 때만 확인하면 된다.
		backtraking(0, 0);
	}

	static public void backtraking(int row, int col) {
		// 열 끝까지 채워지면 다음 행 호출
		if (col == 9) {
			backtraking(row + 1, 0);
			return;
		}

		// 모든 행과 열 끝까지 채워지면 스도쿠 출력
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(String.valueOf(map[i][j])).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);

			System.exit(0);
		}

		if (map[row][col] == 0) {
			// 1-9까지 가능한 수를 넣어보고 가능하면 재귀호출
			for (int i = 1; i <= 9; i++) {
				if (isOk(row, col, i)) {
					map[row][col] = i;
					backtraking(row, col + 1);
				}
			}
			// 1-9까지 가능한 수가 없으므로 현재 위치 0으로 돌려놓고 종료
			map[row][col] = 0;
			return;
		}
		backtraking(row, col + 1);
	}

	static public boolean isOk(int row, int col, int value) {
		// 가로
		for (int i = 0; i < 9; i++) {
			if (map[row][i] == value)
				return false;
		}
		// 세로
		for (int i = 0; i < 9; i++) {
			if (map[i][col] == value)
				return false;
		}
		// 3x3 시작 행 열
		int matRow = (row / 3) * 3; // 0,3,6
		int matCol = (col / 3) * 3; // 0,3,6
		for (int i = matRow; i < matRow + 3; i++) {
			for (int j = matCol; j < matCol + 3; j++) {
				if (map[i][j] == value) {
					return false;
				}
			}
		}

		return true;
	}
}
