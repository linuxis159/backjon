N = int(input())
listA = input().split()
listA = list(map(int, listA))
listB = input().split()
listB = list(map(int, listB))
listA.sort()
listB.sort()
listB.reverse()
result = 0
for i in range(0, len(listA)):
    result += listA[i] * listB[i]
print(result)

