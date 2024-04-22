package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.ChiTietPhieuNhapThuoc_Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ChiTietPhieuNhapThuoc_Impl extends UnicastRemoteObject implements ChiTietPhieuNhapThuoc_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2195088738328711745L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public ChiTietPhieuNhapThuoc_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

}
