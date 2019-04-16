package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.WindowConstants;
import com.common.constants.ViewSize;
import com.common.util.DateUtil;
import com.common.util.FileUtil;
import com.common.util.NumberUtil;
import com.components.GridPanel;
import com.components.HistoryPanel;
import com.components.QcInputPanel;
import com.components.QcPanel;
import com.components.TimePanel;
import com.components.WorkInputPanel;
import com.components.common.WindowXY;
import com.pojo.QcRecord;
import com.service.OperatorService;
import com.service.QcService;
import com.service.impl.OperatorServiceImpl;
import com.service.impl.QcServiceImpl;

public class MainFrame extends JFrame{
	/**
	 * 组件管理
	 */
	private static final long serialVersionUID = 1L;
	public QcService qcService = new QcServiceImpl();
	public OperatorService operatorService = new OperatorServiceImpl();
	String pattern="yyyy_MM_dd";
	SimpleDateFormat sdf= new SimpleDateFormat(pattern);
	Date nowDate = new Date();
	public static boolean isQc = false;
	/*输入面板组件*/
	private JTextField j2  = new JTextField(8);
	private JTextField j4 = new JTextField(8);
	private JTextField j6 = new JTextField(6);
	private JLabel j8 = new JLabel();;/*QC速率*/
	private JButton j9 = new JButton("新增记录");;/*新增记录按钮*/
	private JButton j10 = new JButton("记录查看");/*查看记录按钮*/
	private JComboBox<String> j11 = new JComboBox<String>(operatorService.getList());
	{
		j2.addFocusListener(new FocusListener() {
			String preValue,afterValue,qcTime,operater;
			QcRecord qcRecord = new QcRecord();
			@Override
			public void focusLost(FocusEvent e) {
				preValue = j2.getText().trim();
				afterValue = j4.getText().trim();
				qcTime = j6.getText().trim();
				operater = j11.getSelectedItem().toString().trim();
				if(FileUtil.isEmpty() || isQc) {
					if(!("".equals(preValue) || "".equals(afterValue)||"".equals(qcTime)||"".equals(operater)) && !(!NumberUtil.isDouble(preValue) || !NumberUtil.isDouble(afterValue) || !NumberUtil.isDouble(qcTime))) {
						qcRecord.setQcFlag(true);
						qcRecord.setPreValue(Double.parseDouble(preValue.trim()));
						qcRecord.setAfterValue(Double.valueOf(afterValue.trim()));
						qcRecord.setQcTime(Double.valueOf(qcTime.trim()));
						j8.setText(String.valueOf(qcRecord.getQcRate()));
					}
				}else {
					if(!("".equals(preValue) || "".equals(afterValue)||"".equals(qcTime)||"".equals(operater)) && !(!NumberUtil.isDouble(afterValue) || !NumberUtil.isDouble(qcTime))) {
						qcRecord.setPreValue(Double.parseDouble(afterValue.trim()));
						qcRecord.setAfterValue(Double.valueOf(qcTime.trim()));
						j8.setText(String.valueOf(qcRecord.getWorkTime()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		j4.addFocusListener(new FocusListener() {
			String preValue,afterValue,qcTime,operater;
			QcRecord qcRecord = new QcRecord();
			@Override
			public void focusLost(FocusEvent e) {
				preValue = j2.getText().trim();
				afterValue = j4.getText().trim();
				qcTime = j6.getText().trim();
				operater = j11.getSelectedItem().toString().trim();
				if(FileUtil.isEmpty() || isQc) {
					if(!("".equals(preValue) || "".equals(afterValue)||"".equals(qcTime)||"".equals(operater)) && !(!NumberUtil.isDouble(preValue) || !NumberUtil.isDouble(afterValue) || !NumberUtil.isDouble(qcTime))) {
						qcRecord.setQcFlag(true);
						qcRecord.setPreValue(Double.parseDouble(preValue.trim()));
						qcRecord.setAfterValue(Double.valueOf(afterValue.trim()));
						qcRecord.setQcTime(Double.valueOf(qcTime.trim()));
						j8.setText(String.valueOf(qcRecord.getQcRate()));
					}
				}else {
					if(!("".equals(preValue) || "".equals(afterValue)||"".equals(qcTime)||"".equals(operater)) && !(!NumberUtil.isDouble(afterValue) || !NumberUtil.isDouble(qcTime))) {
						qcRecord.setPreValue(Double.parseDouble(afterValue.trim()));
						qcRecord.setAfterValue(Double.valueOf(qcTime.trim()));
						j8.setText(String.valueOf(qcRecord.getWorkTime()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		j6.addFocusListener(new FocusListener() {
			String preValue,afterValue,qcTime,operater;
			QcRecord qcRecord = new QcRecord();
			@Override
			public void focusLost(FocusEvent e) {
				qcTime = j6.getText().trim();
				if(!"0".equals(qcTime)) {
					preValue = j2.getText().trim();
					afterValue = j4.getText().trim();
					operater = j11.getSelectedItem().toString().trim();
					if(FileUtil.isEmpty() || isQc) {
						if(!("".equals(preValue) || "".equals(afterValue)||"".equals(qcTime)||"".equals(operater)) && !(!NumberUtil.isDouble(preValue) || !NumberUtil.isDouble(afterValue) || !NumberUtil.isDouble(qcTime))) {
							qcRecord.setQcFlag(true);
							qcRecord.setPreValue(Double.parseDouble(preValue.trim()));
							qcRecord.setAfterValue(Double.valueOf(afterValue.trim()));
							qcRecord.setQcTime(Double.valueOf(qcTime.trim()));
							j8.setText(String.valueOf(qcRecord.getQcRate()));
						}
					}else {
						if(!("".equals(preValue) || "".equals(afterValue)||"".equals(qcTime)||"".equals(operater)) && !(!NumberUtil.isDouble(afterValue) || !NumberUtil.isDouble(qcTime))) {
							qcRecord.setPreValue(Double.parseDouble(afterValue.trim()));
							qcRecord.setAfterValue(Double.valueOf(qcTime.trim()));
							j8.setText(String.valueOf(qcRecord.getWorkTime()));
						}
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		j9.addActionListener(new ActionListener() {
			QcRecord qcRecord = new QcRecord();
			String preValue,afterValue,qcTime,operater;
			public void actionPerformed(ActionEvent arg0) {
				preValue = j2.getText().trim();
				afterValue = j4.getText().trim();
				qcTime = j6.getText().trim();
				operater = j11.getSelectedItem().toString().trim();
				if("".equals(preValue) || "".equals(afterValue)||"".equals(qcTime)||"".equals(operater)) {
					JOptionPane.showMessageDialog(qcPanel.getParent(), "请输入完整数据！", "提示",JOptionPane.WARNING_MESSAGE);
				}else if(!NumberUtil.isDouble(preValue) || !NumberUtil.isDouble(afterValue) ||qcTime.trim().equals("0") || !NumberUtil.isDouble(qcTime)){
					JOptionPane.showMessageDialog(qcPanel.getParent(), "请输入正确的格式！", "提示",JOptionPane.WARNING_MESSAGE);
				}else{
					isQc = false;
					qcRecord.setQcFlag(true);
					qcRecord.setId("QC");
					qcRecord.setPreValue(Double.parseDouble(preValue.trim()));
					qcRecord.setAfterValue(Double.valueOf(afterValue.trim()));
					qcRecord.setQcTime(Double.valueOf(qcTime.trim()));
					qcRecord.setOperater(operater.trim());
					qcService.add(qcRecord);
					j8.setText(String.valueOf(qcRecord.getQcRate()));
					qcPanel.add(new GridPanel(qcService.get(sdf.format(new Date()))));
					repaintInput();
					j2.setText("");
					j4.setText("");
					j6.setText("");
					j8.setText("");
					repaintGrid(new Date());
					qcPanel.revalidate();
					JOptionPane.showMessageDialog(qcPanel.getParent(), "新增成功！", "提示",JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		j10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(getHeight()==ViewSize.FRAMEHEIGHT){
					setSize(ViewSize.FRAMEWIDTH,ViewSize.INPUTPANELHEIGHT);
				}
				else{
					setSize(ViewSize.FRAMEWIDTH,ViewSize.FRAMEHEIGHT);
				}
			}
		});

	}
	/*工作界面*/
	JButton jb13 = new JButton("确认作业");
	private JPanel qcInputPanel = new QcInputPanel(j2,j4,j6,j8,j11,j9,j10);
	{
		if(!FileUtil.isEmpty()) {
			qcInputPanel = new WorkInputPanel(j2,j4,j6,j8,j11,jb13,j10);
		}
		jb13.addActionListener(new ActionListener() {
			QcRecord qcRecord = new QcRecord();
			String id,preValue,afterValue,qcTime,operater;
			public void actionPerformed(ActionEvent arg0) {
				id = j2.getText().trim();
				preValue = j4.getText().trim();
				afterValue = j6.getText().trim();
				qcTime = j8.getText().trim();
				operater = j11.getSelectedItem().toString().trim();
				if("".equals(preValue) || "".equals(afterValue)||"".equals(qcTime)||"".equals(operater)) {
					JOptionPane.showMessageDialog(qcPanel.getParent(), "请输入完整数据！", "提示",JOptionPane.WARNING_MESSAGE);
				}else if(!NumberUtil.isDouble(preValue) || !NumberUtil.isDouble(afterValue)){
					JOptionPane.showMessageDialog(qcPanel.getParent(), "请输入正确的格式！", "提示",JOptionPane.WARNING_MESSAGE);
				}else{
					qcRecord.setQcFlag(false);
					qcRecord.setId(id);
					qcRecord.setQcTime(Double.valueOf(qcTime));
					qcRecord.setPreValue(Double.parseDouble(preValue.trim()));
					qcRecord.setAfterValue(Double.valueOf(afterValue.trim()));
					qcRecord.setOperater(operater.trim());
					qcService.add(qcRecord);
					qcPanel.add(new GridPanel(qcService.get(sdf.format(new Date()))));
					repaintGrid(new Date());
					qcPanel.revalidate();
					JOptionPane.showMessageDialog(qcPanel.getParent(), "新增成功！", "提示",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	/*时间面板组件*/
	SpinnerDateModel model2 = new SpinnerDateModel();
	JSpinner js1 = new JSpinner(model2);
	{
		model2.setCalendarField(Calendar.WEEK_OF_MONTH);
		js1.setEditor(new JSpinner.DateEditor(js1, "dd-MM-yyyy"));
	}
	JButton jb1 = new JButton("确定");
	JButton jb2 = new JButton("前一天");
	JButton jb3 = new JButton("后一天");
	JTextField jb4 = new JTextField("请输入批次");
	/*时间面板触发事件*/
	{
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object value =  model2.getValue();
				try {
					nowDate = sdf.parse(sdf.format(sdf.parse(sdf.format(value)).getTime()));
					js1.setValue(nowDate);
					GridPanel.isFilter = jb4.getText().trim();
					repaintGrid(nowDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				qcPanel.revalidate();
				System.out.println(sdf.format(model2.getValue()));
			}
		});
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object value =  model2.getValue();
				try {
					nowDate = sdf.parse(sdf.format(sdf.parse(sdf.format(value)).getTime()-1));
					js1.setValue(nowDate);
					repaintGrid(nowDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				qcPanel.revalidate();
				System.out.println(sdf.format(model2.getValue()));
			}
		});
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object value = null;
				value = model2.getValue();
				try {
					nowDate = sdf.parse(sdf.format(sdf.parse(DateUtil.getSpecifiedDayAfter((sdf.format(value))))));
					js1.setValue(nowDate);
					repaintGrid(nowDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				qcPanel.revalidate();
				System.out.println(sdf.format(model2.getValue()));
			}
		});

		jb4.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

			}

			@Override
			public void focusGained(FocusEvent e) {
				jb4.setText("");
			}
		});
	}
	private TimePanel timePanel = new TimePanel(js1,jb1,jb2,jb3,jb4);
	GridPanel gridPanel = new GridPanel(qcService.get(sdf.format(new Date())));
	private HistoryPanel historyPanel = new HistoryPanel(timePanel, gridPanel);
	/*主面板*/
	private QcPanel qcPanel = new QcPanel(qcInputPanel,historyPanel);
	/*表格面板组件*/


	/**
	 * 视图管理
	 */
	/*视图加载*/
	public MainFrame(){
		/*Framen面板加载*/
		add(qcPanel);
		setLocation(WindowXY.getXY(ViewSize.FRAMEWIDTH, ViewSize.LOCATION_Y));
		setLayout(null);
		setSize(ViewSize.FRAMEWIDTH, ViewSize.INPUTPANELHEIGHT);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		/*加载菜单*/
		setJMenuBar(loadMenuBar()) ;  //为 窗体设置  菜单工具栏
		setVisible(true);
	}

	/**
	 * 菜单管理
	 * @return
	 */
	public JMenuBar loadMenuBar() {
		JMenuBar  br=new  JMenuBar() ;  //创建菜单工具栏
		JMenu menu = new JMenu("Menu");
		JMenuItem jm1 = new JMenuItem("更新QC") ;  //菜单项
		jm1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isQc = true;
				repaintInput();
				j2.setText("");
				j4.setText("");
				j6.setText("");
				j8.setText("");
				JOptionPane.showMessageDialog(qcPanel.getParent(), "请更新QC!", "提示",JOptionPane.WARNING_MESSAGE);
			}
		});
		JMenuItem jm2 = new JMenuItem("新增操作人员") ;//菜单项
		jm2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(qcPanel.getParent(), "请输入姓名:");
				if(name != null && !"".equals(name.trim())) {
					name = FileUtil.readFile(System.getProperty("user.dir") + "/record_data/operator") + "," + name;
					operatorService.save(name);
					repaintInput();
					JOptionPane.showMessageDialog(qcPanel.getParent(), "添加成功！", "提示",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		JMenuItem jm3 = new JMenuItem("删除操作人员") ;//菜单项
		jm3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(qcPanel.getParent(), "请输入删除的姓名:");
				if(name != null && !"".equals(name.trim())) {
					if(operatorService.delete(name.trim())) {
						JOptionPane.showMessageDialog(qcPanel.getParent(), "删除成功！", "提示",JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(qcPanel.getParent(), "无此人！", "提示",JOptionPane.WARNING_MESSAGE);
					}
					repaintInput();
				}
			}
		});
		menu.add(jm1);
		menu.add(jm2);
		menu.add(jm3);
		br.add(menu) ;      //将菜单增加到菜单工具栏
		return br;
	}

	/*输入框重绘*/
	public void repaintInput() {
		remove(this.qcPanel);
		JComboBox<String> j11 = new JComboBox<String>(operatorService.getList());
		if(FileUtil.isEmpty() || isQc) {
			JPanel qcInputPanel = new QcInputPanel(j2,j4,j6,j8,j11,j9,j10);
			this.j11 = j11;
			QcPanel qcPanel = new QcPanel(qcInputPanel,historyPanel);
			add(qcPanel);
			this.qcInputPanel = qcInputPanel;
			this.qcPanel = qcPanel;
		}else {
			JPanel qcInputPanel = new WorkInputPanel(j2,j4,j6,j8,j11,jb13,j10);
			this.j11 = j11;
			QcPanel qcPanel = new QcPanel(qcInputPanel,historyPanel);
			add(qcPanel);
			this.qcInputPanel = qcInputPanel;
			this.qcPanel = qcPanel;
		}

	}
	/*表格框重绘*/
	public void repaintGrid(Date date) {
		remove(this.qcPanel);
		GridPanel gridPanel = new GridPanel(qcService.get(sdf.format(date)));
		historyPanel = new HistoryPanel(timePanel, gridPanel);
		QcPanel qcPanel = new QcPanel(qcInputPanel,historyPanel);
		add(qcPanel);
		this.gridPanel = gridPanel;
		this.qcPanel = qcPanel;
	}

}
