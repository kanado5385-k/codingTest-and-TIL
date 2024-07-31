N = int(input())
arr = []

arr.extend(map(int, input().split()))

max_value = max(arr)
arr.remove(max_value)
resolv = 0
for i in range(len(arr)):
    sum = max_value + arr[i]
    resolv += sum

print(resolv)    

# array안에 여러 요소 한번에 map으로 받을 때, 입력값이 map객체이기때문에 리스트에 추가하기 위해 extend를 사용해야함
# 시간복잡도 = O(len(arr)) = O(N)