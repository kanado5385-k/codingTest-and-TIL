N, M, K = map(int, input().split())

result = 0

while(True):
    N -= 2
    M -= 1
    if(N<0 or M<0 or (M+N)<K):
        break
    result+=1

print(result)

#그리디 문제에서는 일단 팀을 꾸리고 본다
# 시간복잡도 O(N)