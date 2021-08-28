/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Country;
import java.util.List;

/**
 *
 * @author Vusal
 */
public interface CountryDao {

    public List<Country> getCountryList() throws Exception;
}
