a = 3
b = 4

def func(c):
    d = a + b
    c = c + d
    return c

c = 2
c = func(c)

print "c=", c
