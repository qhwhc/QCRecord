package com.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.common.util.FileUtil;

import net.sf.json.JSONArray;

public class GridPanel extends JPanel{
	public static String isFilter = "";
	private static final long serialVersionUID = 1L;
	JTable table = null;
	private JScrollPane scrollPane = null;/*滚动条*/
	public GridPanel(JSONArray jsonArray) {
		Object[][] playerInfo = new Object[0][7];
		String[] Names = { "批次","前值", "后值", "作业时间", "速率", "作业人员","记录时间" };
		if(jsonArray != null) {
			playerInfo = new Object[jsonArray.size()][7];
			for (int i = 0; i < jsonArray.size(); i++) {
				String id = jsonArray.getJSONObject(i).getString("id");
				if("QC".equals(id)) {
					playerInfo[i][0] = id;
					playerInfo[i][1] = jsonArray.getJSONObject(i).getString("preValue") + "A";
					playerInfo[i][2] = jsonArray.getJSONObject(i).getString("afterValue") + "A";
					playerInfo[i][3] = jsonArray.getJSONObject(i).getString("qcTime") + "秒";
					playerInfo[i][4] = jsonArray.getJSONObject(i).getString("qcRate") + "A/min";
					playerInfo[i][5] = jsonArray.getJSONObject(i).getString("operater");
					playerInfo[i][6] = jsonArray.getJSONObject(i).getString("qcdate");
				}else {
					playerInfo[i][0] = jsonArray.getJSONObject(i).getString("id");
					playerInfo[i][1] = jsonArray.getJSONObject(i).getString("preValue") + "A";
					playerInfo[i][2] = jsonArray.getJSONObject(i).getString("afterValue") + "A";
					playerInfo[i][3] = jsonArray.getJSONObject(i).getString("workTime") + "秒";
					playerInfo[i][4] = jsonArray.getJSONObject(i).getString("qcRate") + "A/min";
					playerInfo[i][5] = jsonArray.getJSONObject(i).getString("operater");
					playerInfo[i][6] = jsonArray.getJSONObject(i).getString("qcdate");
				}
			}
		}
		if(!"".equals(isFilter)) {
			playerInfo = searchFile();
		}
		// 创建表格中的横标题
		// 以Names和playerInfo为参数，创建一个表格
		DefaultTableModel model = new DefaultTableModel(playerInfo, Names);
		table = new JTable(model);
		// 将表格加入到滚动条组件中
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		// 再将滚动条组件添加到中间容器中
		table.setPreferredScrollableViewportSize(new Dimension(550, 150));
	}

	public String[][] searchFile() {
		int num = 0;
		List<JSONArray> list = new ArrayList<JSONArray>();
		File file = new File(System.getProperty("user.dir") + "/record_data/");
		File[] listFiles = file.listFiles();
		String str = "";
		for (File file2 : listFiles) {
			str = FileUtil.readFile(file2.getPath());
			if(str.startsWith("[")) {
				JSONArray fromObject = JSONArray.fromObject(str);
				list.add(fromObject);
				num += fromObject.size();
			}
		}
		String[][] strArray  = new String[num][7];
		num = 0;
		String id = "";
		for (JSONArray ja : list) {
			for (int i = 0; i < ja.size(); i++) {
				id = ja.getJSONObject(i).getString("id");
				if(id.equals(isFilter)) {
					strArray[num][0] = ja.getJSONObject(i).getString("id");
					strArray[num][1] = ja.getJSONObject(i).getString("preValue") + "A";
					strArray[num][2] = ja.getJSONObject(i).getString("afterValue") + "A";
					strArray[num][3] = ja.getJSONObject(i).getString("workTime") + "秒";
					strArray[num][4] = ja.getJSONObject(i).getString("qcRate") + "A/min";
					strArray[num][5] = ja.getJSONObject(i).getString("operater");
					strArray[num][6] = ja.getJSONObject(i).getString("qcdate");
					num ++;
				}
			}
		}
		String[][] strArray2  = new String[num][7];
		for (int i = 0; i < strArray2.length; i++) {
			strArray2[i][0] = strArray[i][0];
			strArray2[i][1] = strArray[i][1];
			strArray2[i][2] = strArray[i][2];
			strArray2[i][3] = strArray[i][3];
			strArray2[i][4] = strArray[i][4];
			strArray2[i][5] = strArray[i][5];
			strArray2[i][6] = strArray[i][6];
		}
		isFilter = "";
		return strArray2;
	}

}
