N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]
zero = 0
one = 0
minusOne = 0
def dfs(startY,endY, startX, endX):
    global zero
    global minusOne
    global one
    startValue = arr[startY][startX]
    for i in range(startY+1, endY+1):
        for j in range(startX+1, endX+1):
            if startValue != arr[i][j]:
                dfs(startY, int(endY/3), startX, int(endX/3))
                dfs(startY, int(endY/3), int(endX/3)+1, int(endX/3) * 2)
                dfs(startY, int(endY/3), int(endX/3) * 2 + 1, endX)
                dfs(int(endY/3) + 1, int(endY/3) * 2, startX, int(endX/3))
                dfs(int(endY/3) + 1, int(endY/3) * 2, int(endX/3)+1, int(endX/3) * 2)
                dfs(int(endY/3) + 1, int(endY/3) * 2, int(endX/3) * 2 + 1, endX)
                dfs(int(endY/3) * 2 + 1, endY, startX, int(endX/3))
                dfs(int(endY/3) * 2 + 1, endY, int(endX/3)+1, int(endX/3) * 2)
                dfs(int(endY/3) * 2 + 1, endY, int(endX/3) * 2 + 1, endX)
    if startValue == -1:
        minusOne = minusOne + 1
    elif startValue == 0:
        zero = zero + 1
    else:
        minusOne = minusOne + 1


dfs(0,N,0,N)

print(minusOne)
print(zero)
print(one)


