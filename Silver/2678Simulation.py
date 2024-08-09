bingo = [list(map(int, input().split())) for _ in range(5)]
speak = []
for _ in range(5):
    speak += list(map(int, input().split()))

result = 0
game_over = False
   
def check(num):
    for i in range(5):
        sum = 0
        for j in range(5):
            if bingo[i][j] == 0:
                sum += 1
        if sum == 5:
            num+=1
    for j in range(5):
        sum = 0
        for i in range(5):
            if bingo[i][j] == 0:
                sum += 1
        if sum == 5:
            num+=1
    sum = 0           
    for i in range(5):
        if bingo[i][i] == 0:
            sum += 1
    if sum == 5:
        num+=1  

    sum = 0           
    for i in range(5):
        if bingo[i][4-i] == 0:
            sum += 1
    if sum == 5:
        num+=1 

    return(num)                  


for number in speak:
    if game_over:
        break
    for x in range(5):
        for y in range(5):
            if bingo[x][y] == number:
                bingo[x][y] = 0
                result += 1
                if result >= 12:
                    numOfBin = check(0)
                    if numOfBin >= 3:
                        print(result)
                        game_over = True
                        break
        if game_over:
            break


# 시간 복잡도 = O(N)        