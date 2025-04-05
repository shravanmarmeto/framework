package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 */
public class propertyFileUtility {

	public String readDataFromPropertyFile(String key) throws Exception {
		FileInputStream fis = new FileInputStream(iConstantUtility.propertyPath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;

	}

}
