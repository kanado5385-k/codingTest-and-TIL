N = input()

arr = [int(digit) for digit in str(N)]
arr.sort(reverse=True)

num = int(''.join(map(str, arr)))
result = 0
if(num%30==0):
    result = num
else:
    result = -1

print(result)

# map 함수 -> 리스트의 각 요소에 대해 str 함수를 적용 (리스트가 [2, 3, 4]라면, map(str, digits)는 각 숫자를 문자열로 변환하여 ['2', '3', '4']라는 새로운 리스트를 만듦)
# join 메서드 -> 리스트의 모든 문자열을 하나의 문자열로 합칩
# ''는 빈 문자열을 의미하며, 이는 각 문자열 사이에 아무것도 넣지 않고 단순히 연결하겠다는 의미
# 시간복잡도 = O(len(N)loglen(N))