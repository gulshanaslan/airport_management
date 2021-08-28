/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Imple;

import Dao.DBHelper;
import Dao.PassengerDao;
import Model.Passenger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.JdbcUtility;

/**
 *
 * @author Vusal
 */
public class PassengerDaoImple implements PassengerDao {

    DBHelper dbHelper = new DBHelper();

    @Override
    public List<Passenger> getPassengerList() throws Exception {
        List<Passenger> passengers = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM AIRPORTTICKET.PASSENGERS where Active=1;";
            c = dbHelper.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Passenger passenger = new Passenger();
                passenger.setId(rs.getLong("Id"));
                passenger.setName(rs.getString("Name"));
                passenger.setSurname(rs.getString("Surname"));
                passenger.setPassportId(rs.getString("Passport_Id"));
                passenger.setActive(rs.getLong("Active"));
                passengers.add(passenger);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }

        return passengers;
    }

    @Override
    public boolean AddPassenger(Passenger passenger) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "insert into airportticket.passengers value(?,?,?,?,?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, (int) passenger.getId());
                ps.setString(2, passenger.getName());
                ps.setString(3, passenger.getSurname());
                ps.setString(4, passenger.getPassportId());
                ps.setLong(5, passenger.getActive());
                ps.execute();
                isAdded = true;
            } else {
                System.err.println("ERROR!(no connection)");

            }
        } catch (Exception e) {
            e.printStackTrace();
            isAdded = false;
        } finally {
            JdbcUtility.breakConnection(c, ps, null);
        }
        return isAdded;
    }

    @Override
    public Passenger getPassengerById(long id) throws Exception {
        Passenger passenger = new Passenger();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM AIRPORTTICKET.PASSENGERS where Id=?;";
            c = dbHelper.getConnection();
            ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                passenger.setId(rs.getLong("Id"));
                passenger.setName(rs.getString("Name"));
                passenger.setSurname(rs.getString("Surname"));
                passenger.setPassportId(rs.getString("Passport_Id"));
                passenger.setActive(rs.getLong("Active"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }

        return passenger;
    }

    @Override
    public boolean updatedPassenger(Passenger passenger) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.passengers set Name=?,Surname=?,Passport_Id=?,Active=? where Id=?;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(5, (int) passenger.getId());
                ps.setString(1, passenger.getName());
                ps.setString(2, passenger.getSurname());
                ps.setString(3, passenger.getPassportId());
                ps.setLong(4, passenger.getActive());
                ps.execute();
                isAdded = true;
            } else {
                System.err.println("ERROR!(no connection)");

            }
        } catch (Exception e) {
            e.printStackTrace();
            isAdded = false;
        } finally {
            JdbcUtility.breakConnection(c, ps, null);
        }
        return isAdded;
    }

    @Override
    public boolean deletePassenger(long selectedId) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.passengers set Active=0 where Id=?;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, selectedId);

                ps.execute();
                isAdded = true;
            } else {
                System.err.println("ERROR!(no connection)");

            }
        } catch (Exception e) {
            e.printStackTrace();
            isAdded = false;
        } finally {
            JdbcUtility.breakConnection(c, ps, null);
        }
        return isAdded;
    }

    @Override
    public List<Passenger> searchPassenger(String word) throws Exception {
        List<Passenger> passengers = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM airportticket.passengers\n"
                    + "where lower(Name) like lower(?) or lower(Surname) like lower(?) or lower(Passport_Id) like lower(?) and Active=1;";
            c = dbHelper.getConnection();
            ps = c.prepareStatement(sql);
            for (int i = 1; i <= 3; i++) {
                ps.setString(i, "%" + word + "%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Passenger passenger = new Passenger();
                passenger.setId(rs.getLong("Id"));
                passenger.setName(rs.getString("Name"));
                passenger.setSurname(rs.getString("Surname"));
                passenger.setPassportId(rs.getString("Passport_Id"));
                passenger.setActive(rs.getLong("Active"));
                passengers.add(passenger);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }

        return passengers;
    }

}
