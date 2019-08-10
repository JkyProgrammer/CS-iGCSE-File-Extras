import random

FOXREPRODUCTION = 2 # Number of foxes produced per pair of existing ones
RABBITREPRODUCTION = 3 # Number of rabbits produced per pair of existing ones

RANDOMDEATHCHANCE = 10 # 1-in-x chance of death by other causes

RABBITSEATENPERFOX = 10 # The number of rabbits a fox must eat to survive

foxes = 3
rabbits = 50

while True:
    # Reproduction
    rabbits = rabbits + (int (rabbits/2) * RABBITREPRODUCTION)
    foxes = foxes + (int (foxes/2) * FOXREPRODUCTION)

    # Death by other causes
    if random.randint (1, RANDOMDEATHCHANCE) == 1:
        rabbits = rabbits - 1

    if random.randint (1, RANDOMDEATHCHANCE) == 1:
        foxes = foxes - 1

    # Hunting
    numrequiredrabbits = foxes * RABBITSEATENPERFOX
    while numrequiredrabbits > rabbits:
        foxes = foxes - 1
        numrequiredrabbits = numrequiredrabbits - RABBITSEATENPERFOX

    rabbits = rabbits - numrequiredrabbits

    print ("Foxes: ", foxes, ", rabbits: ", rabbits)

    if rabbits < 1 or foxes < 1:
        break
