import unittest,json
from DataLib import QueryData,Graph
from ParseData import Parser

__author__ = 'ztx'


json_data = open('/Users/ztx/PycharmProjects/Assignment2.0/src/Test/dataTest.json').read()
data = json.loads(json_data)

graph = Graph.Graph(Parser.parse_city(data),Parser.parse_route(data))

class ParserTest(unittest.TestCase):


    def testHK(self):
        """test Dictionary of City"""
        key = graph.getvetex().has_key("Hong Kong")
        self.assertEqual(key,True)

        """test List of Route"""
        for item in graph.getedge():
            if item.departure == 'TPE' and item.destination == 'HKG':
                key = item.distance
        self.assertEqual(key,807)

        """test Country"""
        value = graph.getvetex().get("Hong Kong")
        self.assertEqual(value.country,'CH')

        """test Coordinates"""
        self.assertEqual(value.coordinates.get('N'),22)