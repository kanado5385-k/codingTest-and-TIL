G = int(input()) # 18, 4
sum = list() #sum = []

for i in range(G):
    for k in range(G):
        if(5*i + 3*k == G):
            sum.append(i+k)

if not sum: #빈 리스트
    print(-1)
else:
    print(min(sum))