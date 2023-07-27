package team02_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class LoginFrame extends JFrame {
 
	private JButton loginBtn;
	
	private JTextField idField;
	private JPasswordField pwField;
	
	private JTextField field;
	
	private Set<String> undefinedId = new HashSet<String>();


	public JTextField getField() {
		return field;
	}

	public Set<String> getUndefinedId() {
		return undefinedId;
	}
	
	BufferedImage img = null;
	
//    JTextField loginTextField;
//    JPasswordField passwordField;
//    JButton bt;
 
    // 메인
 
    // 생성자
    public LoginFrame() {
        setTitle("로그인");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        // 레이아웃 설정
        setLayout(null);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1600, 900);
        layeredPane.setLayout(null);
 
        // 패널1
        // 이미지 받아오기
        try {
            img = ImageIO.read(new File("img/login.png"));
        } catch (IOException e) {
            System.out.println("이미지 불러오기 실패");
            System.exit(0);
        }
         
        MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 1600, 900);
         
 
        // 로그인 필드
        idField = new JTextField(15);
        idField.setBounds(731, 399, 280, 30);
        layeredPane.add(idField);
        idField.setOpaque(false);
        idField.setForeground(new Color(0x7BE9FC));
        idField.setFont(new Font("Dialog", Font.ITALIC, 20));
        idField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        // 패스워드
        pwField = new JPasswordField(15);
        pwField.setBounds(731, 529, 280, 30);
        pwField.setOpaque(false);
        pwField.setForeground(new Color(0x7BE9FC));
        pwField.setFont(new Font("Dialog", Font.ITALIC, 20));
        pwField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        layeredPane.add(pwField);
 
        // 로그인버튼 추가
        loginBtn = new JButton(new ImageIcon("img/btLogin_hud.png"));
        loginBtn.setBounds(755, 689, 104, 48);
 
        // 버튼 투명처리
        loginBtn.setBorderPainted(false);
        loginBtn.setFocusPainted(false);
        loginBtn.setContentAreaFilled(false);
 
        layeredPane.add(loginBtn);
        
        LoginCheck2 lc =new LoginCheck2(this);
		idField.addActionListener(lc);
		pwField.addActionListener(lc);
		loginBtn.addActionListener(lc);
		
		// 화면 중앙 출력
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
 
        // 마지막 추가들
        layeredPane.add(panel);
        add(layeredPane);
        setVisible(true);
    }
 
    class MyPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }
    
    public JButton getLoginBtn() {
		return loginBtn;
	}

	public JTextField getIdField() {
		return idField;
	}

	public JPasswordField getPwField() {
		return pwField;
	}

	public BufferedImage getImg() {
		return img;
	}

	public static void main(String[] args) {
    	new LoginFrame();
    }
 
}
