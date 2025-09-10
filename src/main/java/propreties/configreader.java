package propreties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configreader {
    private Properties prop;
    public String projectpath=System.getProperty("user.dir");
    public configreader() {
        prop = new Properties();
        try {
            FileInputStream files = new FileInputStream(projectpath+"\\src\\main\\java\\propreties\\config.properties");
            prop.load(files);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getproperty(String key) {
        return prop.getProperty(key);
    }
}
