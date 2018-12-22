a = 3
b = 4

def func(c):
    d = a + b
    print "in function: d=", d
    c = c + d
    print "in function: c=", c
    
    return c

c = 2
c = func(c)

print "c=", c
