/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Imple;

import Dao.DBHelper;
import Dao.FlightDao;
import Model.Airport;
import Model.Company;
import Model.Flight;
import Model.Plane;
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
public class FlightDaoImple implements FlightDao {

    @Override
    public List<Flight> getFlightList() throws Exception {
        List<Flight> flights = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT f.Id,f.Flight_code,dep.Id dep_id, dep.Name dep_name, arr.Id arr_id,arr.Name arr_name,c.Id comp_id,c.Company_name comp_name,p.Id plane_id,p.Name plane_name,p.Capacity plane_capacity,f.Active,f.Departure_date,f.Arrival_date FROM airportticket.flights f\n"
                + "INNER JOIN airportticket.airports dep on f.Departure_airport=dep.Id\n"
                + "INNER JOIN airportticket.airports arr on f.Arrival_airport=arr.Id\n"
                + "INNER JOIN airportticket.company c on f.Company_id=c.Id\n"
                + "INNER JOIN airportticket.planes p on f.Plane_id=p.Id where f.Active=1;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getLong("Id"));
                flight.setFlight_code(rs.getLong("Flight_code"));
                Airport dep_airport = new Airport();
                dep_airport.setId(rs.getLong("dep_id"));
                dep_airport.setName(rs.getString("dep_name"));
                flight.setDeparture_airport(dep_airport);
                Airport arr_airport = new Airport();
                arr_airport.setId(rs.getLong("arr_id"));
                arr_airport.setName(rs.getString("arr_name"));
                flight.setArrival_airport(arr_airport);
                Company company = new Company();
                company.setId(rs.getLong("comp_id"));
                company.setCompany_name(rs.getString("comp_name"));
                flight.setCompany(company);
                Plane plane = new Plane();
                plane.setId(rs.getLong("plane_id"));
                plane.setName(rs.getString("plane_name"));
                plane.setCapacity(rs.getLong("plane_capacity"));
                flight.setPlane(plane);
                flight.setDeparture_date(rs.getDate("Departure_date"));
                flight.setArrival_date(rs.getDate("Arrival_date"));
                flight.setActive(rs.getLong("Active"));
                flights.add(flight);
            }
        }
        return flights;

    }

    @Override
    public boolean addFlight(Flight flight) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "insert into airportticket.flights value(?,?,?,?,?,?,?,?,?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, (int) flight.getId());
                ps.setLong(2, flight.getFlight_code());
                ps.setLong(3, flight.getDeparture_airport().getId());
                ps.setLong(4, flight.getArrival_airport().getId());
                ps.setLong(5, flight.getCompany().getId());
                ps.setLong(6, flight.getPlane().getId());
                ps.setDate(7, flight.getDeparture_date());
                ps.setDate(8, flight.getArrival_date());
                ps.setLong(9, flight.getActive());
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
    public Flight getFlightById(long id) throws Exception {
        Flight flight = new Flight();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT f.Id,f.Flight_code,dep.Id dep_id, dep.Name dep_name, arr.Id arr_id,arr.Name arr_name,c.Id comp_id,c.Company_name comp_name,p.Id plane_id,p.Name plane_name,p.Capacity plane_capacity,f.Active,f.Departure_date,f.Arrival_date FROM airportticket.flights f\n"
                + "INNER JOIN airportticket.airports dep on f.Departure_airport=dep.Id\n"
                + "INNER JOIN airportticket.airports arr on f.Arrival_airport=arr.Id\n"
                + "INNER JOIN airportticket.company c on f.Company_id=c.Id\n"
                + "INNER JOIN airportticket.planes p on f.Plane_id=p.Id where f.Id=?;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    flight.setId(rs.getLong("Id"));
                    flight.setFlight_code(rs.getLong("Flight_code"));
                    Airport dep_airport = new Airport();
                    dep_airport.setId(rs.getLong("dep_id"));
                    dep_airport.setName(rs.getString("dep_name"));
                    flight.setDeparture_airport(dep_airport);
                    Airport arr_airport = new Airport();
                    arr_airport.setId(rs.getLong("arr_id"));
                    arr_airport.setName(rs.getString("arr_name"));
                    flight.setArrival_airport(arr_airport);
                    Company company = new Company();
                    company.setId(rs.getLong("comp_id"));
                    company.setCompany_name(rs.getString("comp_name"));
                    flight.setCompany(company);
                    Plane plane = new Plane();
                    plane.setId(rs.getLong("plane_id"));
                    plane.setName(rs.getString("plane_name"));
                    plane.setCapacity(rs.getLong("plane_capacity"));
                    flight.setPlane(plane);
                    flight.setDeparture_date(rs.getDate("Departure_date"));
                    flight.setArrival_date(rs.getDate("Arrival_date"));
                    flight.setActive(rs.getLong("Active"));

                }
            } else {
                System.err.println("ERROR!(no connection)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.breakConnection(c, ps, rs);
        }

        return flight;
    }

    @Override
    public boolean updateFlight(Flight flight) throws Exception {
        boolean isUpdate = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.flights  set Flight_code=?,Departure_airport=?,Arrival_airport=?,Company_id=?,Plane_id=?,Departure_date=?,Arrival_date=?,Active=? where id=?;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, flight.getFlight_code());
                ps.setLong(2, flight.getDeparture_airport().getId());
                ps.setLong(3, flight.getArrival_airport().getId());
                ps.setLong(4, flight.getCompany().getId());
                ps.setLong(5, flight.getPlane().getId());
                ps.setDate(6, flight.getDeparture_date());
                ps.setDate(7, flight.getArrival_date());
                ps.setLong(8, flight.getActive());
                ps.setLong(9, flight.getId());
                ps.execute();
                isUpdate = true;
            } else {
                System.err.println("ERROR!(no connection)");
            }
        } catch (Exception e) {
            e.printStackTrace();
            isUpdate = false;
        } finally {
            JdbcUtility.breakConnection(c, ps, null);
        }

        return isUpdate;
    }

    @Override
    public boolean deleteFlight(long selectedId) throws Exception {
        boolean isUpdate = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.flights  set Active=0 where id=?;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, selectedId);

                ps.execute();
                isUpdate = true;
            } else {
                System.err.println("ERROR!(no connection)");
            }
        } catch (Exception e) {
            e.printStackTrace();
            isUpdate = false;
        } finally {
            JdbcUtility.breakConnection(c, ps, null);
        }

        return isUpdate;
    }

    @Override
    public List<Flight> searchFlight(String keyword) throws Exception {
        List<Flight> flights = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT f.Id,f.Flight_code,dep.Id dep_id, dep.Name dep_name, arr.Id arr_id,arr.Name arr_name,c.Id comp_id,c.Company_name comp_name,p.Id plane_id,p.Name plane_name,p.Capacity plane_capacity,f.Active,f.Departure_date,f.Arrival_date FROM airportticket.flights f\n"
                + "                INNER JOIN airportticket.airports dep on f.Departure_airport=dep.Id\n"
                + "                INNER JOIN airportticket.airports arr on f.Arrival_airport=arr.Id\n"
                + "                INNER JOIN airportticket.company c on f.Company_id=c.Id\n"
                + "                INNER JOIN airportticket.planes p on f.Plane_id=p.Id\n"
                + "                where lower(f.Flight_code) like lower(?) or lower(dep.Name) like lower(?) or lower(arr.Name) like lower(?) or lower(f.Departure_date) like lower(?) or lower(f.Arrival_date) like lower(?) or lower(c.Company_name) like lower(?) or lower(p.Name) like lower(?) and f.Active=1";
        if (c != null) {
            ps = c.prepareStatement(sql);
            for (int i = 1; i <= 7; i++) {
                ps.setString(i, "%" + keyword + "%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getLong("Id"));
                flight.setFlight_code(rs.getLong("Flight_code"));
                Airport dep_airport = new Airport();
                dep_airport.setId(rs.getLong("dep_id"));
                dep_airport.setName(rs.getString("dep_name"));
                flight.setDeparture_airport(dep_airport);
                Airport arr_airport = new Airport();
                arr_airport.setId(rs.getLong("arr_id"));
                arr_airport.setName(rs.getString("arr_name"));
                flight.setArrival_airport(arr_airport);
                Company company = new Company();
                company.setId(rs.getLong("comp_id"));
                company.setCompany_name(rs.getString("comp_name"));
                flight.setCompany(company);
                Plane plane = new Plane();
                plane.setId(rs.getLong("plane_id"));
                plane.setName(rs.getString("plane_name"));
                plane.setCapacity(rs.getLong("plane_capacity"));
                flight.setPlane(plane);
                flight.setDeparture_date(rs.getDate("Departure_date"));
                flight.setArrival_date(rs.getDate("Arrival_date"));
                flight.setActive(rs.getLong("Active"));
                flights.add(flight);
            }
        }
        return flights;
    }

    @Override
    public List<Flight> searchAdvancedFlight(Flight flight1) throws Exception {
        List<Flight> flights = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT f.Id,f.Flight_code,dep.Id dep_id, dep.Name dep_name, arr.Id arr_id,arr.Name arr_name,c.Id comp_id,c.Company_name comp_name,p.Id plane_id,p.Name plane_name,p.Capacity plane_capacity,f.Active,f.Departure_date,f.Arrival_date FROM airportticket.flights f\n"
                + "INNER JOIN airportticket.airports dep on f.Departure_airport=dep.Id\n"
                + "INNER JOIN airportticket.airports arr on f.Arrival_airport=arr.Id\n"
                + "INNER JOIN airportticket.company c on f.Company_id=c.Id\n"
                + "INNER JOIN airportticket.planes p on f.Plane_id=p.Id\n"
                + "where f.Departure_date between CAST(? AS DATE)and CAST(? AS DATE)  and f.Active=1";
        if (c != null) {
            ps = c.prepareStatement(sql);
            ps.setDate(1, flight1.getDeparture_date());
            ps.setDate(2, flight1.getArrival_date());

            rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getLong("Id"));
                flight.setFlight_code(rs.getLong("Flight_code"));
                Airport dep_airport = new Airport();
                dep_airport.setId(rs.getLong("dep_id"));
                dep_airport.setName(rs.getString("dep_name"));
                flight.setDeparture_airport(dep_airport);
                Airport arr_airport = new Airport();
                arr_airport.setId(rs.getLong("arr_id"));
                arr_airport.setName(rs.getString("arr_name"));
                flight.setArrival_airport(arr_airport);
                Company company = new Company();
                company.setId(rs.getLong("comp_id"));
                company.setCompany_name(rs.getString("comp_name"));
                flight.setCompany(company);
                Plane plane = new Plane();
                plane.setId(rs.getLong("plane_id"));
                plane.setName(rs.getString("plane_name"));
                plane.setCapacity(rs.getLong("plane_capacity"));
                flight.setPlane(plane);
                flight.setDeparture_date(rs.getDate("Departure_date"));
                flight.setArrival_date(rs.getDate("Arrival_date"));
                flight.setActive(rs.getLong("Active"));
                flights.add(flight);
            }
        }
        return flights;
    }

}
