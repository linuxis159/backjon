def getFactorial(N):
    if N <= 1:
        return 1
    return N * getFactorial(N-1)

T = int(input())
for i in range(0,T):
    list = input().split()
    left = int(list[0])
    right = int(list[1])
    leftF = getFactorial(left)
    anotherF = getFactorial(right-left)
    rightF = getFactorial(right)
    print(int(rightF / (leftF * anotherF)))





