import cmd
import json
import urllib2
from ParseData import Parser,QueryMethod, RouteInfo,Dijkstra,GenerateJson,Extendjson
from ParseData.QueryMethod import invalidCityName, invalidcode
from DataLib import City
import SubInterpreter
__author__ = 'ztx'



class MyCmdInterpreter(cmd.Cmd):
    """use extend cmd object to implement Text UI"""
    intro = 'Welcome to the query CSAir system.   Type help or ? to list commands.\n'

    def __init__(self, graph):
        cmd.Cmd.__init__(self)

        self.graph = graph




    """----basic query commands----"""
    def do_listcity(self, s):

        """Get all the cities that CSAir files to"""
        cityDictionary = QueryMethod.getCity(self.graph)
        print 'Here is all cities that CSAir flies to...'
        for city in cityDictionary:
            print city
        print '\n'

    def do_cityinfo(self,s):

        """Get specific information about a specific city in the CSAir route network"""
        cityname = raw_input("Please type the city's name: \n")
        try:
            if QueryMethod.getQueryCity(cityname,self.graph)!= True:
               raise invalidCityName(cityname)
        except invalidCityName:

            print "*** Sorry, CSAir does not fly to " + cityname
        print '\n'

    def do_statistic(self, s):

        """Get all statistical information about CSAir\'s route network"""
        QueryMethod.getStaticalInfomation(self.graph)
        print '\n'

    def do_getmap(self,s):

        """Get visualized CSAir\'s route map,type all to get all cities' map"""
        citycode = raw_input("Please type the city's code or all for all cities: \n")
        try:
            if QueryMethod.mapCity(citycode,self.graph) == False:

                raise invalidcode(citycode)
        except invalidcode:
             print "*** Sorry, CSAir does not fly to " + citycode

    def do_editgraph(self,s):
        """add,remove or upate a vetex or edge in graph"""
        sub_cmd = SubInterpreter.SubInterpreter(self.graph)
        sub_cmd.cmdloop()



    def do_getjson(self,s):
        """auto generate json file"""
        GenerateJson.encode(self.graph)


    def do_routeinfo(self,s):
         """get route info(distance,time,cost) based on a list of cities"""
         citylist = raw_input("Please type the list of city name(split with comma): \n")
         citys = citylist.split(",")
         citycodes = []
         valid = True
         for city in citys:
             code = QueryMethod.nameToCode(city,self.graph)
             if (code!= False):
                 citycodes.append(code)
             else:
                 print("This cityname is wrong :"+city)
                 valid = False
                 break
         if valid:
            RouteInfo.routeinfo(citycodes,self.graph)

    def do_shortest(self,s):
        """get the shortest route between two cities"""
        citylist = raw_input("Please type the two city names(split with comma): \n")
        citynames = citylist.split(",")
        if citynames.__len__() == 2:
            code0 =  QueryMethod.nameToCode(citynames[0],self.graph)
            code1 =  QueryMethod.nameToCode(citynames[1],self.graph)
            if (code0 != False and code1 != False):
                path = Dijkstra.dijkstra(self.graph,code0,code1)

                RouteInfo.routeinfo(path,self.graph)

            else:
                print("The cityname doesn't exist!")
        else:
            print("Please type two citynames")

    def do_extendjson(self,s):
        """combine a new json file into old one"""
        new_url = raw_input("Please type the url of new json file:")
        json_data = urllib2.urlopen(new_url)
        data = json.load(json_data)
        json_data.close()
        Extendjson.extendjson(self.graph,data)

    def do_exit(self, s):

        """Exit the system"""
        print('Thank you for using this query system!')
        return True




parse = Parser.Parser()
Graph = parse.parse()
interpreter = MyCmdInterpreter(Graph)
interpreter.cmdloop()
