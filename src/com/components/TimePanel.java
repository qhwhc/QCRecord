package com.components;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class TimePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public TimePanel(JSpinner j1/*时间年*/,JButton b1/*确定*/,JButton b2/*上一页*/,JButton b3/*下一页*/,JTextField b4/*批次查询*/) {
		setLayout(null);
		j1.setSize(100, 30);
		add(j1);
		b1.setBounds(200, 0, 50, 30);
		add(b1);
		b2.setBounds(380, 0, 60, 30);
		add(b2);
		b3.setBounds(450, 0, 60, 30);
		add(b3);
		b4.setBounds(110, 0, 80, 30);
		add(b4);
		b4.setForeground(Color.GRAY);
	}

}
