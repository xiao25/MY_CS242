__author__ = 'ztx'
import unittest,json
from DataLib import QueryData,Graph,City,Route
from ParseData import Parser,QueryMethod,Dijkstra

json_data = open('/Users/ztx/PycharmProjects/Assignment2.0/src/Test/dataTest.json').read()
data = json.loads(json_data)

graph = Graph.Graph(Parser.parse_city(data),Parser.parse_route(data))

class EdgraphTest(unittest.TestCase):
    """test for commands for editing graph"""
    def testaddvetex(self):
        cooriderates = {}
        cooriderates["N"] = 40
        cooriderates["W"] = 88
        city = City.City("CMI","Champaign","US","North America",-6,cooriderates,226000,1)
        graph.addvetex(city)
        key = QueryMethod.getQueryCity('Tokyo',graph)
        self.assertEqual(key, True)

    def testrmvetex(self):
        graph.rmvetex("Champaign")
        key = QueryMethod.getQueryCity('Champaign',graph)
        self.assertEqual(key,False)

    def testrmroute(self):
        route = Route.Route("HKG","TPE",807)
        for route in graph.getedge():
            if route.departure == "HKG" and route.destination == "TPE":
                graph.rmedge(route)
        key = Dijkstra.getroutelist("HKG",graph.getedge())
        value = False
        if key.__len__() == 0:
            value = True
        self.assertEqual(value,True)

    def testeditcity(self):
        graph.edcity("Hong Kong","Hwx",0)
        for key,city in graph.getvetex().items():
            if key == "Hong Kong":
                value = city.code
        self.assertEqual(value,"Hwx")