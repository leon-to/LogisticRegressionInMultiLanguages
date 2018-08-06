from sklearn import datasets
import csv

iris = datasets.load_iris()
X = iris.data[:, :2]
y = (iris.target != 0) * 1

with open('data.csv', 'w', newline='') as csvfile:
    spamwriter = csv.writer(csvfile)
    spamwriter.writerow (['X[0]', 'X[1]', 'y'])
    for i in range(len(y)):
        spamwriter.writerow([X[i][0], X[i][1], y[i]])
