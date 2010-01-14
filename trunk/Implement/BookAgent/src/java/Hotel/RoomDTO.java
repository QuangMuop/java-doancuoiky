
package Hotel;

/**
 * Class RoomDTO dung de chuyen giao khi su dung web service cua BookAgent
 * @author hvu
 */
public class RoomDTO {
    private String id;
    private int cost;
    private boolean stay;

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

    public boolean getStay() {
        return this.stay;
    }

    public void setStay(boolean stay) {
        this.stay = stay;
    }
}
