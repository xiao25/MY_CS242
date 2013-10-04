__author__ = 'ztx'

import cmd
from DataLib import Route,City
from ParseData import QueryMethod
class ThirdInterpreter(cmd.Cmd):
    """This is third level command menu to handle the the edit of specific city"""
    intro = 'This is a third list commands for edit city. Type help or ? to list commands.\n'
    prompt = "(editcity) "

    def __init__(self, graph):
        cmd.Cmd.__init__(self)

        self.graph = graph
    def do_editcode(self,s):
        cityname = raw_input("Please type the city's name: \n")


        code = raw_input("Please type the new code:")
        self.graph.edcity(cityname,code.upper(),0)
        QueryMethod.getQueryCity(cityname,self.graph)


    def do_editname(self,s):
        cityname = raw_input("Please type the city's name: \n")
        name = raw_input("Please type the new name:")
        self.graph.edcity(cityname,name,1)
        QueryMethod.getQueryCity(name,self.graph)

    def do_editcountry(self,s):
        cityname = raw_input("Please type the city's name: \n")
        country = raw_input("Please type the new country:")
        self.graph.edcity(cityname,country.upper(),2)
        QueryMethod.getQueryCity(cityname,self.graph)

    def do_editcontinent(self,s):
        cityname = raw_input("Please type the city's name: \n")
        continent = raw_input("Please type the new continent:")
        self.graph.edcity(cityname,continent,3)
        QueryMethod.getQueryCity(cityname,self.graph)


    def do_edittimezone(self,s):
        cityname = raw_input("Please type the city's name: \n")
        timezone = raw_input("Please type the new timezone:")
        if self.graph.isint(timezone) == True:
            self.graph.edcity(cityname,timezone,4)
            QueryMethod.getQueryCity(cityname,self.graph)
        else:
            print("The new timezone should be number!")

    def do_editcoordinates(self,s):
        cityname = raw_input("Please type the city's name: \n")
        continent = raw_input("Please type the new longitude and latitude:(split with space)")
        numbers = continent.split(" ")
        if numbers.__len__()== 2 and self.graph.isint(numbers[0]) == True and self.graph.isint(numbers[1]) == True:
            coordinates = {}
            coordinates["N"] = numbers[0]
            coordinates["W"] = numbers[1]
            self.graph.edcity(cityname,coordinates,5)
            QueryMethod.getQueryCity(cityname,self.graph)
        else:
            print("Please input two valid numbers which splits with space!")

    def do_editpopulation(self,s):
        cityname = raw_input("Please type the city's name: \n")
        population = raw_input("Please type the new population:")
        if self.graph.isint(population) and population > 0:
            self.graph.edcity(cityname,population,6)
            QueryMethod.getQueryCity(cityname,self.graph)
        else:
            print("The new population should be positive number!")
    def do_editregion(self,s):
        cityname = raw_input("Please type the city's name: \n")
        region = raw_input("Please type the new region:")
        if self.graph.isint(region) and region > 0:
            self.graph.edcity(cityname,region,7)
            QueryMethod.getQueryCity(cityname,self.graph)
        else:
            print("The new region should be positive number!")


    def do_quit(self, args):
        return True

    do_EOF = do_quit