a = 5
b = 4
i = 0

while i < 10:
    i = i + 1
    print "i=", i

    if a > b:
        print a, " is greater than ", b

    else:
        print a, " is less or equal to ", b

    # if False:
    #     print "Never print"
    # else:
    #     print "Never print unless False"

# if True:
#     print "Always print"

if False:
    print "Never print"
else:
    print "Never print unless False"
