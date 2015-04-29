import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class RunUp implements ActionListener {
	public static void main(String[] args) throws Exception{
		String encoding = System.getProperty("file.encoding");  
        System.out.println("Encoding:" + encoding);  
		new RunUp().initFrame();
	}
	
	public void initFrame() throws Exception{
		List<buttonForm> btnlist = initProperty();
		
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		JButton btnadd = new JButton("+");
		btnadd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("添加");
			}
		});
		for(int i = 0; i < btnlist.size(); i ++){
			JButton jt = new JButton(btnlist.get(i).getText());
			String str = btnlist.get(i).getCommand();
			jt.setSize(30,40);
			jt.addActionListener(new Handler(str));
			frame.add(jt);
		}
		frame.setTitle("cmd小助手");
		frame.setVisible(true);
		frame.setBounds(400,200, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	/**
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private static List<buttonForm> initProperty() throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbl = dbf.newDocumentBuilder();
		Document doc = dbl.parse(new File("D://handler.xml"));
		NodeList nlist = doc.getElementsByTagName("option");
		Map<String,String> opt = new HashMap<String,String>();
		List<buttonForm> list = new ArrayList<buttonForm>();
		for(int i = 0; i< nlist.getLength(); i++){
			Element el = (Element)nlist.item(i);
			String text = el.getChildNodes().item(1).getFirstChild().getNodeValue();
			String command = el.getChildNodes().item(3).getFirstChild().getNodeValue();
			opt.put(text, command);
		}
		System.out.println(opt.keySet());
		for (String string : opt.keySet()) {
			buttonForm bf = new buttonForm();
			bf.setText(string);
			bf.setCommand(opt.get(string));
			list.add(bf);
		}
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
}
