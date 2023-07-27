package team02_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class LoginCheck2 implements ActionListener {
	
//	private logViewer login;
	private LoginFrame login;
	private Map<String, String> loginInfo;
	private PrintInfo pi;
	
	public LoginCheck2(LoginFrame login) {
		this.login = login;
		login.getUndefinedId().add("root");
	}
	
//	public logViewer getLogin() {
//		return login;
//	}
	
	public LoginFrame getLogin() {
		return login;
	}
	
	public Map<String, String> getLoginInfo() {
		return loginInfo;
	}
	
	public PrintInfo getPi() {
		return pi;
	}
	
//	public void addUndefinedId(String id) {
//		login.getUndefinedId().add(id);
//		
//	}
	
	public boolean isUndefinedId(String id) {
		boolean flag = login.getUndefinedId().contains(id)? false : true;
		return flag;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String id = login.getIdField().getText();
		
		if(ae.getSource() == login.getIdField()) {
			if(!login.getIdField().getText().isEmpty()) {
				login.getPwField().requestFocus();
			}
		}
		
		if (login.getLoginBtn().equals(ae.getSource()) || ae.getSource() == login.getPwField()) {
			String strPw = String.valueOf(login.getPwField().getPassword());
			
			UserInfo ui = new UserInfo();
			
			String storedPw = ui.getUser().get(id);
			
			  if (!ui.getUser().containsKey(id)) {
	                JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
	                login.getIdField().setText("");
	                login.getPwField().setText("");
	                login.getIdField().requestFocus();
	            } else if (storedPw.equals(strPw)) {
	            	
	                if (!isUndefinedId(id)) {
	                    JOptionPane.showMessageDialog(null, "문서를 생성할 수 있는 권한이 없음");
	                }
	            	
	            	login.dispose();
	                
	            	
//	                new PrintInfo(login);

	                new PrintInfo(login);
	                
	            } else {
	                JOptionPane.showMessageDialog(null, "아이디 및 비밀번호를 확인하세요!!");
	                login.getIdField().setText("");
	                login.getPwField().setText("");
	                login.getIdField().requestFocus();
	            }
		}
	}
	
}
