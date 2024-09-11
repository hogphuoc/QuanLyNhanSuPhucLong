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
public class LuongRepository {
    private Statement l;

    public LuongRepository() throws SQLException {
        this.l = ConnecttoSQLServer.getStatement();
    }
    
    // Lấy thông tin bảng lương trong csdl
    public Luong[] LuongnArray(String search) throws SQLException {
        Luong dsl[];
        String sql;
        ResultSet rs;
        int n, i;
        
        sql = "SELECT * FROM LUONG";
        if(!search.equals("")){
            sql += " WHERE PhieuLuong LIKE '%" + search + "%'";
        }
        rs = l.executeQuery(sql);
        rs.last();
        n = rs.getRow();
        
        dsl = new Luong[n];
        rs.beforeFirst();
        i = 0;
        while(rs.next()){
            String phieuluong, manv, mabcc;
            String luongcb, phucap,thue;
            phieuluong = rs.getString("PhieuLuong");
            manv = rs.getString("MaNV");
            mabcc = rs.getString("MaBCC");
            luongcb = rs.getString("LuongCB");
            phucap = rs.getString("PhuCap");
            thue = rs.getString("Thue");
            
            dsl[i] = new Luong(phieuluong, manv, mabcc, luongcb, phucap, thue);
            i++;
        }
        
        return dsl;
    }
    
       // thêm một phiếu lương mới vào cơ sở dữ liệu

    public boolean addLuong(Luong l) throws SQLException {
        String sql;
        int r;
        
        sql = "INSERT into LUONG VALUES ('" + l.getPhieuLuong()+ "', N'" + l.getMaNV()+ "', N'" + l.getMaBCC()+ "', '" + l.getLuongcb() + "', '" + l.getPhucap()+"', '" + l.getThue()+ "')";
        r = this.l.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     //  Sửa thông tin của một nhân viên trong csdl
    public boolean editLuong(Luong l) throws SQLException {
        String sql;
        int r;      
        sql = "UPDATE LUONG SET MaNV = N'" + l.getMaNV()+ "', MaBCC = N'" + l.getMaBCC()+ "', LuongCB = '" + l.getLuongcb() + "', PhuCap = N'" + l.getPhucap()+ "', Thue = '" + l.getThue()+ "' WHERE PhieuLuong = '" + l.getPhieuLuong()+ "'";
        r = this.l.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     // Xóa một phiếu lương trong csdl

    public boolean deleteLuong(String phieuluong) throws SQLException {
        String sql;
        int r;
        sql = "DELETE FROM LUONG WHERE PhieuLuong = '" + phieuluong + "'";
        
        r = this.l.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    

     // Tìm một phiếu lương (theo mã phiếu) trong csdl 

    public Luong searchLuong(String phieuluong) throws SQLException {
        String sql;
        ResultSet rs;
        sql = "SELECT * FROM LUONG WHERE PhieuLuong = '" + phieuluong + "'";
        
        rs = this.l.executeQuery(sql);
        rs.first();
        
        String manv,mabcc;
        String luongcb,phucap,thue;
        
        manv = rs.getString("MaNV");
        mabcc = rs.getString("MaBCC");
        luongcb=rs.getString("LuongCB");
        phucap=rs.getString("PhuCap");
        thue=rs.getString("Thue");
        
        return new Luong(phieuluong, manv, mabcc, luongcb, phucap, thue);
    }
}
