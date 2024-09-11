/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class ChamCongRepository {
    private Statement chamcong;

    public ChamCongRepository() throws SQLException {
        this.chamcong = ConnecttoSQLServer.getStatement();
    }
    
    // Lấy thông tin bảng chấm công trong csdl
    public ChamCong[] ChamCongArray(String search) throws SQLException {
        ChamCong a[];
        String sql;
        ResultSet rs;
        int n, i;
        
        sql = "SELECT * FROM CHAMCONG";
        if(!search.equals("")){
            sql += " WHERE MaBCC LIKE '%" + search + "%'";
        }
        rs = chamcong.executeQuery(sql);
        rs.last();
        n = rs.getRow();
        
        a = new ChamCong[n];
        rs.beforeFirst();
        i = 0;
        while(rs.next()){
            String mabcc,manv,macd;
            String snlv,snp,snkp,giotangca;
            
            mabcc = rs.getString("MaBCC");
            manv = rs.getString("MaNV");
            macd = rs.getString("MaCD");
            snlv = rs.getString("SoNgayLamViec");
            snp = rs.getString("SoNgayPhep");
            snkp = rs.getString("SoNgayKhongPhep");
            giotangca=rs.getString("SoGioTangCa");
            a[i] = new ChamCong(mabcc, manv, macd, snlv, snp, snkp, giotangca);
            i++;
        }
        
        return a;
    }
    
       // thêm một bảng chấm công mới vào cơ sở dữ liệu

    public boolean addChamCong(ChamCong a) throws SQLException {
        String sql;
        int r;
        
        sql = "INSERT into CHAMCONG VALUES ('" + a.getMaBCC()+ "', N'" + a.getMaNV()+ "', N'" + a.getMaCD()+ "','" + a.getSnlv()+ "','" + a.getSnp() +"','"+a.getSnkp()+"','"+a.getGiotangca() + "')";
        r = this.chamcong.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     //  Sửa thông tin một bảng chấm công trong csdl
    public boolean editChamCong(ChamCong a) throws SQLException {
        String sql;
        int r; 
        sql = "UPDATE CHAMCONG SET MaNV = N'" + a.getMaNV()+ "', MaCD = N'" + a.getMaCD()+ "', SoNgayLamViec = '" + a.getSnlv() + "', SoNgayPhep = N'" + a.getSnp()+ "', SoNgayKhongPhep = '" + a.getSnkp()+"', SoGioTangCa = '" + a.getGiotangca()+ "' WHERE MaBCC = '" + a.getMaBCC()+ "'";
        r = this.chamcong.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     // Xóa một bảng chấm công trong csdl

    public boolean deleteChamCong(String mabcc) throws SQLException {
        String sql;
        int r;
        sql = "DELETE FROM ChamCong WHERE MaBCC = '" + mabcc + "'";
        
        r = this.chamcong.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    

     // Tìm bảng chấm công (theo mã bảng chấm công) trong csdl 

    public ChamCong searchBCC(String mabcc) throws SQLException {
        String sql;
        ResultSet rs;
        sql = "SELECT * FROM ChamCong WHERE MaBCC = '" + mabcc + "'";
        
        rs = this.chamcong.executeQuery(sql);
        rs.first();
        
        String manv,macd;
        String snlv,snp,snkp,giotangca;
        
        manv = rs.getString("MaNV");
        macd = rs.getString("MaCD");
        snlv = rs.getString("SoNgayLamViec");
        snp = rs.getString("SoNgayPhep");
        snkp = rs.getString("SoNgayKhongPhep");
        giotangca = rs.getString("SoGioTangCa");
        
        return new ChamCong(mabcc, manv, macd, snlv, snp, snkp, giotangca);
    }
}
