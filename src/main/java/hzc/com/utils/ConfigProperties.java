package hzc.com.utils;

import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigProperties {
	
	private static Logger logger = Logger.getLogger( ConfigProperties.class );
	
	private static Properties prop;
	private static String fileName = "/config/config.properties";

     public static String getProperty(String key){
			if(prop == null){
				try {
					prop = new Properties();
					prop.load(ConfigProperties.class.getResourceAsStream(fileName));
				} catch (Exception e) {
					logger.error("读取参数异常", e);
				}
			}
			return prop.getProperty(key);
	 }

	public static void main(String[] args) {
		System.out.println(getProperty("dufaultPassword"));
	}

}
