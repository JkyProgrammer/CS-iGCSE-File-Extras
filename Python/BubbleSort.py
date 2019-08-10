#Ascending Bubble Sort
import random
from timeit import default_timer as timer

LENGTH = 50000
arr = []
for i in range (1, LENGTH):
    arr.append (random.randint(0, LENGTH*5))

start = timer()
swapped = True
numItems = len(arr)

while swapped:
    swapped = False
    for i in range (0, numItems-1):
        if arr[i] > arr[i+1]:
            t = arr[i]
            arr[i] = arr[i+1]
            arr[i+1] = t
            swapped = True

end = timer()

print ("Length:", LENGTH)
print ("Time taken:", end-start)

