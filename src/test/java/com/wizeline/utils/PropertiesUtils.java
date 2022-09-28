package com.wizeline.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    public static String readProperty(String property, String file){
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            properties.load(fileInputStream);
            String propertyValue = properties.getProperty(property);

            if(propertyValue != null){
                return propertyValue;
            }else{
                throw  new IllegalArgumentException("Property " + property + " not found in file: " + file);
            }

        }catch(IOException ioException){
            System.err.println("Error loading property: " + property + " from file: " + file);
        }
        return null;
    }
}
