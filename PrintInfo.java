package team02_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import team_02.PrintViewer;

@SuppressWarnings("serial")
public class PrintInfo extends JFrame{

	private JTextArea jta=new JTextArea();
	private JButton loadBtn=new JButton("Load");
	private JButton setBtn=new JButton("Set");
	private JButton viewBtn=new JButton("View");
	private JButton reportBtn=new JButton("Report");
	private JTextField jtfStart = new JTextField(15);
	private JTextField jtfEnd = new JTextField(15);
	private JLabel jlblPath = new JLabel("");
	
	
	public JTextField getJtfStart() {
		return jtfStart;
	}

	public JTextField getJtfEnd() {
		return jtfEnd;
	}

	public JLabel getJlblPath() {
		return jlblPath;
	}

	public static LoginFrame getLf() {
		return lf;
	}

	public JTextArea getJta() {
		return jta;
	}

	public JButton getLoadBtn() {
		return loadBtn;
	}

	public JButton getSetBtn() {
		return setBtn;
	}

	public JButton getViewBtn() {
		return viewBtn;
	}

	public JButton getReportBtn() {
		return reportBtn;
	}

	public LoginFrame getLv() {
		return lf;
	}


	private static LoginFrame lf;
	
	public PrintInfo(LoginFrame lf) {
        this.lf = lf;

        // 이미지 파일 경로 설정
        ImageIcon imageIcon;
		try {
			imageIcon = new ImageIcon(ImageIO.read(new File("img/mainHud_back.png")));
			Image image = imageIcon.getImage();
			// JLabel을 이용하여 이미지를 배경으로 설정
			setContentPane(new JLabel(new ImageIcon(image)));
		    
		} catch (IOException e) {
			e.printStackTrace();
		}

		//생성
		//JTextArea에 스크롤 추가
		JScrollPane jsp=new JScrollPane(jta);
		
		// selectFile 라벨 생성
		JLabel jlblPathName = new JLabel("Seleted File : ");

//		PrintViewer pv = new PrintViewer(this);
//		viewBtn.addActionListener(pv);
		
		JPanel rangePanel=new JPanel();
		JLabel jlblStart = new JLabel("Start Line : ");
		JLabel jlblEnd = new JLabel("End Line : ");
		
		// PrintInfoActionListener 설정
		PrintInfoActionListener pial = new PrintInfoActionListener(this);
		loadBtn.addActionListener(pial);
		viewBtn.addActionListener(pial);
		reportBtn.addActionListener(pial);
		setBtn.addActionListener(pial);
		
		//배치
		add(jsp);
		add(loadBtn);
		add(setBtn);
		add(viewBtn);
		add(reportBtn);
		add(rangePanel);
		add(jlblStart);
		add(jlblEnd);
		add(jtfStart);
		add(jtfEnd);
		add(jlblPath);
		add(jlblPathName);
		
		
		// viewBtn 설정
		viewBtn.setFont(new Font("Dialog", Font.ITALIC, 60));
		viewBtn.setForeground(new Color(0x7BE9FC));
	    viewBtn.setFocusPainted(false);
	    viewBtn.setContentAreaFilled(false);
	    
	    // reportBtn 설정
	    reportBtn.setFont(new Font("Dialog", Font.ITALIC, 60));
	    reportBtn.setForeground(new Color(0x7BE9FC));
	    reportBtn.setFocusPainted(false);
	    reportBtn.setContentAreaFilled(false);
	    
	    // setBtn 설정
	    setBtn.setFont(new Font("Dialog", Font.ITALIC, 40));
	    setBtn.setForeground(new Color(0x7BE9FC));
	    setBtn.setFocusPainted(false);
	    setBtn.setContentAreaFilled(false);
	    
	    // loadBtn 설정
	    loadBtn.setFont(new Font("Dialog", Font.ITALIC, 60));
	    loadBtn.setForeground(new Color(0x7BE9FC));
	    loadBtn.setFocusPainted(false);
	    loadBtn.setContentAreaFilled(false);
	    
	    
	    // jlblStart, jlblEnd 설정
	    jlblStart.setFont(new Font("Dialog", Font.ITALIC, 25));
	    jlblStart.setForeground(new Color(0x7BE9FC));

	    jlblEnd.setFont(new Font("Dialog", Font.ITALIC, 25));
	    jlblEnd.setForeground(new Color(0x7BE9FC));
	    
	    // jtfStart, jtfEnd 설정
	    jtfStart.setOpaque(false);
	    jtfStart.setForeground(new Color(0x7BE9FC));
	    jtfStart.setFont(new Font("Dialog", Font.ITALIC, 20));
	    Color borderColor = new Color(0x7BE9FC);
        int borderThickness = 2; // 테두리 두께 (픽셀 단위)
        jtfStart.setBorder(new LineBorder(borderColor, borderThickness));
	
	    jtfEnd.setOpaque(false);
	    jtfEnd.setForeground(new Color(0x7BE9FC));
	    jtfEnd.setFont(new Font("Dialog", Font.ITALIC, 20));
        jtfEnd.setBorder(new LineBorder(borderColor, borderThickness));
        
        // jlblPathName 설정
        jlblPathName.setFont(new Font("Dialog", Font.BOLD, 23));
        jlblPathName.setForeground(new Color(0xF3EC79));
        
        // jlblPath 설정
        jlblPath.setFont(new Font("Dialog", Font.ITALIC, 20));
        jlblPath.setForeground(new Color(0x00B602));
        
        
		jsp.setBorder(new TitledBorder("Print"));
		// Range Title 설정
		rangePanel.setBorder(new TitledBorder(new LineBorder(new Color(0x02959F),3),"Range"));
		TitledBorder RangeTitledBorder = (TitledBorder) rangePanel.getBorder();
		RangeTitledBorder.setTitleFont(new Font("Dialog", Font.ITALIC, 20)); // 원하는 폰트 크기로 변경 (30으로 설정)
		RangeTitledBorder.setTitleColor(new Color(0xF3EC79));
		
		
		
		//크기설정
		setLayout(null);
		reportBtn.setEnabled(!lf.getUndefinedId().contains(lf.getIdField().getText()));
		
		
		jta.setBackground(new Color(0x020303));
		jta.setFont(new Font("Dialog", Font.ITALIC, 20));
		jta.setForeground(Color.green);
		
		jsp.setBounds(120,80,1380,350);
		loadBtn.setBounds(1200,450,300,100);
		setBtn.setBounds(480,510,120,250);
		viewBtn.setBounds(800,580,300,200);
		reportBtn.setBounds(1200,580,300,200);
		jlblStart.setBounds(140,550,150,60);
		jlblEnd.setBounds(140,650,150,60);
		jtfStart.setBounds(270,550,180,60);
		jtfEnd.setBounds(270,650,180,60);
		jlblPathName.setBounds(640,470,150,60);
		jlblPath.setBounds(800,470,250,60);
		
		
		rangePanel.setBounds(120,480,500,300);
		
		
		jtfStart.setOpaque(false);
		jtfEnd.setOpaque(false);
		rangePanel.setOpaque(false);
		
		
		
		LineBorder lineBorder = new LineBorder(new Color(0x02959F), 3);

        // TitledBorder 객체 생성, 경계선 스타일과 색상을 설정한 LineBorder 전달
        TitledBorder titledBorder = new TitledBorder(lineBorder, "Log");

        // 제목의 색상 설정 (색상: 0xF3EC79)
        titledBorder.setTitleColor(new Color(0xF3EC79));
        Font titleFont = new Font("Dialog", Font.BOLD, 20);
        titledBorder.setTitleFont(titleFont);

        // JTextArea에 TitledBorder 적용
        jsp.setBorder(titledBorder);
		jsp.setBackground(new Color(0x02959F));
		
		setBtn.addActionListener(null);
		
		// 화면 중앙 설정
		setBounds(lf.getX(),lf.getY(),1600,900);
		
		//원도우 크기설정
//		setBounds(800,800,1600,900);
		setTitle("로그 정보");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}//PrintInfo
	
	public static void main(String[] args) {
       LoginFrame lf = new LoginFrame();
		new PrintInfo(lf);
	}//main


}//class
