/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Company;
import java.util.List;

/**
 *
 * @author Vusal
 */
public interface CompanyDao {

    public List<Company> getCompanyList() throws Exception;

    public boolean addCompany(Company company) throws Exception;

    public boolean updateCompany(Company company) throws Exception;

    public Company getCompanyById(long selectedId) throws Exception;

    public boolean deleteCompany(long selectedId) throws Exception;
    
    public List<Company> searchCompany(String word)throws Exception;
}
