package com.edu.uestc.liran.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Tab2Activity extends Activity {
	private Spinner in, res;
	private EditText bin;
	private Button bclear, cal;
	private TextView sys, inT, resT;
	private static final String list[] = { "2", "8", "10", "16" };
	private static String i, r;
	private ArrayAdapter<String> inAdap, resAdap;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab2);
		in = (Spinner) findViewById(R.id.in);
		inT = (TextView) findViewById(R.id.inT);
		res = (Spinner) findViewById(R.id.res);
		resT = (TextView) findViewById(R.id.resT);
		bin = (EditText) findViewById(R.id.bin);
		bclear = (Button) findViewById(R.id.bclear);
		cal = (Button) findViewById(R.id.cal);
		sys = (TextView) findViewById(R.id.sys);

		inAdap = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		resAdap = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);

		inAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		resAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		in.setAdapter(inAdap);
		res.setAdapter(resAdap);

		in.setOnItemSelectedListener(new inSpinnerSelectedListener());
		res.setOnItemSelectedListener(new resSpinnerSelectedListener());

		in.setVisibility(View.VISIBLE);
		res.setVisibility(View.VISIBLE);

		bclear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bin.setText(null);
				sys.setText(null);
			}
		});
		cal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String exp = bin.getText().toString();
				String temp = Turn(i, r, exp);
				sys.setText(temp);
			}
		});

	}

	protected String Turn(String in, String res, String exp) {
		// TODO Auto-generated method stub

		if (in.equals("2")) {
			if (res.equals("8")) {
				String temp = Integer.valueOf(exp, 2).toString();
				int i = Integer.parseInt(temp);
				return Integer.toOctalString(i).toString();
			} else if (res.equals("10")) {
				return Integer.valueOf(exp, 2).toString();
			} else if (res.equals("16")) {
				String temp = Integer.valueOf(exp, 2).toString();
				int i = Integer.parseInt(temp);
				return Integer.toHexString(i).toString();
			} else
				return exp;
		} else if (in.equals("8")) {
			if (res.equals("2")) {
				String temp = Integer.valueOf(exp, 8).toString();
				int i = Integer.parseInt(temp);
				return Integer.toBinaryString(i).toString();
			} else if (res.equals("10")) {
				return Integer.valueOf(exp, 8).toString();
			} else if (res.equals("16")) {
				String temp = Integer.valueOf(exp, 8).toString();
				int i = Integer.parseInt(temp);
				return Integer.toHexString(i).toString();
			} else
				return exp;
		} else if (in.equals("10")) {
			int i = Integer.parseInt(exp);
			if (res.equals("2")) {
				return Integer.toBinaryString(i).toString();
			} else if (res.equals("8")) {
				return Integer.toOctalString(i).toString();
			} else if (res.equals("16")) {
				return Integer.toHexString(i).toString();
			} else
				return exp;
		} else if (in.equals("16")) {
			if (res.equals("2")) {
				String temp = Integer.valueOf(exp, 16).toString();
				int i = Integer.parseInt(temp);
				return Integer.toBinaryString(i).toString();
			} else if (res.equals("8")) {
				String temp = Integer.valueOf(exp, 16).toString();
				int i = Integer.parseInt(temp);
				return Integer.toOctalString(i).toString();
			} else if (res.equals("10")) {
				return Integer.valueOf(exp, 16).toString();
			} else
				return exp;
		}
		return null;
	}

	class inSpinnerSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// Vew.setText("你的血型是："+m[arg2]);
			i = list[arg2];
			inT.setText("输入" + i + "进制数：");
		}

		public void onNothingSelected(AdapterView<?> arg0) {
		}
	}

	class resSpinnerSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// Vew.setText("你的血型是："+m[arg2]);
			r = list[arg2];
			resT.setText("转换得到" + r + "进制数：");
		}

		public void onNothingSelected(AdapterView<?> arg0) {
		}
	}
}
