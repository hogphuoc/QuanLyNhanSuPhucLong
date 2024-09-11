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
public class CongViecRepository {
    private Statement cvStatement;

    public CongViecRepository() throws SQLException {
        this.cvStatement = ConnecttoSQLServer.getStatement();
    }
    
    // Lấy thông tin bảng công việc trong csdl
    public CongViec[] CongViecArray(String search) throws SQLException {
        CongViec dscv[];
        String sql;
        ResultSet rs;
        int n, i;
        
        sql = "SELECT * FROM CONGVIEC";
        if(!search.equals("")){
            sql += " WHERE MaCV LIKE '%" + search + "%'";
        }
        rs = cvStatement.executeQuery(sql);
        rs.last();
        n = rs.getRow();
        
        dscv = new CongViec[n];
        rs.beforeFirst();
        i = 0;
        while(rs.next()){
            String macv, mapb, hinhthuccv;
            
            macv = rs.getString("MaCV");
            mapb = rs.getString("MaPB");
            hinhthuccv = rs.getString("HinhThucCV");
            
            dscv[i]=new CongViec(macv, mapb, hinhthuccv);
            i++;
        }
        
        return dscv;
    }
    
       // thêm hình thức công việc mới vào cơ sở dữ liệu

    public boolean addCongViec(CongViec cv) throws SQLException {
        String sql;
        int r;
        
        sql = "INSERT into CONGVIEC VALUES ('" + cv.getMacv()+ "', N'" + cv.getMapb()+ "', N'" + cv.getHinhThucCV()+ "')";
        r = this.cvStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     //  Sửa thông tin của một công việc trong csdl
    public boolean editCongviec(CongViec cv) throws SQLException {
        String sql;
        int r;      
        sql = "UPDATE CONGVIEC SET MaPB = N'" + cv.getMapb()+ "', HinhThucCV = N'" + cv.getHinhThucCV()+ "' WHERE MaCV = '" + cv.getMacv()+ "'";
        r = this.cvStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     // Xóa một nhân viên trong csdl

    public boolean deleteCongViec(String macv) throws SQLException {
        String sql;
        int r;
        sql = "DELETE FROM CONGVIEC WHERE MaCV = '" + macv + "'";
        
        r = this.cvStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    

     // Tìm công việc (theo mã công việc) trong csdl 

    public CongViec searchCongViec(String macv) throws SQLException {
        String sql;
        ResultSet rs;
        sql = "SELECT * FROM CONGVIEC WHERE MaCV = '" + macv + "'";
        
        rs = this.cvStatement.executeQuery(sql);
        rs.first();
        
        String mapb,HinhThucCV;
        
        mapb = rs.getString("MaPB");
        HinhThucCV=rs.getString("HinhThucCV");
        
        return new CongViec(macv, mapb, HinhThucCV);
    }
}
