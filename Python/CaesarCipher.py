alphabet = "abcdefghijklmnopqrstuvwxyz"

def find (char, string):
    i = 0
    for charac in string:
        if charac == char:
            return i
        i = i + 1
    return -1

def caeser (key, text):
    out = ""
    for charac in text:
        if (charac != ' '):
            ind = find (charac.lower(), alphabet)
            ind = ind + key
            ind = ind % 26
            out = out + alphabet[ind]
        else:
            out = out + ' '
    return out

while True:
    text = input ("Text: ")
    #key = int (input ("Key: ")
    for key in range (1, 26):
        print (caeser (key, text))

    
    
