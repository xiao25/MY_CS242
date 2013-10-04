__author__ = 'ztx'



class City:

    """
    city class to store city object in json
    """


    def __init__(self, code, name, country,
                 continent, timezone, coordinates,
                 population, region ):

        self.code = code
        self.name = name
        self.country = country
        self.continent = continent
        self.timezone = timezone
        self.coordinates = coordinates
        self.population = population
        self.region = region