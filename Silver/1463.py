N = int(input())
array = []

now = 0
result = 0

for i in range(N):
    a, b = map(int, input().split())
    array.append([a, b])

# 끝나는 시간으로 먼저 정렬하고, 끝나는 시간이 같을 경우 시작 시간으로 정렬
array.sort(key=lambda x: (x[1], x[0]))

for s_time, e_time in array:
    if s_time >= now:
        result += 1
        now = e_time

print(result)  

# 그리디 문제이기때문에 단순하게 끝나는 시간으로 정렬후 하나 하나씩 검사한다
# 시간복잡도 = O(NlogN)
