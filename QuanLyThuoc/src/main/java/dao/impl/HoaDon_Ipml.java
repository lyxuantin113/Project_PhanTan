package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.HoaDon_Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class HoaDon_Ipml extends UnicastRemoteObject implements HoaDon_Dao{
	
	private static final long serialVersionUID = 9223372036854775807L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public HoaDon_Ipml() throws RemoteException{
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	
	
	
}
