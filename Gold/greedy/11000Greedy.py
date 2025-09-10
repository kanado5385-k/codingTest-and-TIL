import sys
import heapq

input = sys.stdin.readline #input()을 여러 번 사용하는 경우, 특히 입력 데이터가 매우 큰 경우 sys.stdin.read를 사용

N = int(input())

arr = []
# 우선순위 큐 생성
priority_queue = []

for i in range(0,N):
    a, b = map(int, input().split())
    arr.append([a,b])

arr.sort(key=lambda x: (x[0], x[1]))

heapq.heappush(priority_queue, arr[0][1]) #O(logN)

for i in range (1, N):
    if priority_queue[0] <= arr[i][0]:
        heapq.heappop(priority_queue) # 요소 제거 및 반환 (우선순위가 가장 높은 요소(가장 작은 수)를 반환), O(logN)
    heapq.heappush(priority_queue, arr[i][1])    


print(len(priority_queue))           

# heapq = 우선순위큐에서는 요소를 반환할때 가장 우선순위가 높은 요소부터 꺼내는게 특징
# 시간복잡도 = O(NlogN)
    


