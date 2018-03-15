import numpy as np
import sys

m, n = map(int, sys.argv[1:])

inp = np.array([[i] * n for i in range(m)])

for _ in range(n * m):
  from random import randint
  i1, j1 = randint(0, m - 1), randint(0, n - 1)
  i2, j2 = randint(0, m - 1), randint(0, n - 1)
  inp[i1, j1], inp[i2, j2] = inp[i2, j2], inp[i1, j1]

print('%d %d' % (m, n))

for row in inp:
  print(' '.join(str(x + 1) for x in row))
