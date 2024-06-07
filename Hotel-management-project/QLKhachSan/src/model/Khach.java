package model;

import java.util.Objects;

public class Khach {
	private String MaKhach;
	private String HoTen;
	private int Tuoi;
	private boolean GioiTinh;
	private String SDT;
	private String CCCD;
	
	public Khach() {
	}

	public Khach(String maKhach, String hoTen, int tuoi, boolean gioiTinh, String sDT, String cCCD) {
		super();
		MaKhach = maKhach;
		HoTen = hoTen;
		Tuoi = tuoi;
		GioiTinh = gioiTinh;
		SDT = sDT;
		CCCD = cCCD;
	}



	public String getMaKhach() {
		return MaKhach;
	}

	public void setMaKhach(String maKhach) {
		MaKhach = maKhach;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public int getTuoi() {
		return Tuoi;
	}

	public void setTuoi(int tuoi) {
		Tuoi = tuoi;
	}

	public boolean isGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	@Override
	public String toString() {
		return "Khach [MaKhach=" + MaKhach + ", HoTen=" + HoTen + ", Tuoi=" + Tuoi + ", SDT=" + SDT + ", CCCD=" + CCCD
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CCCD, HoTen, MaKhach, SDT, Tuoi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Khach other = (Khach) obj;
		return Objects.equals(CCCD, other.CCCD) && Objects.equals(HoTen, other.HoTen)
				&& Objects.equals(MaKhach, other.MaKhach) && Objects.equals(SDT, other.SDT) && Tuoi == other.Tuoi;
	}
	
}
