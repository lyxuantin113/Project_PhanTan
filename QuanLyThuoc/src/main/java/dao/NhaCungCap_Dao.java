package dao;

import java.util.List;

import entity.NhaCungCap;

public interface NhaCungCap_Dao {

	List<NhaCungCap> readFromTable();

	boolean searchNCC(String maNCC);

	void deleteNCC(String maNCC);

	void addNCC(NhaCungCap ncc);

	NhaCungCap getNhaCungCap(String maNCC);

}
