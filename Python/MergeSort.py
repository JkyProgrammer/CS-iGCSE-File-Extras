# Ascending Merge Sort
import random
from timeit import default_timer as timer

LENGTH = 50000
arr = []
for i in range (1, LENGTH):
    arr.append (random.randint(0, LENGTH*5))

def sortInner (array): # Should return two arrays
    if (len (array) > 1):
        # Split
        numItems = len (array)
        middle = int (numItems/2)
        array1 = array[0:middle]
        array2 = array[middle:numItems]
        array1 = sortInner (array1)
        array2 = sortInner (array2)
    else:
        return array

    # Merge
    i1 = 0
    i2 = 0
    output = []
    while (i1 < len(array1) and i2 < len(array2)):
        if (array1[i1] < array2[i2]):
            output.append (array1[i1])
            i1 += 1
        else:
            output.append (array2[i2])
            i2 += 1

    while (len(output) != len(array1)+len(array2)):
        if i2 < len (array2):
            output.append (array2[i2])
            i2 += 1
        elif i1 < len (array1):
            output.append (array1[i1])
            i1 += 1
    return output

start = timer()
sortedArr = sortInner (arr)
end = timer()

print ("Length:", LENGTH)
print ("Time taken:", end-start)

