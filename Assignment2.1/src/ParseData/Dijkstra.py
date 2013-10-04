__author__ = 'ztx'
"""
implement of dijkstra algorithm
"""
def dijkstra(graph,citycode0,citycode1):
    dis = {}
    q = graph.getvetex().copy()
    previous = {}
    for key,vertex in q.items():
        dis[vertex.code] = float('inf')
        previous[vertex.code] =float('inf')

    # distance to itself is 0
    dis[citycode0] = 0
    routes = getroutelist(citycode0,graph.getedge())
    for r in routes:
        dis[r.destination] = r.distance
        previous[r.destination] =r.departure

    s = []

    while q.__len__() != 0:
        u = extract_min(q)
        s.append(u)
        for route in getroutelist(u,graph.getedge()):
            if dis[route.destination] > dis[u] + route.distance:
                dis[route.destination] = dis[u] + route.distance
                previous[route.destination] = u

    shrotestdis = dis[citycode1]
    s= citycode1
    vistedpath = []
    vistedpath.append(citycode1)
    if shrotestdis != float('inf'):
        print("The shortest distance is "+str(shrotestdis))
        while previous[citycode1] != float('inf'):

            s = s+"<-"+previous[citycode1]
            citycode1 = previous[citycode1]
            vistedpath.append(citycode1)

        print(s)
        return vistedpath[::-1]
    else:
        print("There doesn't exist a valid route between these two cities!")
        return False


def extract_min(citys):
    """put any node in q to s until q is empty"""
    for key,city in citys.items():
        del citys[city.name]
        return city.code

def getroutelist(ucode,routes):
    """helper function to get a list of route which starts with u"""
    routelist = []
    for route in routes:
        if route.departure == ucode:
            routelist.append(route)
    return routelist