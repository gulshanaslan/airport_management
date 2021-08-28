/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Vusal
 */
public class Passenger {
    
    private long Id;
    private String Name;
    private String Surname;
    private String PassportId;
    private long Active;

    /**
     * @return the Dd
     */
    public long getId() {
        return Id;
    }

    /**
     * @param Dd the Dd to set
     */
    public void setId(long Id) {
        this.Id = Id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * @param Surname the Surname to set
     */
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    /**
     * @return the PassportId
     */
    public String getPassportId() {
        return PassportId;
    }

    /**
     * @param PassportId the PassportId to set
     */
    public void setPassportId(String PassportId) {
        this.PassportId = PassportId;
    }

    /**
     * @return the Active
     */
    public long getActive() {
        return Active;
    }

    /**
     * @param Active the Active to set
     */
    public void setActive(long Active) {
        this.Active = Active;
    }
    
    
    
    
}
