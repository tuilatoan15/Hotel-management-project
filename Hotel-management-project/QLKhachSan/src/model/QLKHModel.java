package model;

import java.util.ArrayList;

public class QLKHModel {
	private ArrayList<Khach> dsKhach;
	private String luaChon;

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public QLKHModel() {
		this.dsKhach = new ArrayList<Khach>();
	}

	public QLKHModel(ArrayList<Khach> dsKhach) {
		this.dsKhach = dsKhach;
	}

	public ArrayList<Khach> getDsKhach() {
		return dsKhach;
	}

	public void setDsKhach(ArrayList<Khach> dsKhach) {
		this.dsKhach = dsKhach;
	}
	
	public void insert(Khach Khach) {
		this.dsKhach.add(Khach);
	}
	
	public void delete(Khach Khach) {
		this.dsKhach.remove(Khach);
	}
	
	public void update(Khach Khach) {
		this.delete(Khach);
		this.dsKhach.add(Khach);
	}

	public boolean kiemTraTonTai(Khach dv) {
	    for (Khach Khach : dsKhach) {
	        if (Khach.getMaKhach().equals(dv.getMaKhach())) {
	            return true;
	        }
	    }
	    return false;
	}

	public boolean kiemTraTonTaiMaKhach(String maKhach) {
	    for (Khach dv : dsKhach) {
	        if (dv.getMaKhach().equals(maKhach)) {
	            return true;
	        }
	    }
	    return false;
	}

}
