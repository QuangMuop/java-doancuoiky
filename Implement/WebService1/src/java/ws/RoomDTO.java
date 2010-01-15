/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

/**
 *
 * @author bin
 */
public class RoomDTO {
    private String id;
    private int cost;
    boolean canStay;
    String detail;

    public String getDetail()
    {
        return this.detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public void setCanStay(boolean canStay)
    {
        this.canStay = canStay;
    }

    public boolean getCanStay()
    {
        return this.canStay;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

