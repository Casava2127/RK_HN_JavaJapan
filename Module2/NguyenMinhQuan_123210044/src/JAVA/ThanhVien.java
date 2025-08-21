package JAVA;

import java.sql.Date;

public class ThanhVien {
   private String MaThanhVien;
   private String TenThanhVien;
   private Date NgaySinh;
   private String DiaChi;
   private String SoDienThoai;
   
   public ThanhVien()
   {
	   
   }
   public ThanhVien(String MaThanhVien,String TenThanhVien,Date NgaySinh,  String DiaChi,String SoDienThoai)
   {
	   this.MaThanhVien=MaThanhVien;
	   this.TenThanhVien=TenThanhVien;
	   this.NgaySinh=NgaySinh;
	   this.DiaChi=DiaChi;
	   this.SoDienThoai=SoDienThoai;
   }
	public String getMaThanhVien() {
		return MaThanhVien;
	}
	public void setMaThanhVien(String maThanhVien) {
		MaThanhVien = maThanhVien;
	}
	public String getTenThanhVien() {
		return TenThanhVien;
	}
	public void setTenThanhVien(String tenThanhVien) {
		TenThanhVien = tenThanhVien;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
   
   
   
}
