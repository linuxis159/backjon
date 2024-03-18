def dfs(depth, max, result, start):
    global cnt
    global input2
    global visit
    if depth == max:
        if result == S:
            cnt+=1
    for i in range(start, len(input2)):
        if visit[i] == True:
            continue
        visit[i] = True
        dfs(depth+1, max, result+input2[i], i+1)
        visit[i] = False



input1 = input().split()
N = int(input1[0])
S = int(input1[1])
input2 = input().split()
input2 = list(map(int, input2))
cnt = 0
for i in range(0, N):
    visit = [False for j in range(0,N)]
    dfs(0, i+1, 0, 0)



print(cnt)




