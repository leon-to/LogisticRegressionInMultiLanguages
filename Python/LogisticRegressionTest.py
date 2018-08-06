# Python source code is copied from the link below for learning purposes only
# https://medium.com/@martinpella/logistic-regression-from-scratch-in-python-124c5636b8ac

from sklearn import datasets
import unittest
from LogisticRegression import LogisticRegression

class LogisticRegressionTest(unittest.TestCase):
    def setUp (self):
        iris = datasets.load_iris()
        self.X = iris.data[:, :2]
        self.y = (iris.target != 0) * 1
        self.model = LogisticRegression(lr=0.01, num_iter=300000, verbose=True)
        self.lossArray = self.model.fit(self.X, self.y)

    def test_lossImprovement(self):
        prevLoss = currLoss = self.lossArray[0]
        
        for loss in self.lossArray[1:]:
            prevLoss = currLoss
            currLoss = loss
            self.assertTrue (currLoss<prevLoss)
            
    def test_accuracy (self):
        preds = self.model.predict(self.X)
        accuracy = (preds == self.y).mean()
        self.assertTrue (accuracy>0.9)

suite = unittest.TestLoader().loadTestsFromTestCase(LogisticRegressionTest)
unittest.TextTestRunner(verbosity=2).run(suite)