package com.components;

import javax.swing.JPanel;

import com.common.constants.ViewSize;

public class QcPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public QcPanel(JPanel inpuPanel,HistoryPanel historyPanel) {
		setLayout(null);
		add(inpuPanel);
		add(historyPanel);
		setBounds(0, 0, ViewSize.FRAMEWIDTH, 500);
		inpuPanel.setLocation(10, 0);
		historyPanel.setBounds(10, 50, 645, 300);
	}
}
