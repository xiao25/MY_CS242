__author__ = 'ztx'

import json

def encode(graph):
    """generate a new json file"""
    citylist = []
    routelist = []
    for key,city in graph.getvetex().items():
        citylist.append(city.__dict__)
        #citylist.append(json.dumps(city,default=lambda o: o.__dict__, sort_keys=True, indent=4))
    routedic = {}

    for route in graph.getedge():
        templist = []
        templist.append(route.departure)
        templist.append(route.destination)
        routedic["ports"] =  templist
        routedic["distance"] = route.distance
        routelist.append(routedic)



    jsondata = {}
    sourcelist = []
    sourcelist.append("http://www.gcmap.com/")
    sourcelist.append("http://www.theodora.com/country_digraphs.html")
    sourcelist.append("http://www.citypopulation.de/world/Agglomerations.html")
    sourcelist.append("http://www.mongabay.com/cities_urban_01.htm")
    sourcelist.append("http://en.wikipedia.org/wiki/Urban_agglomeration")
    sourcelist.append("http://www.worldtimezone.com/standard.html")
    jsondata["metors"] = citylist
    jsondata["routes"] = routelist
    jsondata["data sources"] = sourcelist
    NewJson = open("NewJson.txt", "w")
    NewJson.write(json.dumps(jsondata))






