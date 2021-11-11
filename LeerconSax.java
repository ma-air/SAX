package practica_6;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class LeerconSax {

    public static void conSax(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
            	boolean bnif = false;
                boolean bNombre = false;
                boolean bApellidos = false;
                boolean bSalario = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("inicia elemento:" + qName);
                    if (qName.equalsIgnoreCase("empleado")) {
                       
                    }
                    if (qName.equalsIgnoreCase("nif")) {
                       bnif = true;
                    }
                    if (qName.equalsIgnoreCase("nombre")) {
                        bNombre = true;
                    }
                    if (qName.equalsIgnoreCase("apellidos")) {
                    	bApellidos = true;
                    }

                    if (qName.equalsIgnoreCase("salario")) {
                    	bSalario = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("finaliza elemento:" + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                	if (bnif) {
                        System.out.println("nif: " + new String(ch, start, length));
                        bnif = false;
                    }
                    if (bNombre) {
                        System.out.println("nombre: " + new String(ch, start, length));
                        bNombre = false;
                    }

                    if (bApellidos) {
                        System.out.println("apellidos: " + new String(ch, start, length));
                        bApellidos = false;
                    }

                    if (bSalario) {
                        System.out.println("salario: " + new String(ch, start, length));
                        bSalario = false;
                    }
                }

            };

            File file = new File("src/Empleados.xml");
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            saxParser.parse(is, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}