import unittest,json
from DataLib import Graph,QueryData
from ParseData import  Parser,QueryMethod
__author__ = 'ztx'

json_data = open('/Users/ztx/PycharmProjects/Assignment2.0/src/Test/dataTest.json').read()
data = json.loads(json_data)

graph = Graph.Graph(Parser.parse_city(data),Parser.parse_route(data))

class QueryTest(unittest.TestCase):




    def testCituQury(self):
        """test city info"""
        key =QueryMethod.getCity(graph)
        value = False
        if key is None:
            value = True
        self.assertEqual(value, False)



    def testspecificalinfo(self):
        """test info of specific city"""
        key = QueryMethod.getQueryCity('Tokyo',graph)
        self.assertEqual(key, True)
        key = QueryMethod.getQueryCity('asdf',graph)
        self.assertEqual(key, False)


    def testshortestflight(self):
        """ test statistical data"""
        key = QueryData.longest
        self.assertEqual(key.distance, 3158)
        self.assertEqual(key.departure, 'MEX')

    def testbiggestcity(self):
        """test biggest city"""
        key = QueryData.biggestCity
        self.assertEqual(key.name, 'Tokyo')

    def testavaragepopulation(self):
        """test average population"""
        key = QueryData.averageCitySize
        self.assertEqual(key,13904987)