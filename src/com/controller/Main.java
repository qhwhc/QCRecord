package com.controller;


import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle;

public class Main {
	public static void main(String[] args) {
		try {
			System.setProperty("sun.java2d.noddraw", "true");
			UIManager.put("RootPane.setupButtonVisible", false);
			BeautyEyeLNFHelper.frameBorderStyle = FrameBorderStyle.translucencySmallShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MainFrame();
	}
	
}
