package test.tesuto.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties
{
    private Properties settingsProperties = new Properties();
    private static TestProperties _INSTANCE = null;

    private TestProperties()
    {
        try
        {
            settingsProperties.load(new FileInputStream(new File("src/main/resources/"+System.getProperty("env", "general")+".properties")));
        }
        catch (IOException e)
        {
            System.out.println("Exception in " + TestProperties._INSTANCE.getClass().toString());
            e.printStackTrace();
        }
    }

    public static TestProperties getInstance()
    {
        if (_INSTANCE==null)
        {
            _INSTANCE = new TestProperties();
        }
        return _INSTANCE;
    }

    public String getProperty(String key, String defaultValue)
    {
        return settingsProperties.getProperty(key, defaultValue);
    }

    public String getProperty(String key)
    {
        return settingsProperties.getProperty(key);
    }
}
