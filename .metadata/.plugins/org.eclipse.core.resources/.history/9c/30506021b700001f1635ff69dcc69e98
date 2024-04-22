package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.NhaCungCap_Dao;
import entity.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class NhaCungCap_Impl extends UnicastRemoteObject implements NhaCungCap_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1645400163827782747L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public NhaCungCap_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<NhaCungCap> readFromTable() {
		return em.createNamedQuery("NhaCungCap.readFromTable", NhaCungCap.class).getResultList();
    }
	

}
