def check_chessboard(board, start_row, start_col):
    color_options = ['B', 'W']
    min_changes = float('inf')
    for first_color in color_options:
        second_color = 'W' if first_color == 'B' else 'B'
        changes = 0
        for i in range(8):
            for j in range(8):
                expected_color = first_color if (i + j) % 2 == 0 else second_color
                if board[start_row + i][start_col + j] != expected_color:
                    changes += 1
        min_changes = min(min_changes, changes)
    return min_changes

M, N = map(int, input().split())
board = [input().strip() for _ in range(M)]

result = []
for i in range(M - 7):
    for j in range(N - 7):
        result.append(check_chessboard(board, i, j))

print(min(result))