package model;
import java.util.ArrayList;
public class QLKSModel {

	private ArrayList<KhachModel> dsKhachHang;
	private String luaChon;
	

	public QLKSModel() {
		this.dsKhachHang = new ArrayList<KhachModel>();
		this.luaChon = "";
	}

	public QLKSModel(ArrayList<KhachModel> dsKhachHang) {
		super();
		this.dsKhachHang = dsKhachHang;
	}

	public ArrayList<KhachModel> getDsKhachHang() {
		return dsKhachHang;
	}

	public void setDsKhachHang(ArrayList<KhachModel> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}

	public void insert(KhachModel khachHang) {
		this.dsKhachHang.add(khachHang);
	}
	public void delete(KhachModel khachHang) {
		this.dsKhachHang.remove(khachHang);
	}
	
	public void update(KhachModel khachHang) {
		this.delete(khachHang);
		this.dsKhachHang.add(khachHang);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
}


