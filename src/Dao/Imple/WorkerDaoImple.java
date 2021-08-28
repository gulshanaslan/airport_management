/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Imple;

import Dao.DBHelper;
import Dao.WorkerDao;
import Model.Worker;
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
public class WorkerDaoImple implements WorkerDao {

    @Override
    public List<Worker> getWorkerList() throws Exception {
        List<Worker> workers = new ArrayList<>();
        DBHelper dBHelper = new DBHelper();
        String sql = "Select * from airportticket.worker where Active=1;";
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = dBHelper.getConnection();
        if (c != null) {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Worker worker = new Worker();
                worker.setId(rs.getLong("Id"));
                worker.setName(rs.getString("Name"));
                worker.setSurname(rs.getString("Surname"));
                worker.setPassport_id(rs.getString("Passport_Id"));
                worker.setPosition(rs.getString("Position"));
                worker.setSalary(rs.getLong("Salary"));
                worker.setActive(rs.getLong("Active"));
                workers.add(worker);
            }
        }

        return workers;
    }

    @Override
    public boolean addWorker(Worker worker) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "insert into airportticket.worker value(?,?,?,?,?,?,?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, (int) worker.getId());
                ps.setString(2, worker.getName());
                ps.setString(3, worker.getSurname());
                ps.setString(4, worker.getPassport_id());
                ps.setString(5, worker.getPosition());
                ps.setLong(6, worker.getSalary());
                ps.setLong(7, worker.getActive());
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
    public boolean updateWorker(Worker worker) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.worker set Name=?,Surname=?,Passport_Id=?,Position=?,Salary=?,Active=? where Id=?;";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(7, worker.getId());
                ps.setString(1, worker.getName());
                ps.setString(2, worker.getSurname());
                ps.setString(3, worker.getPassport_id());
                ps.setString(4, worker.getPosition());
                ps.setLong(5, worker.getSalary());
                ps.setLong(6, worker.getActive());
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
    public Worker getWorkerById(long selectedId) throws Exception {
        Worker worker = new Worker();
        DBHelper dBHelper = new DBHelper();
        String sql = "Select * from airportticket.worker where Id=?;";
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = dBHelper.getConnection();
        if (c != null) {
            ps = c.prepareStatement(sql);
            ps.setLong(1, selectedId);
            rs = ps.executeQuery();
            while (rs.next()) {
                worker.setId(rs.getLong("Id"));
                worker.setName(rs.getString("Name"));
                worker.setSurname(rs.getString("Surname"));
                worker.setPassport_id(rs.getString("Passport_Id"));
                worker.setPosition(rs.getString("Position"));
                worker.setSalary(rs.getLong("Salary"));
                worker.setActive(rs.getLong("Active"));
            }
        }

        return worker;
    }

    @Override
    public boolean deleteWorker(long selectedId) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update airportticket.worker set Active=0 where Id=?;";
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
    public List<Worker> searchWorker(String word) throws Exception {
        List<Worker> workers = new ArrayList<>();
        DBHelper dBHelper = new DBHelper();
        String sql = "SELECT * FROM airportticket.worker\n"
                + "where lower(Name) like lower(?) or lower(Surname) like lower(?)or lower(Passport_Id) like lower(?) or lower(Position) like lower(?) or lower(Salary) like lower(?) and Active=1;";
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = dBHelper.getConnection();
        if (c != null) {
            ps = c.prepareStatement(sql);
            for(int i=1;i<=5;i++){
                ps.setString(i, "%"+ word +"%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Worker worker = new Worker();
                worker.setId(rs.getLong("Id"));
                worker.setName(rs.getString("Name"));
                worker.setSurname(rs.getString("Surname"));
                worker.setPassport_id(rs.getString("Passport_Id"));
                worker.setPosition(rs.getString("Position"));
                worker.setSalary(rs.getLong("Salary"));
                worker.setActive(rs.getLong("Active"));
                workers.add(worker);
            }
        }

        return workers;
    }

}
