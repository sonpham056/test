package Entities;

import java.io.ObjectInputFilter.Status;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="NhanVien")
public class NhanVien {
	@Id
	private String maNV;
	private String tenNV;
	private String gioiTinh;
	private int namSinh;
	private long sdt;
	private int status;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public long getSdt() {
		return sdt;
	}
	public void setSdt(long sdt) {
		this.sdt = sdt;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
