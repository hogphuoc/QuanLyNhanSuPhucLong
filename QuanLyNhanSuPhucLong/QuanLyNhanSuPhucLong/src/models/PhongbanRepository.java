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
public class PhongbanRepository {
    private Statement pbStatement;

    public PhongbanRepository() throws SQLException {
        this.pbStatement = ConnecttoSQLServer.getStatement();
    }
    // Lấy
    public Phongban[] phongbanarray(String search) throws SQLException {
        Phongban dspb[];
        String sql;
        ResultSet rs;
        int n, i;
        
        sql = "SELECT * FROM PHONGBAN";
        if(!search.equals("")){
            sql += " WHERE MaPB LIKE '%" + search + "%' OR TenPB LIKE N'%" + search + "%'";
        }
        rs = pbStatement.executeQuery(sql);
        rs.last();
        n = rs.getRow();
        
        dspb = new Phongban[n];
        
        rs.beforeFirst();
        i = 0;
        while(rs.next()){
            String mapb, tenpb, sdtphong;
            
            mapb = rs.getString("MaPB");
            tenpb = rs.getString("TenPB");
            sdtphong = rs.getString("SDTPhong");
            
            dspb[i] = new Phongban(mapb, tenpb, sdtphong);
            i++;
        }       
        return dspb;
    }
    // Thêm
    public boolean addPhong(Phongban pb) throws SQLException {
        String sql;
        int r;      
        sql = "INSERT INTO PHONGBAN VALUES ('" + pb.getMapb()+ "', N'" + pb.getTenpb()+ "', '" + pb.getSodtpb()+ "')";
        r = this.pbStatement.executeUpdate(sql);
        System.out.println(sql);
        if(r > 0)
            return true;
        return false;
    }
    // Sửa
    public boolean editphong(Phongban pb) throws SQLException {
        String sql;
        int r;
        
        sql = "UPDATE PHONGBAN SET TenPB = N'" + pb.getTenpb()+ "', SDTPhong = '" + pb.getSodtpb()+ "' WHERE MaPB = '" + pb.getMapb()+ "'";
        r = this.pbStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    // xóa
    public boolean deletePhong(String mapb) throws SQLException {
        String sql;
        int r;
        
        sql = "DELETE FROM PHONGBAN WHERE MaPB = '" + mapb + "'";
        r = this.pbStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    // Tìm
    public Phongban searchPhong(String mapb) throws SQLException {
        String sql;
        ResultSet rs;
        sql = "SELECT * FROM PHONGBAN WHERE MaPB = '" + mapb + "'";
        
        rs = this.pbStatement.executeQuery(sql);
        rs.first();
        
        String tenpb, sdtpb;

        tenpb = rs.getString("TenPB");
        sdtpb = rs.getString("SDTPhong");
         
        
        return new Phongban(mapb, tenpb, sdtpb);
    }
}
