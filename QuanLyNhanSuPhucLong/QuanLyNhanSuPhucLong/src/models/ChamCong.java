/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ADMIN
 */
public class ChamCong {
    private String MaBCC;
    private String MaNV;
    private String MaCD;
    private String snlv;
    private String snp;
    private String snkp;
    private String giotangca;

    public ChamCong(String MaBCC, String MaNV, String MaCD, String snlv, String snp, String snkp, String giotangca) {
        this.MaBCC = MaBCC;
        this.MaNV = MaNV;
        this.MaCD = MaCD;
        this.snlv = snlv;
        this.snp = snp;
        this.snkp = snkp;
        this.giotangca = giotangca;
    }

    public String getMaBCC() {
        return MaBCC;
    }

    public void setMaBCC(String MaBCC) {
        this.MaBCC = MaBCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaCD() {
        return MaCD;
    }

    public void setMaCD(String MaCD) {
        this.MaCD = MaCD;
    }

    public String getSnlv() {
        return snlv;
    }

    public void setSnlv(String snlv) {
        this.snlv = snlv;
    }

    public String getSnp() {
        return snp;
    }

    public void setSnp(String snp) {
        this.snp = snp;
    }

    public String getSnkp() {
        return snkp;
    }

    public void setSnkp(String snkp) {
        this.snkp = snkp;
    }

    public String getGiotangca() {
        return giotangca;
    }

    public void setGiotangca(String giotangca) {
        this.giotangca = giotangca;
    }
    
}
