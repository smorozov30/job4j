package ru.job4j.jdbc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StoreXML {
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    @XmlRootElement
    public static class Entries {
        private List<Field> entry;

        public Entries() {

        }

        public Entries(List<Field> list) {
            this.entry = list;
        }

        public List<Field> getEntry() {
            return entry;
        }

        public void setEntry(List<Field> entry) {
            this.entry = entry;
        }
    }

    @XmlRootElement
    public static class Field {
        private int field;

        public Field() {

        }

        public Field(int value) {
            this.field = value;
        }

        public int getField() {
            return field;
        }

        public void setField(int value) {
            this.field = value;
        }
    }

    public void save(List<Entry> list) {
        try {
            JAXBContext context = JAXBContext.newInstance(Entries.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            List<Field> fields = new ArrayList<>();
            for (Entry entry : list) {
                fields.add(new Field(entry.getField()));
            }
            marshaller.marshal(new Entries(fields), target);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
