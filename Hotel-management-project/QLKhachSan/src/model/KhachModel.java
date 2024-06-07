package model;

import java.util.Date;

public class KhachModel {
	private String tenThiSing;
	private String tuoi;
	private boolean gioiTinh;
	private String STD;
	private String CCCD;
	private Date ngayDat;
	private Date ngayTra;
	private int soNguoi;
	private int datCoc;

	
	public KhachModel() {
	}


	public KhachModel(String tenThiSing, String tuoi, boolean gioiTinh, String sTD, String cCCD, Date ngayDat,
			Date ngayTra, int soNguoi, int datCoc) {
		this.tenThiSing = tenThiSing;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		STD = sTD;
		CCCD = cCCD;
		this.ngayDat = ngayDat;
		this.ngayTra = ngayTra;
		this.soNguoi = soNguoi;
		this.datCoc = datCoc;
	}


	public String getTenThiSing() {
		return tenThiSing;
	}


	public void setTenThiSing(String tenThiSing) {
		this.tenThiSing = tenThiSing;
	}


	public String getTuoi() {
		return tuoi;
	}


	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}


	public boolean isGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getSTD() {
		return STD;
	}


	public void setSTD(String sTD) {
		STD = sTD;
	}


	public String getCCCD() {
		return CCCD;
	}


	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}


	public Date getNgayDat() {
		return ngayDat;
	}


	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}


	public Date getNgayTra() {
		return ngayTra;
	}


	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}


	public int getSoNguoi() {
		return soNguoi;
	}


	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}


	public int getDatCoc() {
		return datCoc;
	}


	public void setDatCoc(int datCoc) {
		this.datCoc = datCoc;
	}


	@Override
	public String toString() {
		return "KhachModel [tenThiSing=" + tenThiSing + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", STD=" + STD
				+ ", CCCD=" + CCCD + ", ngayDat=" + ngayDat + ", ngayTra=" + ngayTra + ", soNguoi=" + soNguoi
				+ ", datCoc=" + datCoc + "]";
	}
}