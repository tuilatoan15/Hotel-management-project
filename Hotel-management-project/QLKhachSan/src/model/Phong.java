package model;

import java.sql.Timestamp;
import java.util.Objects;

public class Phong {
    private int SoPhong;
    private String TenPhong;
    private float Gia;
    private int TrangThai;

    public Phong() {}
    
    public Phong(int soPhong, String tenPhong, float gia) {
		SoPhong = soPhong;
		TenPhong = tenPhong;
		Gia = gia;
	}

	public Phong(int soPhong, String tenPhong, float gia, int trangThai) {
        this.SoPhong = soPhong;
        this.TenPhong = tenPhong;
        this.Gia = gia;
        this.TrangThai = trangThai;
    }

    public int getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(int soPhong) {
        SoPhong = soPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String tenPhong) {
        TenPhong = tenPhong;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float gia) {
        Gia = gia;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Phong [SoPhong=" + SoPhong + ", TenPhong=" + TenPhong + ", Gia=" + Gia
                + ", TrangThai=" + TrangThai + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(Gia, SoPhong, TenPhong, TrangThai);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Phong other = (Phong) obj;
        return Float.floatToIntBits(Gia) == Float.floatToIntBits(other.Gia)
                && SoPhong == other.SoPhong && Objects.equals(TenPhong, other.TenPhong) && TrangThai == other.TrangThai;
    }
}
