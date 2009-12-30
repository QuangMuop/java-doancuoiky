
package Hotel;

import org.w3c.dom.Element;

/**
 *
 * @author hvu
 */
public class RoomInfo {
    private String id;
    private int maxPeople;
    private int canStay;

    public String getId() {
        return this.id;
    }

    public int getMaxPeople() {
        return this.maxPeople;
    }

    public boolean isCanStay() {
        return (this.canStay == 0);
    }

    public RoomInfo(String id, int maxPeople, int canStay) {
        this.id = id;
        this.maxPeople = maxPeople;
        this.canStay = canStay;
    }

    public RoomInfo(Element elem) {
        String rid = elem.getAttribute("id");
        String sMaxPeople = elem.getAttribute("max");
        int iMaxPeople = 0;
        if (sMaxPeople != null && !sMaxPeople.equals("")) {
            iMaxPeople = Integer.parseInt(sMaxPeople);
        }

        String sCanStay = elem.getAttribute("status");
        int iCanStay = 0;
        if (sCanStay != null && !sCanStay.equals("")) {
            iCanStay = Integer.parseInt(sCanStay);
        }

        this.id = rid;
        this.maxPeople = iMaxPeople;
        this.canStay = iCanStay;
    }

    public static RoomInfo load(Element elem) {
        return (new RoomInfo(elem));
    }
}
