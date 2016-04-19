package com.edu.uestc.liran.calculator;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TabHost tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec("TAB1").setIndicator("科学计算器")
				.setContent(new Intent().setClass(this, Tab1Activity.class)));
		tabHost.addTab(tabHost.newTabSpec("TAB2").setIndicator("程序员计算器")
				.setContent(new Intent().setClass(this, Tab2Activity.class)));

	}
}
