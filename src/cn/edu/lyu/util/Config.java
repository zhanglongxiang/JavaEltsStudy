package cn.edu.lyu.util;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	private String file;
	private Properties cfg = new Properties();
	
	public Config(String file)throws Exception{
		this.file = file;
		cfg.load(new FileInputStream(file));
	}
	
	public String getString(String key){
		return cfg.getProperty(key);
	}
	
	public int getInt(String key){
		return Integer.parseInt(cfg.getProperty(key));
	}
	
	public double getDouble(String key){
		return Double.parseDouble(getString(key));
	}

}
