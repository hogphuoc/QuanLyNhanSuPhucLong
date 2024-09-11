/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ADMIN
 */
public class CheDo {
    private String macd;
    private String loaicd;
    private String tiencd;
    private String BaoHiem;

    public CheDo(String macd, String loaicd, String tiencd, String Baohiem) {
        this.macd = macd;
        this.loaicd = loaicd;
        this.tiencd = tiencd;
        this.BaoHiem=Baohiem;
    }





    public String getMacd() {
        return macd;
    }

    public void setMacd(String macd) {
        this.macd = macd;
    }

    public String getLoaicd() {
        return loaicd;
    }

    public void setLoaicd(String loaicd) {
        this.loaicd = loaicd;
    }

    public String getTiencd() {
        return tiencd;
    }

    public void setTiencd(String tiencd) {
        this.tiencd = tiencd;
    }

    public String getBaoHiem() {
        return BaoHiem;
    }

    public void setBaoHiem(String BaoHiem) {
        this.BaoHiem = BaoHiem;
    }
    
    
}
