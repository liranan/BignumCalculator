package com.edu.uestc.liran.calculator;

import java.util.Stack;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tab1Activity extends Activity {
	private TextView calres;
	private EditText exp;
	private Button calculate, clear;
	public static String TAG = "calculate";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1);
		exp = (EditText) findViewById(R.id.exp);
		calres = (TextView) findViewById(R.id.calres);
		calculate = (Button) findViewById(R.id.calculate);
		clear = (Button) findViewById(R.id.clear);

		calculate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String in = exp.getText().toString();
				String res = Calculate(in);
				// String temp = operation.com("13", "5");
				calres.setText(res);
			}
		});
		clear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				exp.setText(null);
				calres.setText(null);
			}
		});
	}

	protected String Calculate(String in) {
		calres.setText("");
		// TODO Auto-generated method stub
		Stack opStack = new Stack();
		Stack daStack = new Stack();
		String temp = "";
		String temp1 = "";
		for (int i = in.length() - 1; i >= 0; i--) {
			char it = in.charAt(i);
			if (it >= '0' && it <= '9' || it == '.') {
				temp = it + temp;
			} else if (it == '+' || it == '-') {
				daStack.push(temp);
				temp = "";
				opStack.push(it);
			} else {
				for (i = i - 1; i >= 0; i--) {
					char it1 = in.charAt(i);
					if (it1 >= '0' && it1 <= '9' || it1 == '.') {
						temp1 = it1 + temp1;
					} else
						break;
				}
				switch (it) {
				case '*':
					temp = operation.mul(temp1, temp);
					break;
				case '/':
					temp = operation.rem(temp1, temp);
					break;
				case '~':
					System.out.println(temp);
					temp = operation.evo(temp);
					System.out.println(temp);
					break;
				case '%':
					temp = operation.com(temp1, temp);
					break;
				case '!':
					temp = operation.fac(temp1);
					break;
				default:
					return "输入有误!";
				}
				temp1 = "";
				if (i != 0)
					i++;
			}
		}
		if (!(temp == "")) {
			daStack.push(temp);
		}
		String res = "";
		if (!daStack.isEmpty())
			res = daStack.pop().toString();
		System.out.println(res);
		while (!daStack.isEmpty()) {
			if (!opStack.isEmpty()) {
				String da = daStack.pop().toString();
				System.out.println(da);
				if (opStack.pop().toString().equals("+"))
					res = operation.add(res, da);
				else
					res = operation.sub(res, da);
			} else
				return "输入有误!";
		}
		return res;
		// else {
		// switch (it) {
		// case '+':
		// case '-':
		// daStack.push(temp);
		// temp = "";
		// opStack.push(it);
		// break;
		// case '*':
		// for (; i >= 0; i--) {
		// char it1 = in.charAt(i);
		// if (it1 > '0' && it1 < '9' || it1 == '.') {
		// temp1 = it1 + temp1;
		// } else {
		//
		// break;
		// }
		// }
		// i++;
		// break;
		// case '/':
		// case '%':
		// case '~':
		// case '!':
		// case '(':
		// case ')':
		// default:
		// // }
		// if (temp == "") {
		// calres.setText("输入有误！");
		// return;
		// }
		// daStack.push(temp);
		// while (!opStack.isEmpty())
		// System.out.println("op:"+opStack.pop());
		// while (!daStack.isEmpty())
		// System.out.println("da:"+daStack.pop());
	}
}
