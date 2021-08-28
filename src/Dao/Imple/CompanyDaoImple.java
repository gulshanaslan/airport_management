/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Imple;

import Dao.CompanyDao;
import Dao.DBHelper;
import Model.Company;
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
public class CompanyDaoImple implements CompanyDao {

    @Override
    public List<Company> getCompanyList() throws Exception {
        List<Company> companys = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT c.Id,c.Company_name,c.Active,country.Id country_id,country.Name country_name , country.Active country_active FROM airportticket.company c\n"
                + "inner join airportticket.country country on c.Company_country=country.Id where c.Active=1 ;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Company company = new Company();
                company.setId(rs.getLong("Id"));
                company.setCompany_name(rs.getString("Company_name"));
                company.setActive(rs.getLong("Active"));
                Country country = new Country();
                country.setId(rs.getLong("country_id"));
                country.setName(rs.getString("country_name"));
                country.setActive(rs.getLong("country_active"));
                company.setCountry(country);
                companys.add(company);
            }
        } else {
            System.out.println("Sehv var");
        }
        return companys;
    }

    @Override
    public boolean addCompany(Company company) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "insert into airportticket.company value(?,?,?,?);";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, (int) company.getId());
                ps.setString(2, company.getCompany_name());
                ps.setLong(3, company.getCountry().getId());
                ps.setLong(4, company.getActive());

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
    public boolean updateCompany(Company company) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update company set Company_name=?,Company_country=?,Active=? where Id=?";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(4, (int) company.getId());
                ps.setString(1, company.getCompany_name());
                ps.setLong(2, company.getCountry().getId());
                ps.setLong(3, company.getActive());

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
    public Company getCompanyById(long selectedId) throws Exception {
        Company company = new Company();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT c.Id,c.Company_name,c.Active,country.Id country_id,country.Name country_name , country.Active country_active FROM airportticket.company c\n"
                + "inner join airportticket.country country on c.Company_country=country.Id where c.Id=? ;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            ps.setLong(1, selectedId);
            rs = ps.executeQuery();
            while (rs.next()) {

                company.setId(rs.getLong("Id"));
                company.setCompany_name(rs.getString("Company_name"));
                company.setActive(rs.getLong("Active"));
                Country country = new Country();
                country.setId(rs.getLong("country_id"));
                country.setName(rs.getString("country_name"));
                country.setActive(rs.getLong("country_active"));
                company.setCountry(country);
            }
        } else {
            System.out.println("Sehv var");
        }
        return company;
    }

    @Override
    public boolean deleteCompany(long selectedId) throws Exception {
        boolean isAdded = true;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = "update company set Active=0 where Id=?";
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
    public List<Company> searchCompany(String word) throws Exception {
        List<Company> companys = new ArrayList<>();
        Connection c = DBHelper.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT c.Id,c.Company_name,c.Active,country.Id country_id,country.Name country_name , country.Active country_active FROM airportticket.company c\n"
                + "                inner join airportticket.country country on c.Company_country=country.Id\n"
                + "                where lower(c.Company_name) like lower(?) or lower(country.Name) like lower(?) and   c.Active=1 ;";
        if (c != null) {
            ps = c.prepareStatement(sql);
            ps.setString(1, "%" + word + "%");
            ps.setString(2, "%" + word + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Company company = new Company();
                company.setId(rs.getLong("Id"));
                company.setCompany_name(rs.getString("Company_name"));
                company.setActive(rs.getLong("Active"));
                Country country = new Country();
                country.setId(rs.getLong("country_id"));
                country.setName(rs.getString("country_name"));
                country.setActive(rs.getLong("country_active"));
                company.setCountry(country);
                companys.add(company);
            }
        } else {
            System.out.println("Sehv var");
        }
        return companys;
    }

}
