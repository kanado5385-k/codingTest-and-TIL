N = int(input())
x_to_y = {}  # x 값에 대응하는 y 값을 저장하기 위한 딕셔너리
result = 0

for _ in range(N):
    x, y = map(int, input().split())
    if x in x_to_y:
        if x_to_y[x] != y:  # 같은 x에 다른 y 값이 할당되었을 경우
            result += 1
            x_to_y[x] = y  # x의 y 값을 새로운 y로 갱신
    else:
        x_to_y[x] = y  # 새로운 x 값을 딕셔너리에 추가

print(result)