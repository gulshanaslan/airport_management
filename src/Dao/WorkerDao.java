/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Worker;
import java.util.List;

/**
 *
 * @author Vusal
 */
public interface WorkerDao {

    List<Worker> getWorkerList() throws Exception;

    public boolean addWorker(Worker worker) throws Exception;

    public boolean updateWorker(Worker worker) throws Exception;

    public Worker getWorkerById(long selectedId) throws Exception;

    public boolean deleteWorker(long selectedId) throws Exception;

    public List<Worker> searchWorker(String word) throws Exception;
}
