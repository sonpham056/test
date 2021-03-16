package DAO;

import org.hibernate.Session;

import Entities.NhanVien;
import Entities.SinhVien;
import Utils.HibernateUtil;

public class NhanVienDAO {
	public static NhanVien layThongTin(String maNV) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		NhanVien nhanVien = null;
		try {
			nhanVien = (NhanVien) session.get(NhanVien.class, maNV);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return nhanVien;
	}
}
