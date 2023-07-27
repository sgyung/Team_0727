package team02_project;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class PrintInfoActionListener extends WindowAdapter implements ActionListener {

	private PrintInfo pi;
	private Logs logs;
	
	public PrintInfoActionListener(PrintInfo pi) {
		this.pi = pi;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() ==  pi.getLoadBtn()) {
			loadFile();								
		}// end if
		
		if(e.getSource() == pi.getViewBtn()) {
			if(logs != null) {
				String str = logs.logView();
				JOptionPane.showMessageDialog(pi, str);				
			} else {
				JOptionPane.showMessageDialog(pi, "Log파일을 선택해주세요.");
			}
		}// end if
		
		if(e.getSource() == pi.getReportBtn()) {
			if(logs != null) {
				try {
					logs.saveReport();
				} catch (IOException e1) {
					e1.printStackTrace();
				}				
			} else {
				JOptionPane.showMessageDialog(pi, "Log파일을 선택해주세요.");
			}
		}
		
		if(e.getSource() == pi.getSetBtn()) {
			if(logs != null) {
				printRangeLine();				
			} else {
				JOptionPane.showMessageDialog(pi, "Log파일을 선택해주세요.");
			}
		}
	}//actionPerformed
	
	public void loadFile() {
		File file;
		String path;
		
		FileDialog fd = new FileDialog(pi, "파일 불러오기",FileDialog.LOAD);
		fd.setVisible(true);
			
		String directory = fd.getDirectory();
		String fileName = fd.getFile();
		
		if(directory != null && fileName != null) {
			path = directory + fileName;
			
			file= new File(directory + fileName);
			logs = new Logs(file);
			
			pi.getJlblPath().setText(path);
			
			//파일명 라벨에 세팅
			//pi.getSelectFile().setText(path);
			
			if(!pi.getJta().getText().isEmpty()) {
				pi.getJta().setText("");
				
				for(int i = 0; i<logs.getLogList().size(); i++) {
					pi.getJta().append(logs.getLogList().get(i) + "\n");
				}
			}else {
				for(int i = 0; i<logs.getLogList().size(); i++) {
					pi.getJta().append(logs.getLogList().get(i) + "\n");
				}	
			}
		}
	}	
	public void printRangeLine() {
		
		//Logs logs = new Logs(logDataFile);
		
		if(!pi.getJtfStart().getText().isEmpty() && !pi.getJtfEnd().getText().isEmpty()) {
			int startLine = Integer.parseInt(pi.getJtfStart().getText());
			int endLine = Integer.parseInt(pi.getJtfEnd().getText());
			logs.splitLogs(startLine, endLine);
			JOptionPane.showMessageDialog(pi, startLine + " ~ " + endLine + "\n설정되었습니다");
		}else {
			JOptionPane.showMessageDialog(pi, "원하는 라인값을 입력해주세요");
		}
	}
	
//	public void printLogs() {
//		
//		logs.splitLogs();
//		pi.jta.setText(logs.logView());
//	}

}
