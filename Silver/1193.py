# 시간 초과 이러난 풀이(억울함)
"""
num = int(input())
count = 0

i = 0
found = False  # 결과를 찾았는지 표시하는 플래그
while not found:
    for k in range(i + 1):
        num_1 = k + 1
        num_2 = i - k + 1
        count += 1
        if count == num:
            print(f"{num_1}/{num_2}")
            found = True  # 결과를 찾았으므로 루프 탈출
            break
    i += 1
"""

num = int(input())
line = 1
while (num > line):
    num -= line
    line += 1

if line%2 == 0:
    print(f"{num}/{line-num+1}")

else:
    print(f"{line-num+1}/{num}")  