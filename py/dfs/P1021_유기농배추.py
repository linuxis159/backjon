import sys
sys.setrecursionlimit(10**7)
def dfs(y, x, arr):
    try:
        if arr[y][x] == 0:
            return
        elif y == -1:
            return
        elif x == -1:
            return
    except:
        return
    arr[y][x] = 0
    dfs(y-1,x, arr)
    dfs(y+1,x, arr)
    dfs(y,x+1, arr)
    dfs(y,x-1, arr)



T = int(input())
for i in range(0, T):
    list = input().split()
    rowCnt = int(list[0])
    columnCnt = int(list[1])
    k = int(list[2])
    arr = [[0 for row in range(rowCnt)] for col in range(columnCnt)]
    result = 0
    for j in range(0, k):
        position = input().split()
        arr[int(position[1])][int(position[0])] = 1
    for j in range(0, columnCnt):
        for k in range(0, rowCnt):
            if arr[j][k] == 1:
                dfs(j, k, arr)
                result += 1
    print(result)
