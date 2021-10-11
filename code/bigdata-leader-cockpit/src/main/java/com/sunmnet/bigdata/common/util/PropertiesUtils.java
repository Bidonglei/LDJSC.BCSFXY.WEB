package com.sunmnet.bigdata.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	 public static Properties getProperties(){
	        InputStream is=PropertiesUtils.class.getResourceAsStream("/datasource.properties");
	        Properties properties = new Properties();
	        try {
	            properties.load(is);
	            return properties;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;

	    }

}
