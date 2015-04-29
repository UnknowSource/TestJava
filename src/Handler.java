import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;
public class Handler implements ActionListener {
	private String command; 
	public Handler(String str) {
		this.command = str;
	}
	@Override
	public void actionPerformed(ActionEvent paramActionEvent) {
		System.out.println(command);
		try {
			java.lang.Runtime.getRuntime().exec(command);
			JOptionPane.showMessageDialog(null, "ok,执行成功");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error,未执行成功");
			try {
				System.out.println(new String(e.getMessage().getBytes("iso-8859-1"),"gb2312"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
	}
}
