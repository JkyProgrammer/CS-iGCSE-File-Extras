mapObj = {"User1": "Password", "User2": "Secret"}   # Dictionary object containing user auth details
while (True):                                       # Keep trying until the user authenticates correctly
    username = input ("Type username:")             # Receive username and password from user
    password = input ("Type password:")
    
    if (username in mapObj):                        # Check if the user exists in the dictionary
        if (mapObj[username] == password):          # Break out if the password matches the username
            break

    print ("Incorrect username/password combination")

print ("User authenticated")
