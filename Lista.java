package practica_6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Lista {

	File fichero;
	ArrayList<Empleado> lista_Empleados;

	// CONSTRUCTORES

	Lista() throws IOException {
		this.fichero = new File("src/", "Empleados.xml");
		this.lista_Empleados = new ArrayList<Empleado>();
	}

	// METODOS GET/SET
	public ArrayList<Empleado> getLista_Empleados() {
		return lista_Empleados;
	}

	public void setLista_Empleados(ArrayList<Empleado> lista_Empleados) {
		this.lista_Empleados = lista_Empleados;
	}

	// METODOS IMPLEMENTADOS
	// ESCRIBIR EN FICHERO LA LISTA (IMPRIMIR)
	public void escribirEmpleado() throws IOException {
			

	}

	// LEER ARCHIVO
	public void consultarEnLista(String nif) {
		
	}

	public void conultar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado CONSULTAR, introduce el NIF del mepleado que desee consultar: ");
		String nif = entrada.next();

		try {
			if (validarNif(nif) == true && existeEmpleado(nif) == true) {

				System.out.println("Se esta buscando al empleado... \n");
				consultarEnLista(nif);
			} else if (validarNif(nif) == false) {
				System.err.println(
						"Por favor, introduce un NIF con 8 dígitos y una letra");
			} else if (existeEmpleado(nif) == false) {
				System.err.println("No existe el empleado con NIF: " + nif);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// LISTAR LOS EMPLEADOS
	public void listar() throws IOException {
		String todo = "";
		for(int i =0; i<lista_Empleados.size(); i++) {
			todo = todo +lista_Empleados.get(i).toString();
		}
		System.out.println(todo);

	}

	// VALIDAR EL NIF QUE TE DA EL CLIENTE
	public boolean validarNif(String nif) throws Exception {

		boolean aux = false;
		try {
			Pattern pat = Pattern.compile("[0-9]{8,9}[A-Z a-z]");
			Matcher mat = pat.matcher(nif);
			if (mat.matches() == true) {
				aux = true;
			}
		} catch (Exception e) {
			System.err.println("Introduce 8 dígitos y una letra.");
		}
		return aux;

	}

	// VALIDAR EL NOMBRE Y APELLIDOS QUE TE DA EL CLIENTE
	public boolean validarNombre(String nombre) throws Exception {

		boolean aux = false;
		try {
			Pattern pat = Pattern.compile("[A-Z a-z]{0,10}");
			Matcher mat = pat.matcher(nombre);
			if (mat.matches() == true) {
				aux = true;
			}
		} catch (Exception e) {
			System.err.println("Introduce 10 cáracteres como máx.");
		}
		return aux;

	}

	// BUSCAR EMPLEADO EN LA LISTA
	public String buscarEmpleado(String nif) {
		Empleado aux = new Empleado();
		for (int i = 0; i < this.lista_Empleados.size(); i++) {
			if (nif.equals(this.lista_Empleados.get(i).nif)) {
				aux = this.lista_Empleados.get(i);
			}
		}
		return aux.toString();
	}

	// EXISTE EMPLEADO EN LA LISTA
	public boolean existeEmpleado(String nif) {
		boolean aux = false;
		for (int i = 0; i < this.lista_Empleados.size(); i++) {
			if (nif.equals(this.lista_Empleados.get(i).nif)) {
				aux = true;
			}
		}
		return aux;
	}

	// ANADIR A LA LISTA DE EMPLEADOS
	public void anadirEmpleado(Empleado worker) {
		lista_Empleados.add(worker);
		try {
			escribirEmpleado();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// HACER LA INSERCCION DEL NUEVO EMPLEADO
	public void inserccion() {
		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado INSERCCIÓN, introduce el NIF del empleado que desee insertar: ");
		String nif = entrada.next();

		try {
			if (validarNif(nif) == true && existeEmpleado(nif) == true) {
				System.out.println("Ya existe el empleado con NIF: " + nif);

			} else if (existeEmpleado(nif) == false) {
				System.out.println("Introduce el nombre: ");
				String nombre = entrada.next();
				if (validarNombre(nombre) == true) {
					System.out.println("Introduce los apellidos: ");
					String apellidos = entrada.next();
					if (validarNombre(apellidos) == true) {
						System.out.println("Introduce el salario: ");
						double salario = entrada.nextDouble();
						Empleado aux = new Empleado(nif, nombre, apellidos,
								salario);
						anadirEmpleado(aux);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ELIMINAR UN EMPLEADO
	public void eliminacion() {
		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado BORRADO, introduce el NIF del mepleado que desee borrar: ");
		String nif = entrada.next();

		try {
			if (validarNif(nif) == true && existeEmpleado(nif) == true) {
				borrar(nif);
			} else if (validarNif(nif) == false) {
				System.err.println(
						"Por favor, introduce un NIF con 8 dígitos y una letra");
			} else if (existeEmpleado(nif) == false) {
				System.err.println("No existe el empleado con NIF: " + nif);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// BORRAR EMPLEADO
	public void borrar(String nif) throws IOException {


	}

	// MODIFICACION UN EMPLEADO
	public void modificacion() {
		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado MODIFICAR, introduce el NIF del mepleado que desee modificar: ");
		String nif = entrada.next();

		try {
			if (validarNif(nif) == true && existeEmpleado(nif) == true) {
				modificar(nif);
			} else if (validarNif(nif) == false) {
				System.err.println(
						"Por favor, introduce un NIF con 8 dígitos y una letra");
			} else if (existeEmpleado(nif) == false) {
				System.err.println("No existe el empleado con NIF: " + nif);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// MODIFICAR EMPLEADO
	public void modificar(String nif) throws IOException {
	}
}
