import unittest,json
from DataLib import Graph
from ParseData import Parser, QueryMethod

__author__ = 'ztx'

json_data = open('/Users/ztx/PycharmProjects/Assignment2.0/src/Test/dataTest.json').read()
data = json.loads(json_data)

graph = Graph.Graph(Parser.parse_city(data),Parser.parse_route(data))

class ContinentTest(unittest.TestCase):
    """create a new short json file + doc string + get all cities map"""
    Parser.Parser()

    def testHKG(self):
        value = QueryMethod.mapCity('HKG',graph)
        self.assertEqual(value,True)

    def testinvalidcity(self):
        value = QueryMethod.mapCity("adfaf",graph)
        self.assertEqual(value,False)