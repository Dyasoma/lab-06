package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.addCity(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, mockCityList().getCities().size());
        City city = new City("Regina", "Sasketchewan");
        cityList.addCity(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.addCity((city));
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.addCity(city);
        });
    }
    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        //This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        // Now the original city should be in position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));

    }

    @Test
    void testHasCities(){
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(cityList.getCities().get(0)));
        City city = new City("Toronto", "Ontario");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteCities(){
        CityList cityList = mockCityList();
        City city = cityList.getCities().get(0);
        assertEquals(city, cityList.deleteCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });

    }

    @Test
    void testCountCities(){
        CityList citylist = mockCityList();
        citylist.addCity(new City("Calgary", "Alberta"));
        citylist.addCity(new City("Vancouver", "British Columbia"));
        assertEquals(3, (int) citylist.countCity());
    }
}