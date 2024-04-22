package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.PhieuNhapThuoc_Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class PhieuNhapThuoc_Impl extends UnicastRemoteObject implements PhieuNhapThuoc_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8720430331537767941L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public PhieuNhapThuoc_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

}