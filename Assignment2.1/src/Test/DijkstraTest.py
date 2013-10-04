__author__ = 'ztx'


import unittest,json
from DataLib import QueryData,Graph,City,Route
from ParseData import Parser,QueryMethod,Dijkstra

json_data = open('/Users/ztx/PycharmProjects/Assignment2.0/src/Test/dataTest.json').read()
data = json.loads(json_data)

graph = Graph.Graph(Parser.parse_city(data),Parser.parse_route(data))

class DijkstraTest(unittest.TestCase):
    """test for commands for shortest route in graph"""
    def testdijstar(self):
        path =Dijkstra.dijkstra(graph,"HKG","SHA")
        rightpath = []
        rightpath.append("HKG")
        rightpath.append("TPE")
        rightpath.append("SHA")
        key = False
        if path == rightpath:
            key = True
        self.assertEqual(key,True)
