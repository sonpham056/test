package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;

import DAO.NhanVienDAO;
import DAO.SinhVienDAO;
import Entities.NhanVien;
import Entities.SinhVien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class Main implements ActionListener{

	private JFrame frame;
	private JTextField txtOTren;
	private JLabel lblNewLabel_1;
	private JTextField txtODuoi;
	private JTextArea textArea;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 929, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(110, 70, 122, 42);
		frame.getContentPane().add(lblNewLabel);
		
		txtOTren = new JTextField();
		txtOTren.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtOTren.setBounds(267, 70, 314, 42);
		frame.getContentPane().add(txtOTren);
		txtOTren.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new BtnClickedClass());
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(419, 276, 162, 53);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(110, 177, 122, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtODuoi = new JTextField();
		txtODuoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtODuoi.setColumns(10);
		txtODuoi.setBounds(267, 177, 314, 42);
		frame.getContentPane().add(txtODuoi);
		
		JButton btn2 = new JButton("New button");
		btn2.setMnemonic('n');
		btn2.addActionListener(new Btn2ClickedClass());
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn2.setBounds(247, 276, 162, 53);
		frame.getContentPane().add(btn2);
		
		textArea = new JTextArea();
		textArea.setBounds(60, 366, 606, 150);
		frame.getContentPane().add(textArea);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTestClicked();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(603, 276, 162, 53);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	private void btnClicked() {
		txtODuoi.setText(txtOTren.getText());
	}

	public void actionPerformed(ActionEvent e) {
		txtODuoi.setText(txtOTren.getText());
	}
	
	private class BtnClickedClass implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			txtODuoi.setText(txtOTren.getText());
		}
		
	}
	
	private class Btn2ClickedClass implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, textArea.getText());
			String[] strings = textArea.getText().split("\n");
			for (int i = strings.length - 1; i >= 0; i--) {
				//JOptionPane.showMessageDialog(null, strings[i]);
				try {
					//JOptionPane.showMessageDialog(null, textArea.getLineStartOffset(i) + " " + textArea.getLineEndOffset(i));
					//JOptionPane.showMessageDialog(null, textArea.getText(textArea.getLineStartOffset(i), textArea.getLineEndOffset(i) - textArea.getLineStartOffset(i)));
					String string = textArea.getText(textArea.getLineStartOffset(i), textArea.getLineEndOffset(i) - textArea.getLineStartOffset(i));
					if (string.compareTo("123\r\n") == 0 || string.compareTo("123\n") == 0)
						textArea.replaceRange("", textArea.getLineStartOffset(i), textArea.getLineEndOffset(i));
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	private void btnTestClicked() {
		//List<SinhVien> sinhVien = SinhVienDAO.layThongTinSinhVienLaNam();
		//if (sinhVien == null)
		//	JOptionPane.showMessageDialog(null, "Khong tim thay");
		//else {
			/*for(int i = 0; i < sinhVien.size(); i++) {
				String string = sinhVien.get(i).getMaSinhVien() + " " + sinhVien.get(i).getHoVaTen() + " " + sinhVien.get(i).getGioiTinh() + "\n";
				textArea.append(string);
			}*/
			NhanVien nhanVien = NhanVienDAO.layThongTin(txtOTren.getText());
			textArea.append(nhanVien.getMaNV() + " " + nhanVien.getTenNV());
			
		//}
	}
}
