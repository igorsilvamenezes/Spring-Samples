package br.com.igormenezes.spring.minicontainer;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.PropertyUtils;

public class Container {
	
	static Map<String, Object> components = iniMap();

	private static Map<String, Object> iniMap() {
		components = new HashMap<String, Object>();
		try{
			Properties properties = new Properties();
			properties.load(new FileInputStream("context.properties"));
			
			for(String key : properties.stringPropertyNames()){
				if(key.indexOf('.') < 0 ){
					Object bean = Class.forName(properties.getProperty(key)).newInstance();
					components.put(key, bean);
					properties.remove(key);
				}
			}
			for(String key : properties.stringPropertyNames() ){
				String[] tokens = key.split("\\.");
				
				Object receptorBean = components.get(tokens[0]);
				String propertyName = tokens[1];
				Object injectedBean = components.get(properties.get(key));
				PropertyUtils.setProperty(receptorBean, propertyName, injectedBean);
			}
		} catch( Exception e){
			e.printStackTrace();
		}

		return components;
	}

	public static Object getComponent(String component) {		
		return components.get(component);
	}
}
