N = int(input())
arr = list(map(int, input().split())) #리스트의 원소들을 한줄로 입력 받기
result = 0

arr.sort() 

for i in range(0,N):
    sum = 0
    for k in range (0,i+1):
        sum += arr[k]
    result += sum    

print(result)





