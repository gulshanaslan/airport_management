/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Imple;

import Dao.CountryDao;
import Dao.DBHelper;
import Model.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vusal
 */
public class CountryDaoImple implements CountryDao {

    @Override
    public List<Country> getCountryList() throws Exception {
        List<Country> countrys=new ArrayList<>();
        Connection c=DBHelper.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from airportticket.country where Active=1;";
        if(c!=null){
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Country country=new Country();
                country.setId(rs.getLong("Id"));
                country.setName(rs.getString("Name"));
                country.setActive(rs.getLong("Active"));
                countrys.add(country);
            }
        }else{
            System.out.println("Sehv Var..!");
        }
        return countrys;
    }

}
