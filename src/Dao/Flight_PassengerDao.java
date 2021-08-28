/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Flight_Passenger;
import java.util.List;

/**
 *
 * @author Vusal
 */
public interface Flight_PassengerDao {

    public List<Flight_Passenger> getFlightPassengerList() throws Exception;

    public boolean addFlight_Passenger(Flight_Passenger flight_Passenger) throws Exception;

    public Flight_Passenger getFlight_PassengerById(long id) throws Exception;

    public boolean updateFlight_Passenger(Flight_Passenger flight_Passenger) throws Exception;

    public boolean deleteFlight_Passenger(long selectedId) throws Exception;

    public List<Flight_Passenger> searchFlight_Passengers(String word) throws Exception;
    
    public List<Flight_Passenger> searchAdvancedFlight_Passengers(Flight_Passenger flight_Passenger) throws Exception;
}
