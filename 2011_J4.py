import sys
input = sys.stdin.readline

def rowToY(r):
    return -r-1

def colToX(c):
    return c-201

def yToRow(y):
    return -y-1

def xToCol(x):
    return x+201

a = [[False for i in range(401)] for j in range(200)]

def addPoint(x, y):
    global a
    a[yToRow(y)][xToCol(x)] = True

for i in range(-3, 0):
    addPoint(0, i)
for i in range(4):
    addPoint(i, -3)
for i in range(-5, -2):
    addPoint(3, i)
for i in range(3, 6):
    addPoint(i, -5)
for i in range(-5, -2):
    addPoint(5, i)
for i in range(5, 8):
    addPoint(i, -3)
for i in range(-7, -2):
    addPoint(7, i)
for i in range(-1, 8):
    addPoint(i, -7)
for i in range(-7, -4):
    addPoint(-1, i)

# Initialize global variables
r = yToRow(-5)
c = xToCol(-1)
command = {
    'u':(-1, 0),
    'd':(1, 0),
    'l':(0, -1),
    'r':(0, 1)
}
line = input().split()

def main():
    global r, c, command, line
    while (line[0] != 'q'):
        danger = False
        for i in range(int(line[1])):
            r += command[line[0]][0]
            c += command[line[0]][1]
            if a[r][c]:
                danger = True
            a[r][c] = True
        
        print(str(colToX(c)) + " " + str(rowToY(r)), end=" ")
        if not danger:
            print("safe")
        else:
            print("DANGER")
            return

        line = input().split()

main()
