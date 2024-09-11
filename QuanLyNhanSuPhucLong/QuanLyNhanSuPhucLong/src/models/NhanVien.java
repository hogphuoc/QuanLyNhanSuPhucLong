/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private String manv;
    private String hoten;
    private String gioitinh;
    private String diachi;
    private String sodt;
    private Date ngaysinh;
    private String mapb;

    // Phương thức khởi tạo giá trị ban đầu

    public NhanVien(String manv, String hoten, String gioitinh, String diachi, String sodt, Date ngaysinh, String mapb) {
        this.manv = manv;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sodt = sodt;
        this.ngaysinh = ngaysinh;
        this.mapb = mapb;
    }


    public String getManv() {
        return manv;
    }
    public void setManv(String manv) {
    this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }
    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public String getSodt() {
        return sodt;
    }
    public void setSodt(String sodt) {
        this.sodt = sodt;
    }
    public Date getNgaysinh() {
        return ngaysinh;
    }
    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    public String getMapb() {
        return mapb;
    }
    public void setMapb(String mapb) {
        this.mapb = mapb;
    }   

    
}
