package com.edu.uestc.liran.calculator;

import java.math.BigDecimal;

import android.util.Log;

public class operation {
	public static String add(String x, String y) {
		// int xp = x.indexOf(".");
		// int yp = y.indexOf(".");
		BigDecimal xl = new BigDecimal(x);
		BigDecimal yl = new BigDecimal(y);
		return xl.add(yl).toString();
	}

	public static String sub(String x, String y) {
		BigDecimal xl = new BigDecimal(x);
		BigDecimal yl = new BigDecimal(y);
		return xl.subtract(yl).toString();
	}

	public static String mul(String x, String y) {
		BigDecimal xl = new BigDecimal(x);
		BigDecimal yl = new BigDecimal(y);
		return xl.multiply(yl).toString();
	}

	public static String rem(String x, String y) {
		if (y != "0") {
			BigDecimal xl = new BigDecimal(x);
			BigDecimal yl = new BigDecimal(y);
			return xl.divide(yl, 32, BigDecimal.ROUND_HALF_EVEN).toString();
		} else
			return "除数不能为0";
	}

	public static String fac(String x) {
		if (!x.equals("0")) {
			int n = Integer.parseInt(x);
			long res = 1;
			for (int i = 2; i <= n; i++) {
				res *= i;
			}
			return String.valueOf(res);
		} else
			return "阶乘数不能为0";
	}

	public static String evo(String x) {
		System.out.println(x);
		long n = Long.parseLong(x);
		// double res = Math.sqrt(n);
		return String.valueOf(Math.sqrt(n));
	}

	public static String com(String x, String y) {
		if (y != "0" && y != "1") {
			long n = Long.parseLong(x);
			int m = Integer.parseInt(y);
			// long res = n % m;
			return String.valueOf(n % m);
		} else if (y == "0")
			return "不能对0取余";
		else
			return "不能对1取余";
	}
}
