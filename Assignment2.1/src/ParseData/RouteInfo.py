__author__ = 'ztx'
from ParseData import  QueryMethod
from DataLib import  QueryData

def routeinfo(citys,graph):
    """get the route info"""
    len = citys.__len__()
    totaldistance = 0
    totalcost = 0
    layovertime = 0

    if len < 2:
        print("Please at least input two cities here!")
    else:

        for i in range(0 , len-1):

            dis = iscityinroute(citys[i],citys[i+1],graph.getedge())
            if dis!= -1:
                totaldistance +=  dis
                totalcost += dis*(0.35 - i*0.05)
                if i != (len -1):
                    layovertime += (120 - 10*QueryData.hubCity[citys[i+1]])
            else:
                print("The city list can not construct a valid route!")
                break

        #change kph to km/s
        vec = (750 * 0.277777778)/1000
        publicfactor = 2/vec
        if totaldistance < 400:
            flytime = publicfactor*(totaldistance)

        else:
            flytime = publicfactor*400 + (totaldistance - 400)/vec

        totaltime = flytime +  layovertime
        print totaldistance
        print totalcost
        print totaltime
        return totaldistance






def iscityinroute(code0,code1,routes):
    """find the citylist is legal route or not."""
    for route in routes:
        if code0 == route.departure and code1 == route.destination:
            return route.distance

    return -1