package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String fileName = reader.readLine();
	    reader.close();

	    InputStream is = new FileInputStream(fileName);
	    try {
		    load(is);
		    is.close();
	    } catch (Exception e) {

	    }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties props = new Properties();
	    for (Map.Entry<String, String> pair : properties.entrySet()) {
		    props.setProperty(pair.getKey(), pair.getValue());
	    }
	    props.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
	    Properties props = new Properties();
	    props.load(inputStream);
	    for (String key : props.stringPropertyNames()) {
		    String value = props.getProperty(key);
		    properties.put(key, value);
	    }
    }
}
