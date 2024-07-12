N = int(input())
count = 0 

num = 1000 - N

array = [500, 100, 50, 10, 5, 1]

for money in array:
    count += num // money
    num = num % money

print(count)

# 그리디문제는 현재 상황에서 지금 당장 좋은 것만 고르는 방법을 의미한다
# 탐욕법으로 얻은 해가 최적의 해가 되는 상황을 추론할 줄 알아야한다 
# 예를 들어, 이번 문제에서 줄 수 있는 거스름돈이 무한히있고, 
# 큰 단위가 항상 작은 단위의 배수이므로 작은 단위의 동전들을 종합해 다른 해가 나올 수 있다
# 시간 복잡도 = O(array.len) -> O(1)
