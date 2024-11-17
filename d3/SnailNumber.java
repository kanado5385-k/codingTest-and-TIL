package d3;

public class SnailNumber {
    public static void main(String[] args) {
        int N = 5; // N값을 원하는 크기로 설정
        int[][] snail = new int[N][N];

        int num = 1; // 배열에 채워질 숫자
        int x = 0, y = 0; // 현재 위치
        int direction = 0; // 방향: 0(우), 1(하), 2(좌), 3(상)
        int[] dx = {0, 1, 0, -1}; // 방향에 따른 x 이동값
        int[] dy = {1, 0, -1, 0}; // 방향에 따른 y 이동값

        while (num <= N * N) {
            snail[x][y] = num++; // 현재 위치에 숫자 채움
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 다음 위치가 범위를 벗어나거나 이미 숫자가 채워져 있으면 방향 전환
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || snail[nx][ny] != 0) {
                direction = (direction + 1) % 4; // 방향 전환
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%3d", snail[i][j]);
            }
            System.out.println();
        }
    }
}