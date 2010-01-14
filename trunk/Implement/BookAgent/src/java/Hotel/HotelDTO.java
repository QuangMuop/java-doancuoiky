
package Hotel;

/**
 * Class HotelDTO dung de chuyen giao khi su dung web service cua BookAgent
 * @author hvu
 */
public class HotelDTO {
    private String detail;
    private String name;
    private String address;
    private int room;

    public String getName() {
        return this.name;
    }

    

    public String getDetail() {
        return this.detail;
    }
    public String getAddress() {
        return this.address;
    }
    public int getRoom() {
        return this.room;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void setDetail(String description) {
        this.detail = description;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
