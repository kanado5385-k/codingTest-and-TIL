string = input()

noMsrt = string.split("-")

arr = []

for i in noMsrt:
    noPstr = i.split("+")
    sum = 0
    for k in noPstr:
        sum += int(k)
    arr.append(sum)    

j = arr[0]
for i in range (1,len(arr)):
    j = j - arr[i]

print(j)    

#시간복잡도 = O(N)