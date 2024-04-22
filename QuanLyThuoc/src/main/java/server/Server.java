package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.DonDat_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.impl.DonDat_Impl;
import dao.impl.HoaDon_Ipml;
import dao.impl.KhachHang_Impl;

public class Server {
	private static final String URL = "rmi://AcerAspire7:30011/";

	public static void main(String[] args) throws Exception {
		Context context = new InitialContext();
		
		KhachHang_Dao courseDao = new KhachHang_Impl();  //Java Remote Object
		HoaDon_Dao studentDao = new HoaDon_Ipml();  //Java Remote Object
		DonDat_Dao departmentDao = new DonDat_Impl();//Java Remote Object
		
		LocateRegistry.createRegistry(7878);
		
		context.bind(URL +"courseDao", courseDao);
		context.bind(URL +"studentDao", studentDao);
		context.bind(URL +"departmentDao", departmentDao);
		
		System.out.println("Server is running...");
	}
}
