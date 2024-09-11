/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
/**
 *
 * @author ADMIN
 */
public class Luong {
    private String PhieuLuong;
    private String MaNV;
    private String MaBCC;
    private String luongcb;
    private String phucap;
    private String thue;

    public Luong(String PhieuLuong, String MaNV, String MaBCC, String luongcb, String phucap, String thue) {
        this.PhieuLuong = PhieuLuong;
        this.MaNV = MaNV;
        this.MaBCC = MaBCC;
        this.luongcb = luongcb;
        this.phucap = phucap;
        this.thue = thue;
    }

    public String getPhieuLuong() {
        return PhieuLuong;
    }

    public void setPhieuLuong(String PhieuLuong) {
        this.PhieuLuong = PhieuLuong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaBCC() {
        return MaBCC;
    }

    public void setMaBCC(String MaBCC) {
        this.MaBCC = MaBCC;
    }

    public String getLuongcb() {
        return luongcb;
    }

    public void setLuongcb(String luongcb) {
        this.luongcb = luongcb;
    }

    public String getPhucap() {
        return phucap;
    }

    public void setPhucap(String phucap) {
        this.phucap = phucap;
    }

    public String getThue() {
        return thue;
    }

    public void setThue(String thue) {
        this.thue = thue;
    }
    
    
}
