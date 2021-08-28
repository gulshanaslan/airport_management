/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Passenger;
import java.util.List;

/**
 *
 * @author Vusal
 */
public interface PassengerDao {

    public List<Passenger> getPassengerList() throws Exception;

    public boolean AddPassenger(Passenger passenger) throws Exception;

    public Passenger getPassengerById(long id) throws Exception;

    public boolean updatedPassenger(Passenger passenger) throws Exception;

    public boolean deletePassenger(long selectedId) throws Exception;

    public List<Passenger> searchPassenger(String word) throws Exception;
}
