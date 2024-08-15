package com.javeed.services;

import java.util.List;

import com.javeed.entities.BusRoute;

public interface BusRouteService {
	
	BusRoute addRoute(BusRoute busRoute);
    List<BusRoute> getAllBusRoutes();

    BusRoute getRouteByRouteName(String routeName);

    BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo);

}
