package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.NhanVien_Dao;
import dao.TaiKhoan_Dao;
import entity.NhanVien;
import rmi.RMIClient;

public class TimNhanVien_Gui extends JPanel implements ActionListener {
	private JButton bntXoaRong;
	private JButton bntTim;
	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien;
	public TimNhanVien_Gui() throws RemoteException {
//				JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//				HEADER
		JPanel pnHead = new JPanel();
		JLabel lbHead = new JLabel("Tìm nhân viên");
		Font fo24 = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		lbHead.setFont(fo24);
		lbHead.setForeground(Color.blue);
		pnHead.add(lbHead);

//				CENTER

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		Box containerBox = Box.createVerticalBox();

		Box boxMa = Box.createHorizontalBox();
		Box boxChucVu = Box.createHorizontalBox();

		Box boxTableNhanVien = Box.createVerticalBox();
		String[] headerNhanVien = "Mã NV;Tên NV;Sđt NV;Chức vụ;Email".split(";");
		modelNhanVien = new DefaultTableModel(headerNhanVien, 0);
		tableNhanVien = new JTable(modelNhanVien);
		JScrollPane scrollNhanVien = new JScrollPane();
		scrollNhanVien.setViewportView(tableNhanVien = new JTable(modelNhanVien));
		scrollNhanVien.setPreferredSize(new Dimension(700, 330)); // SET CHIỀU CAO TABLE
		tableNhanVien.setRowHeight(20);

		boxTableNhanVien.add(scrollNhanVien);
		boxTableNhanVien.add(Box.createVerticalStrut(10));

		pnCenter.add(boxTableNhanVien);

//				FOOTER		
		JPanel pnFoot = new JPanel();

		Box boxC1 = Box.createHorizontalBox();
		boxC1.add(bntTim = new JButton("Tim"));
		boxC1.add(Box.createHorizontalStrut(10));
		JTextField tfTim = new JTextField();
		boxC1.add(Box.createHorizontalStrut(10));
		boxC1.add(bntXoaRong = new JButton("Xoa Rong"));
		pnFoot.add(boxC1);

		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnFoot, BorderLayout.SOUTH);

		add(pnMain);

		bntTim.addActionListener(this);
		bntXoaRong.addActionListener(this);

		hienTable();
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(bntTim)) {
			timAction();
		}
		if (o.equals(bntXoaRong)) {
			tableNhanVien.clearSelection(); 
		}

	}
	private void hienTable() throws RemoteException {
		modelNhanVien.setRowCount(0);
		NhanVien_Dao dsNV = RMIClient.lookup("NhanVien_Dao", NhanVien_Dao.class);
		for (NhanVien n : dsNV.docTuBang()) {
			String[] dataRow = { n.getMaNhanVien(), n.getTenNhanVien(), n.getSoDienThoai(), n.getChucVu(), n.getEmail() };
			modelNhanVien.addRow(dataRow);
		}
	}
	private void timAction() {
		String searchName = JOptionPane.showInputDialog(this, "Nhập tên nhân viên cần tìm kiếm:");

		if (searchName == null || searchName.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhân viên .");
			return;
		}
		for (int i = 0; i < tableNhanVien.getRowCount(); i++) {
			String ten = (String) tableNhanVien.getValueAt(i, 1);

			if (ten.equalsIgnoreCase(searchName)) {
				tableNhanVien.setRowSelectionInterval(i, i);
				tableNhanVien.scrollRectToVisible(tableNhanVien.getCellRect(i, 1, true));
				return;
			}
		}

		JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên: " + searchName);

	}
}
