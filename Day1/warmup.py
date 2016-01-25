import math
def sum(a, b, c):
    result = a + b + c
    print("The sum of the three numbers is %d" % result)

def cube(x):
    if x > 0:
        cube = math.pow(x,3)
        print("The cube of %d is %d" % (x, cube))
    else:
        square = math.pow(x,2)
        print("The square of %d is %d" % (x, square))

def spam():
    for i in range (0,100):
        print("Hello world %d" % i)

def nfactorial(n):
    return(math.factorial(n))

sum(10,20,30)
cube(10)
cube(-20)
nfactorial(2)
