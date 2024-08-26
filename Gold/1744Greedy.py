N = int(input())
arr = []
for i in range(N):
    arr.append(int(input()))

real_result = 0
arr_pos = []
arr_neg = []
arr_zero = []

for k in arr:
    if k < 0:
        arr_neg.append(k)
    elif k == 0:
        arr_zero.append(k)
    else:
        arr_pos.append(k)

arr_pos.sort(reverse=True)
arr_neg.sort()

# 양수 처리
for i in range(0, len(arr_pos), 2):
    if i + 1 < len(arr_pos):
        if arr_pos[i] == 1 or arr_pos[i+1] == 1:
            real_result += arr_pos[i] + arr_pos[i+1]
        else:
            real_result += arr_pos[i] * arr_pos[i+1]
    else:
        real_result += arr_pos[i]

# 음수 처리
i = 0
while i < len(arr_neg) - 1:
    real_result += arr_neg[i] * arr_neg[i+1]
    i += 2

# 남은 음수와 0의 처리
if i == len(arr_neg) - 1:  # 하나의 음수만 남았다면
    if not arr_zero:  # 0이 없다면 남은 음수를 결과에 더함
        real_result += arr_neg[i]

print(real_result)

# 시간복잡도 = O(NlogN)
# arr_neg.remove(arr_neg[i])와 같은 방식은 리스트에서 특정 요소를 제거할 때 O(N)의 시간 복잡도를 가지므로 비효율적일 뿐만 아니라, 인덱스 처리에서도 문제를 일으킬 수 있다
    