a = 1
b = 2
c = True
d = 'd'
f = "cool"
# e = func1(a, b)

def func1(a, b):
    c = a
    d = c
    if a < b:
        e = d
        f = e
        g = e + a
    return g

e = func1(a, b)
print f
