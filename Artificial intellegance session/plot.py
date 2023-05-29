import pandas as pd
import numpy as np
import matplotlib.pylab as plt

titanic = pd.read_csv("numbers.csv") 

arr = np.sin(titanic)

arr2 = np.cos(titanic)



x = np.linspace(-1, 1, 100)

# x1 = np.linspace(-100, 100, 200)
# plt.plot(x, arr)
# plt.plot(x,arr2)
# plt.xlabel('Angle [rad]')
# plt.ylabel('sin(x)')
# plt.axis('tight')
# plt.show()



plt.subplot(121)
plt.plot(x, arr, "r")
plt.xlabel("Graph 1")
plt.ylabel('sin(x)')
 
plt.subplot(122)
plt.plot(x, arr2)
plt.xlabel("Graph 2")
plt.ylabel('cos(x)')
plt.axis('tight')

# plt.subplot(122)
# plt.plot(x, titanic)
# plt.xlabel("Graph 3")
# plt.ylabel('titanic')
# plt.axis('tight')
 
plt.suptitle("Plotting Multiple Graphs")
plt.show()

# print(titanic)
# print(arr)