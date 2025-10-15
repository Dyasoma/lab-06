package com.example.listycity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a new city to the list if it doesn't exist
     * @param city
     *      This is the city we are adding
     * @throws IllegalArgumentException
     *      if city already exists in list
     */
    public void addCity(City city){
        if (cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     *  Determines if a given city is contained within this CityList
     * @param city
     *      the city we are checking in the list
     * @return
     *      True if city is found within the list, False otherwise
     */
    public Boolean hasCity(City city){
        return this.getCities().contains(city);
    }

    /**
     *  This deletes a city from the list of cities
     * @param city
     *      The city to be removed
     * @return
     *      the city that was removed assuming it is in the list of cities
     * @throws IllegalArgumentException
     *      if city is not in the list of cities
     */
    public City deleteCity(City city){
        if (this.getCities().contains(city)){
            return this.getCities().remove(this.getCities().indexOf(city));
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Provides the number of cities in the list of cities.
     *
     * @return
     *      The number of cities
     */
    public Integer countCity(){
        return this.getCities().size();
    }
}


