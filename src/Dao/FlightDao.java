/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Flight;
import java.util.List;

/**
 *
 * @author Vusal
 */
public interface FlightDao {

    public List<Flight> getFlightList() throws Exception;

    public boolean addFlight(Flight flight) throws Exception;

    public Flight getFlightById(long id) throws Exception;

    public boolean updateFlight(Flight flight) throws Exception;

    public boolean deleteFlight(long selectedId) throws Exception;

    public List<Flight> searchFlight(String keyword) throws Exception;
    
    public List<Flight> searchAdvancedFlight(Flight flight1) throws Exception;
}
