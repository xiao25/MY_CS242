__author__ = 'ztx'

import cmd
from ParseData import  QueryMethodExtension
from DataLib import Route,City
import ThirdInterpreter
class SubInterpreter(cmd.Cmd):
    """This is the second level menu to hold the edit of graph"""
    intro = 'This is a second list commands for edit graph. Type help or ? to list commands.\n'
    prompt = "(editgraph) "

    def __init__(self, graph):
        cmd.Cmd.__init__(self)

        self.graph = graph

    def do_addcity(self, args):
        """add a city into graph"""
        name = raw_input("Plese type the name of new city:\n")
        keys = QueryMethodExtension.getkey(self.graph.getvetex())
        if name  in keys:
            print("This city has already existed!")
        else:
            strings = raw_input("Please type the new city's code country continent timezone longitude latitude population region(split between space): \n")
            numbers = strings.split(" ")
            validcode = True
            if numbers.__len__() != 8:
                validcode = False
                print ("all the info about this new city should be input!")
            else:
                for i in range(3,7):
                    if self.graph.isint(numbers[i]) == False:
                        print("timezone,coordinates,population and region should be number!")
                        validcode = False
            if validcode:
                coordinates = {}
                coordinates["N"] = numbers[4]
                coordinates["W"] = numbers[5]
                self.graph.addvetex(City.City(numbers[0].upper(),name,numbers[1],numbers[2].upper(),numbers[3],coordinates,numbers[6],numbers[7]))
                print("add new city successfully!")


    def do_addroute(self,s):
        """add a route into a graph"""
        departure = raw_input("Please type the new route's departure citycode:\n")
        destination = raw_input("Please type the new route's destination citycode:\n")
        distance = raw_input("Please type the new route's distance: \n")
        option = raw_input("Would you like to add this route in two directions? Yes:No")


        if  ((departure.upper() in self.graph.getvextexcode()) == False) or ((destination.upper() in self.graph.getvextexcode()) == False):
            print("the code for departure city or destination does not exist!")
        else:
            if self.graph.isint(distance) == False or distance < 0:
                print("distance should be positive number!")
            else:
                if option == "Yes":
                    self.graph.addedge(Route.Route(destination,departure,distance))


                self.graph.addedge(Route.Route(departure,destination,distance))
                print("add new route successfully!")


    def do_rmcity(self,s):
        """reomove a city from graph"""
        cityname = raw_input("Please type the city's name: \n")
        self.graph.rmvetex(cityname)

    def do_rmroute(self,s):
        """remove an edge from graph"""
        departure = raw_input("Please type the deleted route's departure citycode:\n")
        destination = raw_input("Please type the deleted route's destination citycode:\n")
        option = raw_input("Would you like to delete this route in two directions? YES:NO")
        deroute = []
        for route in self.graph.getedge():
            if route.departure == departure and route.destination == destination:
               deroute.append(route)
            else:
                if option.upper() == "YES" and route.departure == destination and route.destination == departure:
                 deroute.append(route)

        if deroute != []:
            for route in deroute:
                self.graph.rmedge(route)
            print("Remove route(s) successfully!")
        else:
            print("This route does not exist!")

    def do_edcity(self,s):
        """edit a city in graph"""
        sub1_cmd = ThirdInterpreter.ThirdInterpreter(self.graph)
        sub1_cmd.cmdloop()

    def do_quit(self, args):
        return True

    do_EOF = do_quit