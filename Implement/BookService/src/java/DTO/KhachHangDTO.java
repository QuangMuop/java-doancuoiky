/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author bin
 */
public class KhachHangDTO {
    String name;
    String birthDay;
    String id;

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
