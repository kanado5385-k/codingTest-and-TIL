N, K = map(int, input().split())
count = 0
coin_array=[]
for _ in range(N):
    coin_array.append(int(input()))

coin_array.sort(reverse=True) #O(NlogN)

for coin in coin_array: # O(N)
    count += K // coin
    K = K % coin


print(count)

# 시간 복잡도 = O(N)


