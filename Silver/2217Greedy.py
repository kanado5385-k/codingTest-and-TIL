N = int(input())
arr = []
for _ in range (0,N):
    arr.append(int(input()))

arr.sort(reverse=True)
result = 0

for i in range(N):
    weight = arr[i] * (i + 1)
    if weight > result:
        result = weight

print(result)

# 그리디 문제는 항상 sort를 적용하네?
# 시간복잡도 = O(NlogN)