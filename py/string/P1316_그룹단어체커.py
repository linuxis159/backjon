from typing import Dict, List
N = int(input())
cnt = 0
for i in range(N):
    word = input()
    charSet = set()
    flag = False
    i = 0

    while i < len(word):
        if word[i] in charSet:
            flag = True
            break
        else:
            charSet.add(word[i])

        # 현재 문자와 다음 문자가 같을 때, 같지 않을 때까지 인덱스를 증가
        while i + 1 < len(word) and word[i] == word[i+1]:
            i += 1

        i += 1

    if not flag:
        cnt += 1
print(cnt)

