package model;

import java.util.Objects;

public class DichVu {
	private String maDichVu;
	private String tenLoaiDichVu;
	private String tenDichVu;
	private float donGia;
	
	public DichVu() {
	}

	public DichVu(String maDichVu, String tenLoaiDichVu, String tenDichVu, float donGia) {
		this.maDichVu = maDichVu;
		this.tenLoaiDichVu = tenLoaiDichVu;
		this.tenDichVu = tenDichVu;
		this.donGia = donGia;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getTenLoaiDichVu() {
		return tenLoaiDichVu;
	}

	public void setTenLoaiDichVu(String tenLoaiDichVu) {
		this.tenLoaiDichVu = tenLoaiDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenLoaiDichVu=" + tenLoaiDichVu + ", tenDichVu=" + tenDichVu
				+ ", donGia=" + donGia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(donGia, maDichVu, tenDichVu, tenLoaiDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Float.floatToIntBits(donGia) == Float.floatToIntBits(other.donGia)
				&& Objects.equals(maDichVu, other.maDichVu) && Objects.equals(tenDichVu, other.tenDichVu)
				&& Objects.equals(tenLoaiDichVu, other.tenLoaiDichVu);
	}
	
	
}
