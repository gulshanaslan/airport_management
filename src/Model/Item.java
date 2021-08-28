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
public class Item {

    private long id;
    private String Value;

    public Item(long id, String value) {
        this.id = id;
        this.Value = value;
    }

    @Override
    public String toString() {
        return Value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

}
