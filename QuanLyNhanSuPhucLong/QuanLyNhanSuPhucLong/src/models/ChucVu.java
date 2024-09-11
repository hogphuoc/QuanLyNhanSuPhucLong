/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;



/**
 *
 * @author ADMIN
 */
public class ChucVu {
    private String machucvu;
    private String tenchucvu;
    private String macv;

    public ChucVu(String machucvu, String tenchucvu, String macv) {
        this.machucvu = machucvu;
        this.tenchucvu = tenchucvu;
        this.macv = macv;
    }

    public String getMachucvu() {
        return machucvu;
    }
    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }
    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    public String getMacv() {
        return macv;
    }
    public void setMacv(String macv) {
        this.macv = macv;
    }   
}
