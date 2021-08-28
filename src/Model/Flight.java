/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Vusal
 */
public class Flight {

    private long id;
    private long flight_code;
    private Airport departure_airport;
    private Airport arrival_airport;
    private Company company;
    private Plane plane;
    private Date departure_date;
    private Date arrival_date;
    private long active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFlight_code() {
        return flight_code;
    }

    public void setFlight_code(long flight_code) {
        this.flight_code = flight_code;
    }

    public Airport getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(Airport departure_airport) {
        this.departure_airport = departure_airport;
    }

    public Airport getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(Airport arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }
    
    

}
