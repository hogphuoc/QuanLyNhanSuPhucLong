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
public class HoSoRepository {
    private Statement hsStatement;

    public HoSoRepository() throws SQLException {
        this.hsStatement = ConnecttoSQLServer.getStatement();
    }
    
    // Lấy thông tin nhân viên trong csdl
    public HoSo[] HoSoArray(String search) throws SQLException {
        HoSo dshs[];
        String sql;
        ResultSet rs;
        int n, i;
        
        sql = "SELECT * FROM HOSO";
        if(!search.equals("")){
            sql += " WHERE MaHS LIKE '%" + search + "%'";
        }
        rs = hsStatement.executeQuery(sql);
        rs.last();
        n = rs.getRow();
        
        dshs = new HoSo[n];
        rs.beforeFirst();
        i = 0;
        while(rs.next()){
            String mahs, manv, trinhdo, giayksk,giaykhaisinh;
            
            mahs = rs.getString("MaHS");
            manv = rs.getString("MaNV");
            trinhdo = rs.getString("TrinhDo");
            giayksk = rs.getString("GiayKhamSucKhoe");
            giaykhaisinh = rs.getString("GiayKhaiSinh");
            
            dshs[i] = new HoSo(mahs, manv, trinhdo, giaykhaisinh, giaykhaisinh);
            i++;
        }       
        return dshs;
    }
    
       // thêm hồ sơ mới vào cơ sở dữ liệu

    public boolean addHoSo(HoSo hs) throws SQLException {
        String sql;
        int r;
        
        sql = "INSERT into HOSO VALUES ('" + hs.getMahs()+  "', N'" + hs.getManv()+ "', N'" + hs.getTrinhDo()+ "', '" + hs.getGiayKhamSucKhoe() +"', '" + hs.getGiayKhaiSinh()+ "')";
        r = this.hsStatement.executeUpdate(sql);
        if(r > 0)
        {
             return true;
        }          
        return false;
    }
    
     //  Sửa thông tin của một nhân viên trong csdl
    public boolean editHoSo(HoSo hs) throws SQLException {
        String sql;
        int r;    
        sql = "UPDATE HOSO SET MaNV = N'" + hs.getManv()+ "', TrinhDo = N'" + hs.getTrinhDo()+ "', GiayKhamSucKhoe = N'" + hs.getGiayKhamSucKhoe()+ "', GiayKhaiSinh = '" + hs.getGiayKhaiSinh()+ "' WHERE MaHS = '" + hs.getMahs()+ "'";
        r = this.hsStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     // Xóa dữ liệu hồ sơ trong csdl

    public boolean deleteHoSo(String mahs) throws SQLException {
        String sql;
        int r;
        sql = "DELETE FROM HOSO WHERE MaHS = '" + mahs + "'";
        
        r = this.hsStatement.executeUpdate(sql);
        if(r > 0)
        {
            return true;           
        }

        return false;
    }
    
     // Tìm một hồ sơ (theo mã hồ sơ) trong csdl 

    public HoSo searchHoSo(String mahs) throws SQLException {
        String sql;
        ResultSet rs;
        sql = "SELECT * FROM HOSO WHERE MaHS = '" + mahs + "'";
        
        rs = this.hsStatement.executeQuery(sql);
        rs.first();
        
        String manv, trinhdo, giaykhamsuckhoe, giaykhaisinh;
        
        manv = rs.getString("MaNV");
        trinhdo = rs.getString("TrinhDo");
        giaykhamsuckhoe = rs.getString("GiayKhamSucKhoe");      
        giaykhaisinh = rs.getString("GiayKhaiSinh");
        
        return new HoSo(mahs, manv, trinhdo, giaykhamsuckhoe, giaykhaisinh);
    }
}
