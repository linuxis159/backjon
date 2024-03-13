T = int(input());
for i in range(0, T):
    N = int(input())
    arr = [[0 for col in range(2)] for row in range(N+1)]
    if N == 0:
        print("1 0")
        continue
    elif N == 1:
        print("0 1")
        continue
    arr[0][0] = 1
    arr[0][1] = 0

    arr[1][0] = 0
    arr[1][1] = 1
    for j in range(2,N+1):
        arr[j][0] = arr[j-1][0] + arr[j-2][0]
        arr[j][1] = arr[j-1][1] + arr[j-2][1]

    print("%s %s" % (arr[N][0],arr[N][1]))



