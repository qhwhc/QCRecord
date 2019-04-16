package com.components;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class HistoryPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public HistoryPanel(TimePanel timePanel,GridPanel gridPanel) {
		setLayout(null);
		add(gridPanel);
		add(timePanel);
		gridPanel.setBounds(10, 65, 625, 200);
		timePanel.setBounds(63, 25, 550, 50);
		setBorder(new TitledBorder(null, "历史记录", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

}
