package model;

import java.util.ArrayList;

public class PhongModel {
	private ArrayList<Phong> dsPhong;

	public PhongModel() {
		this.dsPhong = new ArrayList<Phong>();
	}

	public PhongModel(ArrayList<Phong> dsPhong) {
		this.dsPhong = dsPhong;
	}

	public ArrayList<Phong> getDsphong() {
		return dsPhong;
	}

	public void setDsphong(ArrayList<Phong> dsPhong) {
		this.dsPhong = dsPhong;
	}
	
	public void insert(Phong phong) {
		this.dsPhong.add(phong);
	}
	
	public void delete(Phong phong) {
		this.dsPhong.remove(phong);
	}
	
	public void update(Phong phong) {
		this.delete(phong);
		this.dsPhong.add(phong);
	}

	public boolean kiemTraTonTai(Phong phongToCheck) {
	    for (Phong phong : dsPhong) {
	        if (phong.getSoPhong() == phongToCheck.getSoPhong()) {
	            return true;
	        }
	    }
	    return false;
	}
    	
	public boolean kiemTraTonTaiSoPhong(int soPhong) {
	    for (Phong phong : dsPhong) {
	        if (phong.getSoPhong() == soPhong) {
	            return true;
	        }
	    }
	    return false;
	}
}
