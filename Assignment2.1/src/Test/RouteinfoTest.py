__author__ = 'ztx'


import unittest,json
from DataLib import QueryData,Graph,City,Route
from ParseData import Parser,QueryMethod,Dijkstra,RouteInfo

json_data = open('/Users/ztx/PycharmProjects/Assignment2.0/src/Test/dataTest.json').read()
data = json.loads(json_data)

graph = Graph.Graph(Parser.parse_city(data),Parser.parse_route(data))

class RouteinfoTest(unittest.TestCase):
    """test for commands for route info"""
    def testrouteinfo(self):
        citys = []
        citys.append("HKG")
        citys.append("TPE")
        total = RouteInfo.routeinfo(citys,graph)
        self.assertEqual(total,807)