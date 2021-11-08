package practica_6;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Empleado extends DefaultHandler {
	String nif, nombre, apellidos;
	double salario;

	Empleado() {
		super();
	}

	Empleado(String nif, String nombre, String apellidos, double salario) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;

	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String toString() {
		return "nif: " + nif + "\n Nombre: " + nombre + "\n Apellidos: " + apellidos + "\n Salario: " + salario + "\n";
	}

	// SAX
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("Inicio del documento");
	}

	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("Fin del documento");
	}

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		super.startElement(uri, localName, qName, atts);
		System.out.println("\t Inicio del Elemento" + localName);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("\t Fin del Elemento" + localName);
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String car = new String(ch, start, length);
		car.replace("[\t\n]", "");
		System.out.println("\t Valor del Elemento " + car);

	}
}
