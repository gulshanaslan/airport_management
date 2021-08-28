/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Airport;
import java.util.List;

/**
 *
 * @author Vusal
 */
public interface AirportDao {

    public List<Airport> getAirportList() throws Exception;

    public boolean addAirport(Airport airport) throws Exception;

    public Airport getAirportById(long selectedId) throws Exception;

    public boolean updateAirport(Airport airport) throws Exception;

    public boolean deleteAirport(long selectedId) throws Exception;

    public List<Airport> searchPassenger(String word) throws Exception;
    
    public List<Airport> searchAdvancedAirports(Airport airport ) throws Exception;
}
