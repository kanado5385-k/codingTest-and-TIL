import heapq

# 입력 받기
inp = list(map(int, input().split()))

# 입력 값의 길이 = n
n = len(inp)

# m 리스트 초기화
m = [0] * n

# 최소 힙 초기화
min_heap = []

# m[i] 배열 정의 
for i in range(n):
    r1 = i // 3 + 1
    heapq.heappush(min_heap, inp[i])

    # r1번째로 작은 값을 찾기
    if len(min_heap) >= r1:
        # 미리 힙에서 r1번째 값까지 pop해서 바로 저장
        temp_heap = []
        for _ in range(r1):
            smallest = heapq.heappop(min_heap)
            temp_heap.append(smallest)
        m[i] = smallest

        # 꺼낸 값을 힙에 다시 넣기
        for val in temp_heap:
            heapq.heappush(min_heap, val)
    else:
        m[i] = 0

# 결과 합산
s = sum(m)

# 결과 출력
print(s)