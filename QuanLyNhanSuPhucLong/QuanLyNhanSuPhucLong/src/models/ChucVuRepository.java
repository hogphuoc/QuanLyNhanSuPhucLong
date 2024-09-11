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
public class ChucVuRepository {
    private Statement cvuStatement;

    public ChucVuRepository() throws SQLException {
        this.cvuStatement = ConnecttoSQLServer.getStatement();
    }
    
    // Lấy thông tin bảng chức vụ trong csdl
    public ChucVu[] ChucVuArray(String search) throws SQLException {
        ChucVu dscvu[];
        String sql;
        ResultSet rs;
        int n, i;
        
        sql = "SELECT * FROM CHUCVU";
        if(!search.equals("")){
            sql += " WHERE MaCVu LIKE '%" + search + "%'";
        }
        rs = cvuStatement.executeQuery(sql);
        rs.last();
        n = rs.getRow();
        
        dscvu = new ChucVu[n];
        rs.beforeFirst();
        i = 0;
        while(rs.next()){
            String macvu, tencvu, macv;
            
            macvu = rs.getString("MaCVu");
            tencvu = rs.getString("TenCvu");
            macv  = rs.getString("MaCV");
            
            dscvu[i]=new ChucVu(macvu, tencvu, macv);
            i++;
        }
        
        return dscvu;
    }
    
       // thêm hình thức chức vụ mới vào cơ sở dữ liệu

    public boolean addChucVu(ChucVu cvu) throws SQLException {
        String sql;
        int r;
        
        sql = "INSERT into CHUCVU VALUES ('" + cvu.getMachucvu()+ "', N'" + cvu.getTenchucvu()+ "', N'" + cvu.getMacv()+ "')";
        r = this.cvuStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     //  Sửa thông tin của một chức vụ trong csdl
    public boolean editChucVu(ChucVu cvu) throws SQLException {
        String sql;
        int r;      
        sql = "UPDATE CHUCVU SET TenCVu = N'" + cvu.getTenchucvu()+ "', MaCV = N'" + cvu.getMacv()+ "' WHERE MaCVu = '" + cvu.getMachucvu()+ "'";
        r = this.cvuStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     // Xóa một chức vụ trong csdl

    public boolean deleteChucVu(String macvu) throws SQLException {
        String sql;
        int r;
        sql = "DELETE FROM CHUCVU WHERE MaCVu = '" + macvu + "'";
        
        r = this.cvuStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    

     // Tìm chức vụ (theo mã chức vụ) trong csdl 

    public ChucVu searchChucVu(String macvu) throws SQLException {
        String sql;
        ResultSet rs;
        sql = "SELECT * FROM CONGVIEC WHERE MaCVu = '" + macvu + "'";
        
        rs = this.cvuStatement.executeQuery(sql);
        rs.first();
        
        String tencvu,macv;
        tencvu=rs.getString("TenCVu");
        macv = rs.getString("MaCV");
        
        
        return new ChucVu(macvu, tencvu, macv);
    }
}
