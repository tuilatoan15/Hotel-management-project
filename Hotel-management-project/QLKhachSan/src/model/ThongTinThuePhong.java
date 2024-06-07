package model;

import java.util.Objects;

public class ThongTinThuePhong {
	private String maKhach;
    private String hoTen;
    private String phong;
    private int giaPhong;
    private float tongTienPhong;
    private float tongTienDichVu;
    private float tongBuill;
    
    public ThongTinThuePhong() {
	}

	public ThongTinThuePhong(String maKhach, String hoTen, String phong, int giaPhong, float tongTienPhong,
			float tongTienDichVu, float tongBuill) {
		super();
		this.maKhach = maKhach;
		this.hoTen = hoTen;
		this.phong = phong;
		this.giaPhong = giaPhong;
		this.tongTienPhong = tongTienPhong;
		this.tongTienDichVu = tongTienDichVu;
		this.tongBuill = tongBuill;
	}

	public String getMaKhach() {
		return maKhach;
	}

	public void setMaKhach(String maKhach) {
		this.maKhach = maKhach;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getPhong() {
		return phong;
	}

	public void setPhong(String phong) {
		this.phong = phong;
	}

	public int getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(int giaPhong) {
		this.giaPhong = giaPhong;
	}

	public float getTongTienPhong() {
		return tongTienPhong;
	}

	public void setTongTienPhong(float tongTienPhong) {
		this.tongTienPhong = tongTienPhong;
	}

	public float getTongTienDichVu() {
		return tongTienDichVu;
	}

	public void setTongTienDichVu(float tongTienDichVu) {
		this.tongTienDichVu = tongTienDichVu;
	}

	public float getTongBuill() {
		return tongBuill;
	}

	public void setTongBuill(float tongBuill) {
		this.tongBuill = tongBuill;
	}

	@Override
	public String toString() {
		return "ThongTinThuePhong [maKhach=" + maKhach + ", hoTen=" + hoTen + ", phong=" + phong + ", giaPhong="
				+ giaPhong + ", tongTienPhong=" + tongTienPhong + ", tongTienDichVu=" + tongTienDichVu + ", tongBuill="
				+ tongBuill + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaPhong, hoTen, maKhach, phong, tongBuill, tongTienDichVu, tongTienPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThongTinThuePhong other = (ThongTinThuePhong) obj;
		return giaPhong == other.giaPhong && Objects.equals(hoTen, other.hoTen)
				&& Objects.equals(maKhach, other.maKhach) && Objects.equals(phong, other.phong)
				&& Float.floatToIntBits(tongBuill) == Float.floatToIntBits(other.tongBuill)
				&& Float.floatToIntBits(tongTienDichVu) == Float.floatToIntBits(other.tongTienDichVu)
				&& Float.floatToIntBits(tongTienPhong) == Float.floatToIntBits(other.tongTienPhong);
	}
}
