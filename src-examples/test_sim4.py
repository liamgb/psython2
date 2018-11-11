a = 1
b = 2

def factorial(c):
    result = 0
    if c <= 1:
        result = 1
    else:
        pre_tar = c - 1
        pre_result = factorial(pre_tar)
        result = pre_result * c
    return result

def func():
    print "this is a useless functon"
    return 0

tar = 10
fac = factorial(tar)

print "fac of ", tar, " = ", fac
