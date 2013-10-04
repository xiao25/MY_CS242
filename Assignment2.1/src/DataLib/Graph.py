__author__ = 'ztx'
from ParseData import QueryMethod,QueryMethodExtension
from DataLib import QueryData

class Graph:
    """graph class to store all json data"""
    def __init__(self,vetex, edge):
        self.vetex = vetex
        self.edge = edge
    def getvetex(self):
        return self.vetex
    def getedge(self):
        return self.edge

    def setvetex(self,vetex):
        self.vetex = vetex
    def setedge(self,edge):
        self.edge = edge

    def rmvetex(self,name):
        """remove a city from citydictionary. in for loop to remove two direction edge in route,
        index should be -1 everytime
        """
        citys = self.getvetex()
        deletelist = []
        validcode = False
        for cityname,city in citys.items():
            if cityname == name:

                routes = self.getedge()
                for route in routes:
                    if route.departure == QueryMethod.nameToCode(name,self) or route.destination == QueryMethod.nameToCode(name,self):
                        deletelist.append(route)

                for route in deletelist:
                   self.rmedge(route)
                QueryMethodExtension.rmHubCity(city)
                del citys[name]
                validcode = True
                print("Remove city successfully!")

        if validcode == False:
            print("No such city name in data!")

    def rmedge(self,route):
        try:
          self.getedge().remove(route)
        except ValueError:
            pass
        QueryMethodExtension.minusHubCity(route)


    def getvextexcode(self):
        list = []
        for key,value in self.getvetex().items():
            list.append(value.code)
        return list

    def addvetex(self,city):
        citys = self.getvetex()
        citys[city.name] = city
        QueryData.hubCity[city.code] = 0

    def addedge(self,route):
        self.getedge().append(route)
        QueryMethodExtension.addHubCity(route)

    def edcity(self,cityname,changevalue,x):
        validcode = False
        citys = self.getvetex()
        for key,city in citys.items():
            if city.name == cityname:
                validcode = True
                break
        if validcode:
            if x == 0:
                city.code = changevalue
            elif x == 1:
                city.name = changevalue
                citys[changevalue] = city
                del citys[cityname]
            elif x == 2:
                city.country = changevalue
            elif x == 3:
                city.continent = changevalue
            elif x==4:
                city.timezone = changevalue
            elif x==5:
                city.coordinates = changevalue
            elif x==6:
                city.population = changevalue
            elif x==7:
                city.region = changevalue


        else:
            print("The cityname doesn't exist!")




    def isint(self,number):
        try:
            val = int(number)
            return True
        except ValueError:
            return False



