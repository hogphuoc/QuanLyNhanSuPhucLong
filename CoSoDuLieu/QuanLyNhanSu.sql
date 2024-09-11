﻿CREATE DATABASE QuanLyNhanSu
GO
USE QuanLyNhanSu
GO
CREATE TABLE dbo.PHONGBAN
(
  MaPB  CHAR(4) PRIMARY KEY,
  TenPB NVARCHAR(100) NULL,
  SDTPhong CHAR(10),
)
GO
CREATE TABLE dbo.NHANVIEN
(
  MaNV CHAR(4) PRIMARY KEY,
  HoTen NVARCHAR(100),
  GioiTinh NVARCHAR(3) NULL,
  DiaChi NVARCHAR(200) NULL,
  Sdt CHAR(10) NULL,
  NgaySinh DATE NULL,
  MaPB CHAR(4) NULL CONSTRAINT FK_PB_NV FOREIGN KEY REFERENCES PHONGBAN(MaPB),
)
GO
CREATE TABLE dbo.CONGVIEC
(
  MaCV CHAR (4) PRIMARY KEY,
  MaPB CHAR(4) CONSTRAINT FK_PB_CV FOREIGN KEY REFERENCES PHONGBAN(MaPB),
  HinhThucCV NVARCHAR(100),
)
GO
CREATE TABLE dbo.CHUCVU
(
  MaCVu CHAR (5) PRIMARY KEY,
  TenCvu NVARCHAR (100),
  MaCV CHAR (4) CONSTRAINT FK_MCV_CVU FOREIGN KEY REFERENCES CONGVIEC(MaCV),
)
GO
CREATE TABLE dbo.HOSO
(
  MaHS CHAR(4) PRIMARY KEY,
  MaNV CHAR(4) CONSTRAINT FK_MNV_HS FOREIGN KEY REFERENCES NHANVIEN(MaNV),
  TrinhDo NVARCHAR(50) NULL,
  GiayKhamSucKhoe NVARCHAR(10) NULL,
  GiayKhaiSinh NVARCHAR(10) NULL,
)
GO
CREATE TABLE dbo.CHEDO
(
  MaCD char(4) PRIMARY KEY,
  LoaiCD NVARCHAR(50),
  TienCD int,
  BaoHiem NVARCHAR(50),
)
GO
CREATE TABLE dbo.CHAMCONG
(
  MaBCC CHAR(4) PRIMARY KEY,
  MaNV CHAR(4) CONSTRAINT FK_NV_CG FOREIGN KEY REFERENCES NHANVIEN(MaNV),
  MaCD CHAR(4) CONSTRAINT FK_CD_CG FOREIGN KEY REFERENCES CHEDO(MaCD),
  SoNgayLamViec int,
  SoNgayPhep int,
  SoNgayKhongPhep int,
  SoGioTangCa int,
)
GO
-- công chuẩn mỗi tháng sẽ là 29 ngày
-- số giờ tăng ca ko quá 30
GO
CREATE TABLE dbo.LUONG
(
  PhieuLuong CHAR(6) PRIMARY KEY,
  MaNV CHAR(4) CONSTRAINT FK_MNV_LG FOREIGN KEY REFERENCES NHANVIEN(MaNV),
  MABCC CHAR(4)  CONSTRAINT FK_BCC_LG FOREIGN KEY REFERENCES CHAMCONG(MaBCC),
  LuongCB int,
  PhuCap int,
  Thue float,
)
GO
CREATE TABLE TaiKhoan
(
	TenDangNhap varchar(50) not null,
	MatKhau varchar(50) not null
)


INSERT INTO PHONGBAN VALUES ('PB00',N'Giám đốc','0001112525'),
							('PB01',N'Phó giám đốc','0001212211'),
							('PB02',N'Kế toán','0009993211'),
							('PB03',N'Nhân Sự','0006544566'),
							('PB04',N'Marketing','0009633258'),
							('PB05',N'Vận Hành Kiosk','0002121457'),
							('PB06',N'Vận hành Flagship','0003699633'),
							('PB07',N'Thiết Kế','0003221523'),
							('PB08',N'Bếp','0002221189'),
							('PB09',N'Kho','0002143366')
GO
INSERT into NHANVIEN VALUES ('NV00',N'Nguyễn Văn Hoàng',N'Nam',N'TP Hồ Chí Minh','0912345678','1971-01-12','PB01'),
							('NV01',N'Hoàng Huy',N'Nam',N'Đồng Nai','0514236987','1998-12-05','PB06'),
							('NV02',N'Nguyễn Mai Anh',N'Nữ',N'Bình Dương','0541236255','1980-05-05','PB05'),
							('NV03',N'Lê Cẩm Vân',N'Nữ',N'TP Hồ Chí Minh','0478954123','1983-10-21','PB00'),
							('NV04',N'Nguyễn Thủy Tiên',N'Nữ',N'TP Hồ Chí Minh','0214532699','1999-10-21','PB03'),
							('NV05',N'Lê Mạnh Hải','Nam',N'TP Hồ Chí Minh','0215433261','2001-11-04','PB04'),
							('NV06',N'Ngô Bắc Tuấn','Nam',N'Long An','0995641247','1981-05-02','PB05'),
							('NV07',N'Nguyễn Trọng Tuyển','Nam',N'TP Hồ Chí Minh','0215478963','1979-06-07','PB06'),
							('NV08',N'Huỳnh Hoàng Thảo',N'Nữ',N'TP Hồ Chí Minh','0932652214','1969-08-18','PB07'),
							('NV09',N'Hoàng Tôn',N'Nam',N'Bình Định','0247896542','1980-02-29','PB08'),
							('NV10',N'Lê Duy',N'Nam',N'Quảng Ngãi','0999653555','1995-12-25','PB09'),
							('NV11',N'Văn Lâm Hoàng',N'Nam',N'Bình Dương','0214572366','1994-07-14','PB02'),
							('NV12',N'Ngô Thảo Anh',N'Nữ',N'TP Hồ Chí Minh','0321589336','1983-09-10','PB03'),
							('NV13',N'Hoàng Hiền',N'Nữ',N'Đồng Nai','0218954732','1996-06-04','PB04'),
							('NV14',N'Nguyễn Văn Kiên',N'Nam',N'TP Hồ Chí Minh','0963699658','2000-01-11','PB05'),
							('NV15',N'Nguyễn Trọng Nhân',N'Nam',N'TP Hồ Chí Minh','0467862223','1992-10-19','PB05'),
				            ('NV16',N'Phan Anh Đào',N'Nữ',N'Hà Nội','0789567345','2001-05-30','PB06'),
							('NV17',N'Hồ Tuấn Nam',N'Nam',N'Bình Định','0178999387','1976-11-04','PB04'),
							('NV18',N'Lê Quỳnh Trúc',N'Nữ',N'Quảng Nam','0898567343','2000-01-01','PB09'),
							('NV19',N'Phạm Thủy Tiên',N'Nữ',N'Kon Tum','0876009234','1988-02-26','PB06'),
							('NV20',N'Trần Gia Bảo',N'Nam',N'Đồng Nai','0909159514','1995-09-17','PB03')
GO
INSERT INTO CONGVIEC VALUES('CV00','PB00',N'Full Time')
INSERT INTO CONGVIEC VALUES('CV01','PB01',N'Full Time')
INSERT INTO CONGVIEC VALUES('CV02','PB02',N'Full Time')
INSERT INTO CONGVIEC VALUES('CV03','PB03',N'Full Time')
INSERT INTO CONGVIEC VALUES('CV04','PB04',N'Full Time')
INSERT INTO CONGVIEC VALUES('CV05','PB05',N'Part Time')
INSERT INTO CONGVIEC VALUES('CV06','PB06',N'Part Time')
INSERT INTO CONGVIEC VALUES('CV07','PB07',N'Full Time')
INSERT INTO CONGVIEC VALUES('CV08','PB08',N'Full Time')
INSERT INTO CONGVIEC VALUES('CV09','PB09',N'Part Time')
GO
INSERT INTO CHUCVU VALUES ('CVU01',N'Trưởng phòng kế toán','CV02')
INSERT INTO CHUCVU VALUES ('CVU02',N'Tổng giám đốc','CV00')
INSERT INTO CHUCVU VALUES ('CVU03',N'Giám sát ca Flagship','CV06')
INSERT INTO CHUCVU VALUES ('CVU04',N'Quản lý kiosk','CV05')
INSERT INTO CHUCVU VALUES ('CVU05',N'Phó tổng giám đốc','CV01')
INSERT INTO CHUCVU VALUES ('CVU06',N'Trưởng phòng nhân sự','CV03')
INSERT INTO CHUCVU VALUES ('CVU07',N'Quản lý kho','CV09')
INSERT INTO CHUCVU VALUES ('CVU08',N'UX/UI Designer','CV07')
INSERT INTO CHUCVU VALUES ('CVU09',N'Nhân viên phát triển sản phẩm','CV04')
INSERT INTO CHUCVU VALUES ('CVU10',N'Nhân viên bếp bánh','CV08')
GO
INSERT INTO HOSO VALUES('HS00','NV00',N'Đại học',N'Có',N'Có')
INSERT INTO HOSO VALUES('HS01','NV01',N'Đại học',N'Không',N'Có')
INSERT INTO HOSO VALUES('HS02','NV02',N'Trung cấp',N'Có',N'Có')
INSERT INTO HOSO VALUES('HS03','NV03',N'Đại học',N'Có',N'Có')
INSERT INTO HOSO VALUES('HS04','NV04',N'Đại học',N'Có',N'Không')
INSERT INTO HOSO VALUES('HS05','NV05',N'Cao đẳng',N'Không',N'Không')
INSERT INTO HOSO VALUES('HS06','NV06',N'Đại học',N'Có',N'Có')
INSERT INTO HOSO VALUES('HS07','NV07',N'Đại học',N'Có',N'Không')
INSERT INTO HOSO VALUES('HS08','NV08',N'Cao đẳng',N'Có',N'Có')
INSERT INTO HOSO VALUES('HS09','NV09',N'Đại học',N'Không',N'Có')
INSERT INTO HOSO VALUES('HS10','NV10',N'Đại học',N'Có',N'Có')
INSERT INTO HOSO VALUES('HS11','NV11',N'Cao đẳng',N'Không',N'Không')
INSERT INTO HOSO VALUES('HS12','NV12',N'Đại học',N'Có',N'Có')
INSERT INTO HOSO VALUES('HS13','NV13',N'Đại học',N'Có',N'Có')
INSERT INTO HOSO VALUES('HS14','NV14',N'Trung học',N'Không',N'Có')
INSERT INTO HOSO VALUES('HS15','NV15',N'Trung cấp',N'Có',N'Không')
INSERT INTO HOSO VALUES('HS16','NV16',N'Cao đẳng',N'Không',N'Có')
INSERT INTO HOSO VALUES('HS17','NV17',N'Đại học',N'Có',N'Không')
INSERT INTO HOSO VALUES('HS18','NV18',N'Đại học',N'Có',N'Có')
INSERT INTO HOSO VALUES('HS19','NV19',N'Đại học',N'Không',N'Có')
INSERT INTO HOSO VALUES('HS20','NV20',N'Trung cấp',N'Có',N'Không')
GO
INSERT INTO CHEDO VALUES('CD00',N'Thưởng chuyên cần',400000,N'Có')
INSERT INTO CHEDO VALUES('CD01',N'Thưởng KPIs',300000,N'Có')
INSERT INTO CHEDO VALUES('CD02',N'Thưởng dự án mới',1000000,N'Không')
INSERT INTO CHEDO VALUES('CD03',N'Phạt đi trễ',100000,N'Không')
INSERT INTO CHEDO VALUES('CD04',N'Phạt quên chấm công',50000,N'Không')
GO
INSERT INTO CHAMCONG VALUES('CC00','NV00','CD00',28,1,0,20)
INSERT INTO CHAMCONG VALUES('CC01','NV01','CD01',29,0,0,25)
INSERT INTO CHAMCONG VALUES('CC02','NV02','CD04',28,0,1,22)
INSERT INTO CHAMCONG VALUES('CC03','NV03','CD02',27,1,1,15)
INSERT INTO CHAMCONG VALUES('CC04','NV04','CD04',27,2,0,28)
INSERT INTO CHAMCONG VALUES('CC05','NV05','CD03',28,0,1,10)
INSERT INTO CHAMCONG VALUES('CC06','NV06','CD00',29,0,0,19)
INSERT INTO CHAMCONG VALUES('CC07','NV07','CD03',25,3,1,19)
INSERT INTO CHAMCONG VALUES('CC08','NV08','CD04',25,2,2,20)
INSERT INTO CHAMCONG VALUES('CC09','NV09','CD02',26,3,0,18)
INSERT INTO CHAMCONG VALUES('CC10','NV10','CD01',28,0,1,27)
INSERT INTO CHAMCONG VALUES('CC11','NV11','CD01',28,1,0,10)
INSERT INTO CHAMCONG VALUES('CC12','NV12','CD01',25,4,0,16)
INSERT INTO CHAMCONG VALUES('CC13','NV13','CD04',26,2,1,28)
INSERT INTO CHAMCONG VALUES('CC14','NV14','CD00',27,2,0,20)
INSERT INTO CHAMCONG VALUES('CC15','NV15','CD02',28,0,1,20)
INSERT INTO CHAMCONG VALUES('CC16','NV16','CD02',27,1,1,24)
INSERT INTO CHAMCONG VALUES('CC17','NV17','CD01',26,0,0,30)
INSERT INTO CHAMCONG VALUES('CC18','NV18','CD03',26,0,3,12)
INSERT INTO CHAMCONG VALUES('CC19','NV19','CD03',25,3,1,15)
INSERT INTO CHAMCONG VALUES('CC20','NV20','CD01',25,2,2,18)
GO
INSERT INTO LUONG VALUES('LG00','NV00','CC00',50000000,2000000,0.05)
INSERT INTO LUONG VALUES('LG01','NV01','CC01',9000000,800000,0.04)
INSERT INTO LUONG VALUES('LG02','NV02','CC02',10000000,800000,0.04)
INSERT INTO LUONG VALUES('LG03','NV03','CC03',40000000,1500000,0.05)
INSERT INTO LUONG VALUES('LG04','NV04','CC04',12000000,1000000,0.04)
INSERT INTO LUONG VALUES('LG05','NV05','CC05',18000000,1000000,0.04)
INSERT INTO LUONG VALUES('LG06','NV06','CC06',4600000,500000,0.04)
INSERT INTO LUONG VALUES('LG07','NV07','CC07',6000000,500000,0.04)
INSERT INTO LUONG VALUES('LG08','NV08','CC08',20000000,1000000,0.04)
INSERT INTO LUONG VALUES('LG09','NV09','CC09',9500000,500000,0.04)
INSERT INTO LUONG VALUES('LG10','NV10','CC10',11000000,800000,0.04)
INSERT INTO LUONG VALUES('LG11','NV11','CC11',15000000,1000000,0.04)
INSERT INTO LUONG VALUES('LG12','NV12','CC12',22000000,1000000,0.04)
INSERT INTO LUONG VALUES('LG13','NV13','CC13',11000000,800000,0.04)
INSERT INTO LUONG VALUES('LG14','NV14','CC14',4600000,500000,0.04)
INSERT INTO LUONG VALUES('LG15','NV15','CC15',9000000,800000,0.04)
INSERT INTO LUONG VALUES('LG16','NV16','CC16',8000000,800000,0.04)
INSERT INTO LUONG VALUES('LG17','NV17','CC17',14000000,1000000,0.04)
INSERT INTO LUONG VALUES('LG18','NV18','CC18',10500000,800000,0.04)
INSERT INTO LUONG VALUES('LG19','NV19','CC19',5200000,500000,0.04)
INSERT INTO LUONG VALUES('LG20','NV20','CC20',11800000,1000000,0.04)
