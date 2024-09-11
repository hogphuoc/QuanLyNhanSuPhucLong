/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


/**
 *
 * @author ADMIN
 */
public class Phongban {
    private String mapb;
    private String tenpb;
    private String sodtpb;

    public Phongban(String mapb, String tenpb, String sodtpb) {
        this.mapb = mapb;
        this.tenpb = tenpb;
        this.sodtpb = sodtpb;
    }

    public String getMapb() {
        return mapb;
    }
    public void setMapb(String mapb) {
        this.mapb = mapb;
    }
    public String getTenpb() {
        return tenpb;
    }
    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }
    public String getSodtpb() {
        return sodtpb;
    }
    public void setSodtpb(String sodtpb) {
        this.sodtpb = sodtpb;
    }  
}
