package ru.job4j.jdbc;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

public class ConvertXSQT {

    public void convert(File source, File dest, File scheme) {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = factory.newTransformer(
                    new StreamSource(
                            new FileInputStream(scheme))
            );
            transformer.transform(new StreamSource(
                            new FileInputStream(source)),
                    new StreamResult(dest)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
