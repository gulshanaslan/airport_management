/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Imple;

import Dao.DBHelper;
import Dao.PlaneDao;
import Model.Company;
import Model.Country;
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
public class PlaneDaoImple implements PlaneDao {

    @Override
    public List<Plane> getPlaneList() throws Exception {
        List<Plane> planes = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select p.Id,p.Name,p.Capacity,p.Active p_active,c.Id c_id,c.Company_name,c.Active c_active,con.Id con_id,con.Name con_name,con.Active con_active from airportticket.planes p\n"
                + "inner join airportticket.company c on p.Company_Id=c.Id\n"
                + "inner join airportticket.country con on c.Id=con.Id where p.Active=1;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Plane plane = new Plane();
                plane.setId(rs.getLong("Id"));
                plane.setName(rs.getString("Name"));
                plane.setCapacity(rs.getLong("Capacity"));
                plane.setActive(rs.getLong("p_active"));
                Company comp = new Company();
                comp.setId(rs.getLong("c_id"));
                comp.setCompany_name(rs.getString("Company_name"));
                Country con = new Country();
                con.setId(rs.getLong("con_id"));
                con.setName(rs.getString("con_name"));
                con.setActive(rs.getLong("con_active"));
                comp.setCountry(con);
                plane.setCompany(comp);
                planes.add(plane);
            }
        } else {
            System.out.println("Sehv var..!");
        }
        return planes;
    }

    @Override
    public boolean addPlane(Plane plane) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "insert into airportticket.planes value(?,?,?,?,?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, (int) plane.getId());
                ps.setString(2, plane.getName());
                ps.setLong(3, plane.getCapacity());
                ps.setLong(4, plane.getCompany().getId());
                ps.setLong(5, plane.getActive());
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
    public boolean updatePlane(Plane plane) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.planes set Name=?,Capacity=?,Company_Id=?,Active=? where Id=?";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(5, (int) plane.getId());
                ps.setString(1, plane.getName());
                ps.setLong(2, plane.getCapacity());
                ps.setLong(3, plane.getCompany().getId());
                ps.setLong(4, plane.getActive());
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
    public Plane getPlaneById(long selectedId) throws Exception {
        Plane plane = new Plane();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select p.Id,p.Name,p.Capacity,p.Active p_active,c.Id c_id,c.Company_name,c.Active c_active,con.Id con_id,con.Name con_name,con.Active con_active from airportticket.planes p\n"
                + "inner join airportticket.company c on p.Company_Id=c.Id\n"
                + "inner join airportticket.country con on c.Id=con.Id where p.Id=?;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            ps.setLong(1, selectedId);
            rs = ps.executeQuery();
            while (rs.next()) {

                plane.setId(rs.getLong("Id"));
                plane.setName(rs.getString("Name"));
                plane.setCapacity(rs.getLong("Capacity"));
                plane.setActive(rs.getLong("p_active"));
                Company comp = new Company();
                comp.setId(rs.getLong("c_id"));
                comp.setCompany_name(rs.getString("Company_name"));
                Country con = new Country();
                con.setId(rs.getLong("con_id"));
                con.setName(rs.getString("con_name"));
                con.setActive(rs.getLong("con_active"));
                comp.setCountry(con);
                plane.setCompany(comp);
            }
        } else {
            System.out.println("Sehv var..!");
        }
        return plane;
    }

    @Override
    public boolean deletePlane(long selectedId) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.planes set Active=0 where Id=?";
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
    public List<Plane> searchPlane(String word) throws Exception {
        List<Plane> planes = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select p.Id,p.Name,p.Capacity,p.Active p_active,c.Id c_id,c.Company_name,c.Active c_active,con.Id con_id,con.Name con_name,con.Active con_active from airportticket.planes p \n"
                + "                inner join airportticket.company c on p.Company_Id=c.Id\n"
                + "                inner join airportticket.country con on c.Id=con.Id \n"
                + "                where lower(p.Name)like lower(?)or lower(p.Capacity) like lower(?)or lower(c.Company_name) like lower(?) or lower(con.Name) like lower(?) and p.Active=1;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            for(int i=1; i<=4 ; i++){
                    ps.setString(i, "%" + word + "%");
                }
            rs = ps.executeQuery();
            while (rs.next()) {
                Plane plane = new Plane();
                plane.setId(rs.getLong("Id"));
                plane.setName(rs.getString("Name"));
                plane.setCapacity(rs.getLong("Capacity"));
                plane.setActive(rs.getLong("p_active"));
                Company comp = new Company();
                comp.setId(rs.getLong("c_id"));
                comp.setCompany_name(rs.getString("Company_name"));
                Country con = new Country();
                con.setId(rs.getLong("con_id"));
                con.setName(rs.getString("con_name"));
                con.setActive(rs.getLong("con_active"));
                comp.setCountry(con);
                plane.setCompany(comp);
                planes.add(plane);
            }
        } else {
            System.out.println("Sehv var..!");
        }
        return planes;
    }

}
