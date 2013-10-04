import unittest,json
from DataLib import QueryData,Graph
from ParseData import Parser

json_data = open('/Users/ztx/PycharmProjects/Assignment2.0/src/Test/dataTest.json').read()
data = json.loads(json_data)

graph = Graph.Graph(Parser.parse_city(data),Parser.parse_route(data))

__author__ = 'ztx'



class ContinentTest(unittest.TestCase):
    """test for continent list"""



    def testSHAAsia(self):
        key = False
        for city in QueryData.asia:
            if city == 'Shanghai':
                key = True
        self.assertEqual(key, True)

    def testBOGofSouthAmercia(self):
        key = False
        for city in QueryData.southAmerica:
            if city == 'Bogota':
                key = True
        self.assertEqual(key, True)



    def testLONofEurope(self):
        key = False
        for city in QueryData.europe:
            if city == 'London':
                key = True
        self.assertEqual(key, True)



