/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Imple;

import Dao.DBHelper;
import Dao.Flight_PassengerDao;
import Model.Airport;
import Model.Company;
import Model.Flight;
import Model.Flight_Passenger;
import Model.Passenger;
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
public class Flight_PassengerDaoImple implements Flight_PassengerDao {

    @Override
    public List<Flight_Passenger> getFlightPassengerList() throws Exception {
        List<Flight_Passenger> flight_Passengers = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select fp.Id,f.Id f_id,f.Flight_code,dep.Id dep_id,dep.Name dep_name,dep.Active dep_active,arr.Id arr_id,arr.Name arr_name,arr.Active arr_active,c.Id c_id,c.Company_name,c.Active c_active,pl.Id pl_id,pl.Name pl_name,pl.Capacity,pl.Active pl_active,f.Departure_date,f.Arrival_date,f.Active f_active,p.Id p_id, p.Name,p.Surname,p.Passport_Id,p.Active p_active,fp.Active from airportticket.flight_passenger fp\n"
                + "inner join airportticket.flights f on fp.flight_id=f.Id\n"
                + "inner join airportticket.passengers p on fp.Passenger_id=p.Id\n"
                + "inner join airportticket.airports dep on f.Departure_airport=dep.Id\n"
                + "inner join airportticket.airports arr on f.Arrival_airport=arr.Id\n"
                + "inner join airportticket.company c on f.Company_id=c.Id\n"
                + "inner join airportticket.planes pl on f.Plane_id=pl.Id where fp.Active=1 ;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Flight_Passenger fp = new Flight_Passenger();
                fp.setId(rs.getLong("Id"));
                fp.setActive(rs.getLong("Active"));
                Flight f = new Flight();
                f.setId(rs.getLong("f_id"));
                f.setFlight_code(rs.getLong("Flight_code"));
                Airport dep = new Airport();
                dep.setId(rs.getLong("dep_id"));
                dep.setName(rs.getString("dep_name"));
                dep.setActive(rs.getLong("dep_active"));
                f.setDeparture_airport(dep);
                Airport arr = new Airport();
                arr.setId(rs.getLong("arr_id"));
                arr.setName(rs.getString("arr_name"));
                arr.setActive(rs.getLong("arr_active"));
                f.setArrival_airport(arr);
                Company comp = new Company();
                comp.setId(rs.getLong("c_id"));
                comp.setCompany_name(rs.getString("Company_name"));
                comp.setActive(rs.getLong("c_active"));
                f.setCompany(comp);
                Plane pl = new Plane();
                pl.setId(rs.getLong("pl_id"));
                pl.setName(rs.getString("pl_name"));
                pl.setCapacity(rs.getLong("Capacity"));
                pl.setActive(rs.getLong("pl_active"));
                f.setPlane(pl);
                f.setDeparture_date(rs.getDate("Departure_date"));
                f.setArrival_date(rs.getDate("Arrival_date"));
                f.setActive(rs.getLong("f_active"));
                fp.setFlight(f);
                Passenger p = new Passenger();
                p.setId(rs.getLong("p_id"));
                p.setName(rs.getString("Name"));
                p.setSurname(rs.getString("Surname"));
                p.setPassportId(rs.getString("Passport_Id"));
                p.setActive(rs.getLong("p_active"));
                fp.setPassenger(p);
                fp.setActive(rs.getLong("Active"));
                flight_Passengers.add(fp);
            }
        } else {
            System.out.println("Sehv Var..!");
        }

        return flight_Passengers;
    }

    @Override
    public boolean addFlight_Passenger(Flight_Passenger flight_Passenger) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "insert into airportticket.flight_passenger value(?,?,?,?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, flight_Passenger.getId());
                ps.setLong(2, flight_Passenger.getFlight().getId());
                ps.setLong(3, flight_Passenger.getPassenger().getId());
                ps.setLong(4, flight_Passenger.getActive());
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
    public Flight_Passenger getFlight_PassengerById(long id) throws Exception {
        Flight_Passenger fp = new Flight_Passenger();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select fp.Id,f.Id f_id,f.Flight_code,dep.Id dep_id,dep.Name dep_name,dep.Active dep_active,arr.Id arr_id,arr.Name arr_name,arr.Active arr_active,c.Id c_id,c.Company_name,c.Active c_active,pl.Id pl_id,pl.Name pl_name,pl.Capacity,pl.Active pl_active,f.Departure_date,f.Arrival_date,f.Active f_active,p.Id p_id, p.Name,p.Surname,p.Passport_Id,p.Active p_active,fp.Active from airportticket.flight_passenger fp\n"
                + "inner join airportticket.flights f on fp.flight_id=f.Id\n"
                + "inner join airportticket.passengers p on fp.Passenger_id=p.Id\n"
                + "inner join airportticket.airports dep on f.Departure_airport=dep.Id\n"
                + "inner join airportticket.airports arr on f.Arrival_airport=arr.Id\n"
                + "inner join airportticket.company c on f.Company_id=c.Id\n"
                + "inner join airportticket.planes pl on f.Plane_id=pl.Id where fp.Id=?;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                fp.setId(rs.getLong("Id"));
                fp.setActive(rs.getLong("Active"));
                Flight f = new Flight();
                f.setId(rs.getLong("f_id"));
                f.setFlight_code(rs.getLong("Flight_code"));
                Airport dep = new Airport();
                dep.setId(rs.getLong("dep_id"));
                dep.setName(rs.getString("dep_name"));
                dep.setActive(rs.getLong("dep_active"));
                f.setDeparture_airport(dep);
                Airport arr = new Airport();
                arr.setId(rs.getLong("arr_id"));
                arr.setName(rs.getString("arr_name"));
                arr.setActive(rs.getLong("arr_active"));
                f.setArrival_airport(arr);
                Company comp = new Company();
                comp.setId(rs.getLong("c_id"));
                comp.setCompany_name(rs.getString("Company_name"));
                comp.setActive(rs.getLong("c_active"));
                f.setCompany(comp);
                Plane pl = new Plane();
                pl.setId(rs.getLong("pl_id"));
                pl.setName(rs.getString("pl_name"));
                pl.setCapacity(rs.getLong("Capacity"));
                pl.setActive(rs.getLong("pl_active"));
                f.setPlane(pl);
                f.setDeparture_date(rs.getDate("Departure_date"));
                f.setArrival_date(rs.getDate("Arrival_date"));
                f.setActive(rs.getLong("f_active"));
                fp.setFlight(f);
                Passenger p = new Passenger();
                p.setId(rs.getLong("p_id"));
                p.setName(rs.getString("Name"));
                p.setSurname(rs.getString("Surname"));
                p.setPassportId(rs.getString("Passport_Id"));
                p.setActive(rs.getLong("p_active"));
                fp.setPassenger(p);
                fp.setActive(rs.getLong("Active"));

            }
        } else {
            System.out.println("Sehv Var..!");
        }

        return fp;
    }

    @Override
    public boolean updateFlight_Passenger(Flight_Passenger flight_Passenger) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.flight_passenger set flight_id=?,Passenger_id=?,Active=? where id=?;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, flight_Passenger.getFlight().getId());
                ps.setLong(2, flight_Passenger.getPassenger().getId());
                ps.setLong(3, flight_Passenger.getActive());
                ps.setLong(4, flight_Passenger.getId());
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
    public boolean deleteFlight_Passenger(long selectedId) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.flight_passenger set Active=0 where id=?;";
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
    public List<Flight_Passenger> searchFlight_Passengers(String word) throws Exception {
        List<Flight_Passenger> flight_Passengers = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select fp.Id,f.Id f_id,f.Flight_code,dep.Id dep_id,dep.Name dep_name,dep.Active dep_active,arr.Id arr_id,arr.Name arr_name,arr.Active arr_active,c.Id c_id,c.Company_name,c.Active c_active,pl.Id pl_id,pl.Name pl_name,pl.Capacity,pl.Active pl_active,f.Departure_date,f.Arrival_date,f.Active f_active,p.Id p_id, p.Name,p.Surname,p.Passport_Id,p.Active p_active,fp.Active from airportticket.flight_passenger fp\n"
                + "inner join airportticket.flights f on fp.flight_id=f.Id\n"
                + "inner join airportticket.passengers p on fp.Passenger_id=p.Id\n"
                + "inner join airportticket.airports dep on f.Departure_airport=dep.Id\n"
                + "inner join airportticket.airports arr on f.Arrival_airport=arr.Id\n"
                + "inner join airportticket.company c on f.Company_id=c.Id\n"
                + "inner join airportticket.planes pl on f.Plane_id=pl.Id where fp.Active=1 ;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Flight_Passenger fp = new Flight_Passenger();
                fp.setId(rs.getLong("Id"));
                fp.setActive(rs.getLong("Active"));
                Flight f = new Flight();
                f.setId(rs.getLong("f_id"));
                f.setFlight_code(rs.getLong("Flight_code"));
                Airport dep = new Airport();
                dep.setId(rs.getLong("dep_id"));
                dep.setName(rs.getString("dep_name"));
                dep.setActive(rs.getLong("dep_active"));
                f.setDeparture_airport(dep);
                Airport arr = new Airport();
                arr.setId(rs.getLong("arr_id"));
                arr.setName(rs.getString("arr_name"));
                arr.setActive(rs.getLong("arr_active"));
                f.setArrival_airport(arr);
                Company comp = new Company();
                comp.setId(rs.getLong("c_id"));
                comp.setCompany_name(rs.getString("Company_name"));
                comp.setActive(rs.getLong("c_active"));
                f.setCompany(comp);
                Plane pl = new Plane();
                pl.setId(rs.getLong("pl_id"));
                pl.setName(rs.getString("pl_name"));
                pl.setCapacity(rs.getLong("Capacity"));
                pl.setActive(rs.getLong("pl_active"));
                f.setPlane(pl);
                f.setDeparture_date(rs.getDate("Departure_date"));
                f.setArrival_date(rs.getDate("Arrival_date"));
                f.setActive(rs.getLong("f_active"));
                fp.setFlight(f);
                Passenger p = new Passenger();
                p.setId(rs.getLong("p_id"));
                p.setName(rs.getString("Name"));
                p.setSurname(rs.getString("Surname"));
                p.setPassportId(rs.getString("Passport_Id"));
                p.setActive(rs.getLong("p_active"));
                fp.setPassenger(p);
                fp.setActive(rs.getLong("Active"));
                flight_Passengers.add(fp);
            }
        } else {
            System.out.println("Sehv Var..!");
        }

        return flight_Passengers;
    }

    @Override
    public List<Flight_Passenger> searchAdvancedFlight_Passengers(Flight_Passenger flight_Passenger) throws Exception {
        List<Flight_Passenger> flight_Passengers = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select fp.Id,f.Id f_id,f.Flight_code,dep.Id dep_id,dep.Name dep_name,dep.Active dep_active,arr.Id arr_id,arr.Name arr_name,arr.Active arr_active,c.Id c_id,c.Company_name,c.Active c_active,pl.Id pl_id,pl.Name pl_name,pl.Capacity,pl.Active pl_active,f.Departure_date,f.Arrival_date,f.Active f_active,p.Id p_id, p.Name,p.Surname,p.Passport_Id,p.Active p_active,fp.Active from airportticket.flight_passenger fp\n"
                + "inner join airportticket.flights f on fp.flight_id=f.Id\n"
                + "inner join airportticket.passengers p on fp.Passenger_id=p.Id\n"
                + "inner join airportticket.airports dep on f.Departure_airport=dep.Id\n"
                + "inner join airportticket.airports arr on f.Arrival_airport=arr.Id\n"
                + "inner join airportticket.company c on f.Company_id=c.Id\n"
                + "inner join airportticket.planes pl on f.Plane_id=pl.Id where f.Id=? and fp.Active=1 ;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            ps.setLong(1, flight_Passenger.getFlight().getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                Flight_Passenger fp = new Flight_Passenger();
                fp.setId(rs.getLong("Id"));
                fp.setActive(rs.getLong("Active"));
                Flight f = new Flight();
                f.setId(rs.getLong("f_id"));
                f.setFlight_code(rs.getLong("Flight_code"));
                Airport dep = new Airport();
                dep.setId(rs.getLong("dep_id"));
                dep.setName(rs.getString("dep_name"));
                dep.setActive(rs.getLong("dep_active"));
                f.setDeparture_airport(dep);
                Airport arr = new Airport();
                arr.setId(rs.getLong("arr_id"));
                arr.setName(rs.getString("arr_name"));
                arr.setActive(rs.getLong("arr_active"));
                f.setArrival_airport(arr);
                Company comp = new Company();
                comp.setId(rs.getLong("c_id"));
                comp.setCompany_name(rs.getString("Company_name"));
                comp.setActive(rs.getLong("c_active"));
                f.setCompany(comp);
                Plane pl = new Plane();
                pl.setId(rs.getLong("pl_id"));
                pl.setName(rs.getString("pl_name"));
                pl.setCapacity(rs.getLong("Capacity"));
                pl.setActive(rs.getLong("pl_active"));
                f.setPlane(pl);
                f.setDeparture_date(rs.getDate("Departure_date"));
                f.setArrival_date(rs.getDate("Arrival_date"));
                f.setActive(rs.getLong("f_active"));
                fp.setFlight(f);
                Passenger p = new Passenger();
                p.setId(rs.getLong("p_id"));
                p.setName(rs.getString("Name"));
                p.setSurname(rs.getString("Surname"));
                p.setPassportId(rs.getString("Passport_Id"));
                p.setActive(rs.getLong("p_active"));
                fp.setPassenger(p);
                fp.setActive(rs.getLong("Active"));
                flight_Passengers.add(fp);
            }
        } else {
            System.out.println("Sehv Var..!");
        }

        return flight_Passengers;
    }

}
