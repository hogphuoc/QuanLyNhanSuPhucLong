/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepository {
    private Statement nvStatement;

    public NhanVienRepository() throws SQLException {
        this.nvStatement = ConnecttoSQLServer.getStatement();
    }
    
    // Lấy thông tin nhân viên trong csdl
    public NhanVien[] NhanVienArray(String search) throws SQLException {
        NhanVien dsnv[];
        String sql;
        ResultSet rs;
        int n, i;
        
        sql = "SELECT * FROM NHANVIEN";
        if(!search.equals("")){
            sql += " WHERE MaNV LIKE '%" + search + "%' OR Hoten LIKE N'%" + search + "%'";
        }
        rs = nvStatement.executeQuery(sql);
        rs.last();
        n = rs.getRow();
        
        dsnv = new NhanVien[n];
        rs.beforeFirst();
        i = 0;
        while(rs.next()){
            String manv, hoten, gioitinh, diachi, sdt, mapb;
            Date ngaysinh;
            
            manv = rs.getString("MaNV");
            hoten = rs.getString("HoTen");
            gioitinh = rs.getString("GioiTinh");
            diachi = rs.getString("DiaChi");
            sdt = rs.getString("Sdt");
            ngaysinh = rs.getDate("NgaySinh");           
            mapb = rs.getString("MaPB");
            
            dsnv[i] = new NhanVien(manv, hoten, gioitinh, diachi, sdt, ngaysinh, mapb);
            i++;
        }
        
        return dsnv;
    }
    
       // thêm một nhân viên mới vào cơ sở dữ liệu

    public boolean addNhanVien(NhanVien nv) throws SQLException {
        String sql;
        int r;
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        sql = "INSERT into NHANVIEN VALUES ('" + nv.getManv()+ "', N'" + nv.getHoten()+ "', N'" + nv.getGioitinh()+ "', N'" + nv.getDiachi()+ "', '" + nv.getSodt() +"', '" + formater.format(nv.getNgaysinh()) + "', '" + nv.getMapb()+ "')";
        r = this.nvStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     //  Sửa thông tin của một nhân viên trong csdl
    public boolean editNhanVien(NhanVien nv) throws SQLException {
        String sql;
        int r;
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        sql = "UPDATE NHANVIEN SET HoTen = N'" + nv.getHoten()+ "', GioiTinh = N'" + nv.getGioitinh()+ "', DiaChi = N'" + nv.getDiachi()+ "', Sdt = N'" + nv.getSodt()+"',NgaySinh = N'" +formater.format(nv.getNgaysinh()) + "', MaPB = '" + nv.getMapb()+ "' WHERE MaNV = '" + nv.getManv()+ "'";
        r = this.nvStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    
     // Xóa một nhân viên trong csdl

    public boolean deleteNhanVien(String manv) throws SQLException {
        String sql;
        int r;
        sql = "DELETE FROM NHANVIEN WHERE MaNV like '%" + manv + "%'";
        
        r = this.nvStatement.executeUpdate(sql);
        if(r > 0)
            return true;
        return false;
    }
    

     // Tìm một nhân viên (theo mã nhân viên) trong csdl 

    public NhanVien searchNhanVien(String manv) throws SQLException {
       /* String sql;
        ResultSet rs;
        sql = "SELECT * FROM SinhVien WHERE MaNV = '" + manv + "'";
        
        rs = this.nvStatement.executeQuery(sql);
        rs.first();
        
        String hotennv, gioitinh, diachi, dienthoai, mapb;
        String ngaysinh;
        
        hotennv = rs.getString("HoTen");
        gioitinh = rs.getString("GioiTinh");        
        diachi = rs.getString("DiaChi");
        dienthoai = rs.getString("Sdt");
        ngaysinh = rs.getString("NgaySinh");
        mapb = rs.getString("MaPB");
        return new NhanVien(manv, hotennv, gioitinh, diachi, ngaysinh, dienthoai, mapb);
        */return null;
       /* String sql;
        ResultSet rs;
        sql = "SELECT * FROM SinhVien WHERE MaNV = '" + manv + "'";
        
        rs = this.nvStatement.executeQuery(sql);
        rs.first();
        
        String hotennv, gioitinh, diachi, dienthoai, mapb;
        String ngaysinh;
        
        hotennv = rs.getString("HoTen");
        gioitinh = rs.getString("GioiTinh");        
        diachi = rs.getString("DiaChi");
        dienthoai = rs.getString("Sdt");
        ngaysinh = rs.getString("NgaySinh");
        mapb = rs.getString("MaPB");
        return new NhanVien(manv, hotennv, gioitinh, diachi, ngaysinh, dienthoai, mapb);
        */
      
    }
}
