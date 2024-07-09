subject = int(input())
score = list(map(int, input().split()))

Max = max(score)

for i in range(subject):
    score[i] = score[i]/Max*100

print(sum(score)/subject)