import webbrowser

__author__ = 'ztx'
from DataLib import City, QueryData

""" define several methods for UI to call"""



def getCity(graph):
    """ return all city name"""
    cityList =[]
    for city in graph.getvetex():
        cityList.append(city)
    return cityList

def getQueryCity(cityname,graph):
     """ return all info for a specific city """
     D_city = graph.getvetex();
     for city in D_city:
        if cityname == city:
            queryCity = D_city[city]
            print 'Code: ' + queryCity.code
            print 'Name: ' + queryCity.name
            print 'Country: ' + queryCity.country
            print 'Continent: '+ queryCity.continent
            print 'Timezone: ' + str(queryCity.timezone)
            print 'Population: ' + str(queryCity.population)
            print 'Region: ' + str(queryCity.region)


            coordinatesList = []
            for dir, num in queryCity.coordinates.iteritems():
                coordString = dir + ': ' + str(num)
                coordinatesList.append(coordString)
            print coordinatesList

            flyToList = getFlyToCity(cityname,graph)
            print '\nFly To Cities and Distance: '
            if flyToList == True:
                for flyToCities, distance in flyToList.iteritems():
                    print  flyToCities + ': ' + str(distance) + ' miles'
            return True
     return False



def getFlyToCity(cityname,graph):
    """return any cities a specific can fly to"""
    sourceCode = nameToCode(cityname,graph)

    destinationList = {}
    for route in graph.getedge():
        if route.departure == sourceCode:
            destinationList[codeToname(route.destination,graph)] = route.distance
        if route.destination == sourceCode:
            destinationList[codeToname(route.departure,graph)] = route.distance
    return destinationList



def nameToCode(cityname,graph):
    """change the city name to its code"""
    citys = graph.getvetex()
    for city in citys:
        if city == cityname:
            return citys[cityname].code
    return False


def codeToname(code,graph):
    """change city code to its name"""
    citys = graph.getvetex()
    for name,city in citys.iteritems():
        if code == city.code:
            return name
    return False


def getStaticalInfomation(graph):
    """return all statistical info for all data"""
    print 'The longest single flight: [' + QueryData.longest.departure +',' + QueryData.longest.destination + '] distance:' + str(QueryData.longest.distance)

    print 'The shortest single flight: [' + QueryData.shortest.departure +',' + QueryData.shortest.destination + '] distance:' + str(QueryData.shortest.distance)
    print 'The average distance: ' + str(QueryData.averageDistance) + ' miles'
    print 'The biggest city: "' + QueryData.biggestCity.name + "\":" + str(QueryData.biggestCity.population)
    print 'The smallest city: "' + QueryData.smallestCity.name+ "\":" + str(QueryData.smallestCity.population)
    print 'The average city population: ' + str(QueryData.averageCitySize) + '\n'

    print 'Asia:'
    printList(QueryData.asia)
    print 'Europe:'
    printList(QueryData.europe)
    print 'North America:'
    printList(QueryData.northAmerica)
    print 'South America:'
    printList(QueryData.southAmerica)
    print 'Africa:'
    printList(QueryData.africa)
    print ""
    hubs = getHubCityList(graph)
    print 'Hub cities: '
    for item in hubs:
        print item



def printList(list):
    """helper function to print a list"""
    string = ""
    i = 0
    for item in list:
        string = string + item
        i += 1
        if i < len(list):
            string +=  ','

    print string
    print ""



def mapCity(cityCode,graph):
    """visualize the airline for a specific city"""
    url = "http://www.gcmap.com/mapui?P="
    validCode = False
    if cityCode == "all":
        validCode = True
        for item in graph.getedge():
            url = url + cityCode + '-' + item.destination + ','
    else:
        for item in graph.getedge():
            if item.departure == cityCode:
                url = url + cityCode + '-' + item.destination + ','
                validCode = True
            if item.destination == cityCode:
                url = url + cityCode + '-' + item.departure + ','
                validCode = True

    if validCode:
        webbrowser.open_new_tab(url)

    return validCode



def addHub(code):
     """count the number of cities this city can fly to"""
     if code in QueryData.hubCity:
        QueryData.hubCity[code] += 1
     else:
        QueryData.hubCity[code] = 0



def getHubCityList(graph):
    """find out the city has highest count number"""
    maxx = 0
    hubCityList = []
    for code,value in QueryData.hubCity.iteritems():
        if value > maxx:
            maxx = value
            hubCityList[:] = []
            hubCityList.append(codeToname(code,graph))

        else:
            if value == maxx:
                hubCityList.append(codeToname(code,graph))




    return hubCityList



def cityToContient(name,continent):
    """get city names in each continent"""
    if continent == 'North America':
        QueryData.northAmerica.append(name)
    elif continent == 'South America':
        QueryData.southAmerica.append(name)
    elif continent == 'Asia':
        QueryData.asia.append(name)
    elif continent == 'Africa':
        QueryData.africa.append(name)
    elif continent == 'Europe':
        QueryData.europe.append(name)
    elif continent == 'Australia':
        QueryData.australia.append(name)


class invalidCityName(Exception):
    """exception for invalid input"""
    def __init__(self, value):
      self.value = value
    def __str__(self):
      return repr(self.value)

class invalidcode(Exception):
    """exception for invalid input"""
    def __init__(self, value):
      self.value = value
    def __str__(self):
      return repr(self.value)

