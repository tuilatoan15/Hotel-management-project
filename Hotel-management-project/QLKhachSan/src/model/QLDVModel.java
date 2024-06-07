package model;

import java.util.ArrayList;

public class QLDVModel {
	private ArrayList<DichVu> dsDichVu;
	private String luaChon;

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public QLDVModel() {
		this.dsDichVu = new ArrayList<DichVu>();
	}

	public QLDVModel(ArrayList<DichVu> dsDichVu) {
		this.dsDichVu = dsDichVu;
	}

	public ArrayList<DichVu> getDsDichVu() {
		return dsDichVu;
	}

	public void setDsDichVu(ArrayList<DichVu> dsDichVu) {
		this.dsDichVu = dsDichVu;
	}
	
	public void insert(DichVu dichVu) {
		this.dsDichVu.add(dichVu);
	}
	
	public void delete(DichVu dichVu) {
		this.dsDichVu.remove(dichVu);
	}
	
	public void update(DichVu dichVu) {
		this.delete(dichVu);
		this.dsDichVu.add(dichVu);
	}

	public boolean kiemTraTonTai(DichVu dv) {
	    for (DichVu dichVu : dsDichVu) {
	        if (dichVu.getMaDichVu().equals(dv.getMaDichVu())) {
	            return true;
	        }
	    }
	    return false;
	}

	public boolean kiemTraTonTaiMaDichVu(String maDichVu) {
	    for (DichVu dv : dsDichVu) {
	        if (dv.getMaDichVu().equals(maDichVu)) {
	            return true;
	        }
	    }
	    return false;
	}

}
