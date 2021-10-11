package com.sunmnet.bigdata.common.util;

import java.text.DecimalFormat;

public class MoneyUtils {

	public static long yuan2Fen(double yuan) {
		DecimalFormat formatter = new DecimalFormat("#0.00");
	    String tmp = formatter.format(yuan);
	    String fen = tmp.replace(".", "");
	    return Long.parseLong(fen);
	}
	
	public static String fen2Yuan(long fen) {
		DecimalFormat formatter = new DecimalFormat("#0.00");
	    String yuan = formatter.format(fen/100.0);
	    return yuan;
	}

}