package gradle_study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gradle_study.ui.DepartmentUI;
import gradle_study.ui.TitleUi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_Ui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDepartment;
	private JButton btnTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Ui frame = new User_Ui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User_Ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("UserUi");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		Panel pbtn = new Panel();
		contentPane.add(pbtn, BorderLayout.SOUTH);
		
		btnDepartment = new JButton("부서");
		btnDepartment.addActionListener(this);
		pbtn.add(btnDepartment);
		
		btnTitle = new JButton("직책");
		btnTitle.addActionListener(this);
		pbtn.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTitle) {
			actionPerformedBtnTitle(e);
		}
		if (e.getSource() == btnDepartment) {
			actionPerformedBtnDepartment(e);
		}
	}
	
	protected void actionPerformedBtnDepartment(ActionEvent e) {	//부서버튼 활성화
		DepartmentUI frame = new DepartmentUI();
		frame.setVisible(true);
	}
	
	protected void actionPerformedBtnTitle(ActionEvent e) {			//직책버튼 활성화
		TitleUi frame = new TitleUi();
		frame.setVisible(true);
	}
}
