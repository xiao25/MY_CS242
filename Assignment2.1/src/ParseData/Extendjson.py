__author__ = 'ztx'

import  json
from ParseData import Parser
def extendjson(graph,data):

        newDic =Parser.parse_city(data)
        newList = Parser.parse_route(data)
        oldList = graph.getedge()
        oldList = oldList + newList
        oldDic = graph.getvetex()
        oldDic = dict(list(oldDic.items()+list(newDic.items())))
        graph.setedge(oldList)
        graph.setvetex(oldDic)
        print("merge new json file to old one successfully!")