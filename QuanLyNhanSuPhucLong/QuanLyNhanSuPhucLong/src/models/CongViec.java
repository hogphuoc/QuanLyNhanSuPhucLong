/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ADMIN
 */
public class CongViec {
    private String macv;
    private String mapb;
    private String HinhThucCV;

    public CongViec(String macv, String mapb, String HinhThucCV) {
        this.macv = macv;
        this.mapb = mapb;
        this.HinhThucCV = HinhThucCV;
    }

    public String getMacv() {
        return macv;
    }
    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getMapb() {
        return mapb;
    }
    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public String getHinhThucCV() {
        return HinhThucCV;
    }
    public void setHinhThucCV(String HinhThucCV) {
        this.HinhThucCV = HinhThucCV;
    }
}
