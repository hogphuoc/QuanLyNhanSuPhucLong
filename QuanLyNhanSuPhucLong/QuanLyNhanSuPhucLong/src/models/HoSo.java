/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ADMIN
 */
public class HoSo {
    private String mahs ;
    private String manv;
    private String TrinhDo; 
    private String GiayKhamSucKhoe;
    private String GiayKhaiSinh;

    public HoSo(String mahs, String manv, String TrinhDo, String GiayKhamSucKhoe, String GiayKhaiSinh) {
        this.mahs = mahs;
        this.manv = manv;
        this.TrinhDo = TrinhDo;
        this.GiayKhamSucKhoe = GiayKhamSucKhoe;
        this.GiayKhaiSinh = GiayKhaiSinh;
    }

    public String getMahs() {
        return mahs;
    }
    public void setMahs(String mahs) {
        this.mahs = mahs;
    }

    public String getManv() {
        return manv;
    }
    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTrinhDo() {
        return TrinhDo;
    }
    public void setTrinhDo(String TrinhDo) {
        this.TrinhDo = TrinhDo;
    }

    public String getGiayKhamSucKhoe() {
        return GiayKhamSucKhoe;
    }
    public void setGiayKhamSucKhoe(String GiayKhamSucKhoe) {
        this.GiayKhamSucKhoe = GiayKhamSucKhoe;
    }

    public String getGiayKhaiSinh() {
        return GiayKhaiSinh;
    }
    public void setGiayKhaiSinh(String GiayKhaiSinh) {
        this.GiayKhaiSinh = GiayKhaiSinh;
    } 
}
