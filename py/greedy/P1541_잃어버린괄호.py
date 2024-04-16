string = input()

i = 0
minusValue = 0
plusValue = 0
plusString = ""
while i <= len(string):
    if i == len(string):
        plusValue = plusValue + int(plusString)
        break
    if string[i] == '-':
        if plusString != "":
            plusValue = plusValue + int(plusString)
        plusString = ""
        i = i + 1
        sum = 0
        stringNumber = ""
        while i <= len(string):
            if i == len(string):
                minusValue = minusValue + int(stringNumber)
                break
            if string[i] == '-':
                minusValue = minusValue + int(stringNumber)
                i = i-1
                break
            elif string[i] == '+':
                minusValue = minusValue + int(stringNumber)
                stringNumber = ""
            else:
                if stringNumber == "" and string[i] == "0":
                    i = i+1
                    continue
                else:
                    stringNumber = stringNumber + string[i]
            i = i+1

    elif string[i] == '+':
        plusValue = plusValue + int(plusString)
        plusString = ""
    else:
        if plusString == "" and string[i] == "0":
            i = i+1
            continue
        else:
            plusString = plusString + string[i]
    i = i+1


print(plusValue - minusValue)