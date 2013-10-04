from ParseData import QueryMethod
from ParseData.QueryMethod import cityToContient

import json
from DataLib import City, QueryData,Graph
import urllib2
from DataLib.Route import Route


__author__ = 'ztx'

"""class to parse the data into relative structure and calculate some statistical info as well"""


def parse_city(data):
    D_city = {}
    maxx = 0
    minn = 0
    summ = 0
    numm = 0

    for city in data["metros"]:
        city_node = City.City(city["code"], city["name"], city["country"],
                                    city["continent"], city["timezone"], city["coordinates"],
                                    city["population"], city["region"])

        summ += city_node.population
        numm += 1
        if city_node.population > maxx:
            maxx = city_node.population
            QueryData.biggestCity = city_node

        if city_node.population < minn or minn == 0:
            minn = city_node.population
            QueryData.smallestCity = city_node

        cityToContient(city_node.name,city_node.continent)

        D_city[city["name"]] = city_node

    QueryData.averageCitySize = summ/numm
    return D_city

def parse_route(data):
    L_route = []
    maxx = 0
    minn = 0
    summ = 0
    numm = 0
    for route in data["routes"]:
        route_node = Route(route["ports"][0],route["ports"][1],route["distance"])

        summ = summ + route_node.distance
        numm += 1
        if route_node.distance > maxx:
            QueryData.longest = route_node
            maxx = route_node.distance



        if route_node.distance < minn or minn == 0:
            QueryData.shortest = route_node
            minn = route_node.distance

        QueryMethod.addHub(route["ports"][0])
        QueryMethod.addHub(route["ports"][1])
        L_route.append(route_node)
        L_route.append(Route(route["ports"][1],route["ports"][0],route["distance"]))

    QueryData.averageDistance = summ/numm
    return L_route


class Parser:
    """json_data = open("dataTest.json")
       make sure you connect to the Internet first!
     """
    def parse(self):

        url = "https://wiki.engr.illinois.edu/download/attachments/227740359/map_data.json?version=1&modificationDate=1377303775000"

        json_data = urllib2.urlopen(url)
        data = json.load(json_data)
        json_data.close()
        return Graph.Graph(parse_city(data),parse_route(data))

