/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Imple;

import Dao.AirportDao;
import Dao.DBHelper;
import Model.Airport;
import Model.Country;
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
public class AirportDaoImple implements AirportDao {

    @Override
    public List<Airport> getAirportList() throws Exception {
        List<Airport> airports = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select a.Id,a.Name,a.Country_id,a.Active,c.Id country_id,c.Name country_name,c.Active country_active from airportticket.airports a\n"
                + "inner join airportticket.country c on a.Country_id=c.Id where a.Active=1;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Airport airport = new Airport();
                airport.setId(rs.getLong("Id"));
                airport.setName(rs.getString("Name"));
                Country country = new Country();
                country.setId(rs.getLong("country_Id"));
                country.setName(rs.getString("country_name"));
                country.setActive(rs.getLong("country_active"));
                airport.setCountry(country);
                airport.setActive(rs.getLong("Active"));
                airports.add(airport);
            }
        }
        return airports;
    }

    @Override
    public boolean addAirport(Airport airport) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "insert into airportticket.airports value(?,?,?,?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, (int) airport.getId());
                ps.setString(2, airport.getName());
                ps.setLong(3, airport.getCountry().getId());
                ps.setLong(4, airport.getActive());
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
    public Airport getAirportById(long selectedId) throws Exception {
        Airport airport1 = new Airport();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select a.Id,a.Name,a.Country_id,a.Active,c.Id country_id,c.Name country_name,c.Active country_active from airportticket.airports a\n"
                + "inner join airportticket.country c on a.Country_id=c.Id where a.Id=?;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            ps.setLong(1, selectedId);
            rs = ps.executeQuery();
            while (rs.next()) {
                airport1.setId(rs.getLong("Id"));
                airport1.setName(rs.getString("Name"));
                Country country = new Country();
                country.setId(rs.getLong("country_Id"));
                country.setName(rs.getString("country_name"));
                country.setActive(rs.getLong("country_active"));
                airport1.setCountry(country);
                airport1.setActive(rs.getLong("Active"));

            }
        }
        return airport1;
    }

    @Override
    public boolean updateAirport(Airport airport) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.airports set Name=?,Country_id=?,Active=? where Id=?;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(4, (int) airport.getId());
                ps.setString(1, airport.getName());
                ps.setLong(2, airport.getCountry().getId());
                ps.setLong(3, airport.getActive());
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
    public boolean deleteAirport(long selectedId) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.airports set Active=0 where Id=?;";
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
    public List<Airport> searchPassenger(String word) throws Exception {
        List<Airport> airports = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select a.Id,a.Name,a.Country_id,a.Active,c.Id country_id,c.Name country_name,c.Active country_active from airportticket.airports a\n"
                + "                inner join airportticket.country c on a.Country_id=c.Id \n"
                + "                where lower(a.Name) like lower(?) or lower(c.Name)like lower(?) and a.Active=1;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            for (int i = 1; i <= 2; i++) {
                ps.setString(i, "%" + word + "%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Airport airport = new Airport();
                airport.setId(rs.getLong("Id"));
                airport.setName(rs.getString("Name"));
                Country country = new Country();
                country.setId(rs.getLong("country_Id"));
                country.setName(rs.getString("country_name"));
                country.setActive(rs.getLong("country_active"));
                airport.setCountry(country);
                airport.setActive(rs.getLong("Active"));
                airports.add(airport);
            }
        }
        return airports;
    }

    @Override
    public List<Airport> searchAdvancedAirports(Airport airport1) throws Exception {
 List<Airport> airports = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select a.Id,a.Name,a.Country_id,a.Active,c.Id country_id,c.Name country_name,c.Active country_active from airportticket.airports a\n"
                + "                inner join airportticket.country c on a.Country_id=c.Id \n"
                + "                where c.Id=? and a.Active=1;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            ps.setLong(1, airport1.getCountry().getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                Airport airport = new Airport();
                airport.setId(rs.getLong("Id"));
                airport.setName(rs.getString("Name"));
                Country country = new Country();
                country.setId(rs.getLong("country_Id"));
                country.setName(rs.getString("country_name"));
                country.setActive(rs.getLong("country_active"));
                airport.setCountry(country);
                airport.setActive(rs.getLong("Active"));
                airports.add(airport);
            }
        }
        return airports;
    }

}
