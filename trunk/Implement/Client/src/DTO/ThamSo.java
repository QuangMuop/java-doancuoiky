/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;



/**
 *
 * @author bin
 */
public class ThamSo {
    private int value;
    private boolean use;
    private String name;

    public String getName()
    {
        return this.name;
    }

    public int getValue()
    {
        return this.value;
    }

    public boolean isUse()
    {
        return this.use;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public void setUse(boolean use)
    {
        this.use = use;
    }
}
