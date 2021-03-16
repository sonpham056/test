package Entities;

import javax.persistence.Entity; //annotation
import javax.persistence.Id;

@Entity(name="sinhvien")
public class SinhVien {
	@Id
	private String maSinhVien;
	private String hoVaTen;
	private String gioiTinh;
	private String cmnd;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	
	public SinhVien() {}
	
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
	
}
