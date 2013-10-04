__author__ = 'ztx'
import unittest,json,urllib2
from DataLib import QueryData,Graph,City,Route
from ParseData import Parser,QueryMethod,Dijkstra,Extendjson

json_data = open('/Users/ztx/PycharmProjects/Assignment2.0/src/Test/dataTest.json').read()
data = json.loads(json_data)

graph = Graph.Graph(Parser.parse_city(data),Parser.parse_route(data))

class ExtendGraphTest(unittest.TestCase):
    """test for extend graph"""
    def testextend(self):
        json_data = urllib2.urlopen("https://wiki.engr.illinois.edu/download/attachments/227740360/cmi_hub.json?version=1&modificationDate=1377303775000")
        data = json.load(json_data)
        Extendjson.extendjson(graph,data)
        key =QueryMethod.getQueryCity("Champaign",graph)
        self.assertEqual(key,True)