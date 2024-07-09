num1 = int(input())
score1 = 0

def function(num):
    global score1 #글로벌 변수의 값을 수정하기의해서 함수 안에 global로 선언, 참조만하는 num1은 할필요 없다
    if num < 10:
        num = int("0" + str(num))
        
    num_left = num // 10
    num_right = num % 10

    sum_digits = num_left + num_right
    new_num_srt = str(num_right) + str(sum_digits)[-1]
    new_num = int(new_num_srt)
    
    score1 += 1
    
    if new_num != num1:
        function(new_num)

function(num1)
print(score1)


