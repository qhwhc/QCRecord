package com.components;


import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WorkInputPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel jl1 = null;/*前值*/
	private JLabel jl2 = null;/*后值*/
	private JLabel jl3 = null;/*作业时间*/
	private JLabel jl4 = null;/*QC速率*/

	public WorkInputPanel(JTextField jt1/*批次输入框*/,JTextField jt2/*前值输入框*/,JTextField jt3/*标准值*/,JLabel jt4/*作业时间*/,
						  JComboBox<String> jc1,/*操作人员*/JButton jb1/*增加按钮*/,JButton jb2/*查看按钮*/) {
		setLayout(null);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(20, 5, 5));
		jp1.setBounds(0, 2, 400, 50);
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(20, 5, 5));
		jp2.setBounds(400, 0,275, 50);
		setLocation(0, 0);
		setSize(675, 40);
		this.jl1 = new JLabel("批号");
		this.jl2 = new JLabel("前值");
		this.jl3 = new JLabel("标准值");
		this.jl4 = new JLabel("作业时间");
		jp1.add(jl1);
		jp1.add(jt1);
		jp1.add(jl2);
		jp1.add(jt2);
		jp1.add(jl3);
		jp1.add(jt3);
		jp1.add(jl4);
		jp1.add(jt4);
		jp2.add(jc1);
		jp2.add(jb1);
		jp2.add(jb2);
		add(jp1);
		add(jp2);
		/*QC颜色*/
		jt4.setForeground(Color.red);
	}
}
