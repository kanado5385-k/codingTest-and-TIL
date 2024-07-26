import sys

input = sys.stdin.readline
N = int(input())
for _ in range(N):
    K = int(input())
    arr = []
    for _ in range(K):
        a, b = map(int, input().split())
        arr.append([a, b])
    
    arr.sort(key=lambda x: x[0])
    
    result = 1
    min_interview_rank = arr[0][1]
    
    for k in range(1, K):
        if arr[k][1] < min_interview_rank:
            result += 1
            min_interview_rank = arr[k][1]
    
    print(result)    


# 시간 복잡도 = O(KlogK)
# 배열 K 가 있을 때, min(k)의 시간복잡도가 O(K)이다. 이는 O(KlogK)보다 작지만 for문에 들어가게 되면 O(K의제곱)되어 O(KlogK)보다 커지게 된다
# -> for문안에 min(), max()를 사용하지 않는것이 좋다




