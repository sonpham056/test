package DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Entities.SinhVien;
import Utils.HibernateUtil;

public class SinhVienDAO {
	public static SinhVien layThongTinSinhVien(String mssv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		SinhVien sinhVien = null;
		try {
			sinhVien = (SinhVien) session.get(SinhVien.class, mssv);
			session.close();
			return sinhVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sinhVien;
	}
	
	public static List<SinhVien> layThongTinSinhVienLaNam() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<SinhVien> sinhViens = null;
		try {
			String string = "from sinhvien sv where sv.gioiTinh = 'nam'";
			Query query = session.createQuery(string);
			sinhViens = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return sinhViens;
	}
}
