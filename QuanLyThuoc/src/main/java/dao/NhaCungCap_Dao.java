package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhaCungCap;

public interface NhaCungCap_Dao extends Remote{

	List<NhaCungCap> readFromTable() throws RemoteException;

	boolean searchNCC(String maNCC) throws RemoteException;

	void deleteNCC(String maNCC) throws RemoteException;

	void addNCC(NhaCungCap ncc) throws RemoteException;

	NhaCungCap getNhaCungCap(String maNCC) throws RemoteException;

}
