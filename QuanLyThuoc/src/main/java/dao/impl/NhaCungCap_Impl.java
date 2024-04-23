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

	@Override
	public boolean searchNCC(String maNCC) {
	    List<NhaCungCap> result = em.createNamedQuery("NhaCungCap.searchNCC", NhaCungCap.class)
	                                .setParameter("maNCC", maNCC)
	                                .getResultList();
	    return !result.isEmpty();
	}

	@Override
	public void deleteNCC(String maNCC) {
	    em.getTransaction().begin();
	    em.createNamedQuery("NhaCungCap.deleteNCC")
	      .setParameter("maNCC", maNCC)
	      .executeUpdate();
	    em.getTransaction().commit();
	}

	@Override
	public void addNCC(NhaCungCap ncc) {
		em.getTransaction().begin();
		em.persist(ncc);
		em.getTransaction().commit();
		
	}

	@Override
	public NhaCungCap getNhaCungCap(String maNCC) {
		return em.createNamedQuery("NhaCungCap.getNCC", NhaCungCap.class).setParameter("maNCC", maNCC).getSingleResult();
	}
	

}
