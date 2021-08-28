/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Plane;
import java.util.List;

/**
 *
 * @author Vusal
 */
public interface PlaneDao {

    public List<Plane> getPlaneList() throws Exception;

    public boolean addPlane(Plane plane) throws Exception;

    public boolean updatePlane(Plane plane) throws Exception;

    public Plane getPlaneById(long selectedId) throws Exception;

    public boolean deletePlane(long selectedId) throws Exception;
    
    public List<Plane> searchPlane(String word) throws Exception;
}
