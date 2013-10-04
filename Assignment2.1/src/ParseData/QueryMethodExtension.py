__author__ = 'ztx'

from DataLib import QueryData
"""these two helper function to maintain the correctness of hub city when edit routes"""
def rmHubCity(city):
     if city.code in QueryData.hubCity:
         QueryData.hubCity[city.code] = 0

def minusHubCity(route):
    QueryData.hubCity[route.departure] -= 1
    QueryData.hubCity[route.destination] -= 1

def addHubCity(route):
    QueryData.hubCity[route.departure] += 1
    QueryData.hubCity[route.destination] += 1

def getkey(dic):
    list = []
    for key,value in dic.items():
        list.append(key)
    return list
