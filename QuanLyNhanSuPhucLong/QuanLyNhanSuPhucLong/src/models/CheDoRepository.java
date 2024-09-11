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
public class CheDoRepository {
    private Statement cdStatement;

    public CheDoRepository() throws SQLException {
        this.cdStatement = ConnecttoSQLServer.getStatement();
    }
    
    // Lấy thông tin bảng chế độ trong csdl
    public CheDo[] CheDoArray(String search) throws SQLException {
        CheDo dscd[];
        String sql;
        ResultSet rs;
        int n, i;
        
        sql = "SELECT * FROM CHEDO";
        if(!search.equals("")){
            sql += " WHERE MaCD LIKE '%" + search + "%'";
        }
        rs = cdStatement.executeQuery(sql);
        rs.last();
        n = rs.getRow();
        
        dscd = new CheDo[n];
        rs.beforeFirst();
        i = 0;
        while(rs.next()){
            String macd, loaicd,baohiem;
            String tiencd;
            macd = rs.getString("MaCD");
            loaicd = rs.getString("LoaiCD");
            tiencd  = rs.getString("TienCD");
            baohiem =rs.getString("BaoHiem");
            dscd[i]=new CheDo(macd, loaicd, tiencd, baohiem);
            i++;
        }
        
        return dscd;
    }
    
       // thêm hình thức chế độ mới vào cơ sở dữ liệu

    public boolean addCheDo(CheDo cd) throws SQLException {
        String sql;
        int r;
        
        sql = "INSERT into CHEDO VALUES ('" + cd.getMacd()+ "', N'" + cd.getLoaicd()+ "', N'" + cd.getTiencd()+ "',N'" + cd.getBaoHiem()+ "')";
        r = this.cdStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     //  Sửa thông tin của một chế độ trong csdl
    public boolean editCheDo(CheDo cd) throws SQLException {
        String sql;
        int r;      
        sql = "UPDATE CHEDO SET LoaiCD = N'" + cd.getLoaicd()+ "', TienCD = N'" + cd.getTiencd()+ "', BaoHiem = N'" + cd.getBaoHiem()+ "' WHERE MaCD = '" + cd.getMacd()+ "'";
        r = this.cdStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     // Xóa một chế độ trong csdl

    public boolean deleteCheDo(String macd) throws SQLException {
        String sql;
        int r;
        sql = "DELETE FROM CHEDO WHERE MaCD = '" + macd + "'";
        
        r = this.cdStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    

     // Tìm chế độ (theo mã chế độ) trong csdl 

    public CheDo searchCheDo(String macd) throws SQLException {
        String sql;
        ResultSet rs;
        sql = "SELECT * FROM CHEDO WHERE MaCD = '" + macd + "'";
        
        rs = this.cdStatement.executeQuery(sql);
        rs.first();
        
        String loaicd,baohiem;
        String tiencd;
       
        macd=rs.getString("MaCD");
        loaicd=rs.getString("LoaiCD");
        tiencd = rs.getString("TienCD");
        baohiem=rs.getString("BaoHiem");
        
        
        return new CheDo(macd, loaicd, tiencd, baohiem);
    }
}
