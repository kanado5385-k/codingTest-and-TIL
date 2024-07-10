import math
A, B, V = map(int, input().split())

result = math.ceil((V - B) / (A - B)) #주어진 수를 올림하여 가장 가까운 정수를 반환(소수점을 올림 처리)

print(result)

