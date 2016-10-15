package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.ChatManager;
import main.change;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField ip;
	private JLabel fail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ip = new JTextField();
		ip.setText("119.29.175.89");
		ip.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(KeyEvent.VK_ENTER==e.getKeyCode()){
					ChatManager.getCM().connect(ip.getText());
					if(change.geti()==0){
						dispose();
						MainWindow frame = new MainWindow();
						frame.setVisible(true);
						ChatManager.getCM().setWindow(frame);
						}else{
							fail.setText("连接失败");
						}
				}
			}
		});
		ip.setBounds(17, 50, 213, 34);
		contentPane.add(ip);
		ip.setColumns(10);
		
		JButton button = new JButton("连接");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatManager.getCM().connect(ip.getText());
					dispose();
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					ChatManager.getCM().setWindow(frame);
			}
		});
		button.setBounds(238, 54, 69, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("关闭");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(306, 54, 69, 29);
		contentPane.add(button_1);
		
		JLabel lblip = new JLabel("请输入要连接的IP地址");
		lblip.setBounds(134, 22, 140, 16);
		contentPane.add(lblip);
		
		fail = new JLabel("");
		fail.setForeground(Color.RED);
		fail.setBounds(158, 96, 61, 16);
		contentPane.add(fail);
	}
}
