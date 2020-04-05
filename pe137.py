
# https://math.stackexchange.com/questions/2307710/solving-pells-equation-x2-5y2-pm4-using-elementary-methods

n = 0  # number of solutions counter
(u, v) = (1, 1)  # (u,v) = (1,1) is the first solution for -4
U = 0  # temporary variable to hold u

while (n < 15):
  U = u
  u = (u + 5 * v) / 2
  v = (U + v) / 2

  U = u
  u = (u + 5 * v) / 2
  v = (U + v) / 2

  if u % 5 == 1:
    n += 1
    print(n)
    print("Solution found")
    print((u - 1) / 5)
    print()
   





