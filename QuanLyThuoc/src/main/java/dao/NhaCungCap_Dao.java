package dao;

import java.rmi.Remote;
import java.util.List;

import entity.NhaCungCap;

public interface NhaCungCap_Dao extends Remote {

	List<NhaCungCap> readFromTable();

	boolean searchNCC(String maNCC);

	void deleteNCC(String maNCC);

	void addNCC(NhaCungCap ncc);

	NhaCungCap getNhaCungCap(String maNCC);

}
