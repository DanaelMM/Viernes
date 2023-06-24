package Ejercicios;

import java.util.Scanner;

public class CalculoNomina {
	
	private String nombre, puesto;
	private double hrT, hrE, sueldo, sueldoExtra;
	
	// Constructor
    public CalculoNomina(String nombre, String puesto, double hrT, double hrE, double sueldo, double sueldoExtra){
		setNombre(nombre);
		setPuesto(puesto);
		setHrTrab(hrT);
		setHrExt(hrE);
		setSueldo(sueldo);
		setSueldoExtra(sueldoExtra);
    }
 	
 	// Setters
	private void setNombre(String n) {
		nombre = n;
	}
	
	private void setPuesto(String p) {
		puesto = p;
	}
	
	public void setHrExt(double HE) {
		hrE = HE;
	}
	
	public void setHrTrab(double HT) {
		hrT = HT;
	}
	
	public void setSueldo(double s) {
		sueldo = s;
	}
	
	public void setSueldoExtra(double SE) {
		sueldoExtra = SE;
	}
	
	// Getters
	public double getSueldoBruto() {
		double sueldoBruto = (hrT * sueldo) + (hrE * sueldoExtra);
		return sueldoBruto;
	}
    
	public double calcularImpuestos() {
		double sueldoBruto = getSueldoBruto();
		
		if (sueldoBruto < 2000) {
			return sueldoBruto * 0.84;
		} else {
			return sueldoBruto * 0.82;
		}
	}
	
	public double getSueldoNeto() {
		double sueldoBruto = getSueldoBruto();
		double impuestos = calcularImpuestos();
		double sueldoNeto = sueldoBruto - impuestos;
		return sueldoNeto;
	}
	
	public void mostrarNomina() {
		System.out.println("\nNombre del empleado: " + nombre);
		System.out.println("Puesto: " + puesto);
		System.out.println("Sueldo bruto: $" + getSueldoBruto());
		System.out.println("Sueldo neto: $" + getSueldoNeto());
	}
    
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        
		System.out.println("Ingrese el nombre del empleado:");
		String nombre = entrada.nextLine();

		System.out.println("Ingrese el puesto del empleado:");
		String puesto = entrada.nextLine();

		System.out.println("Ingrese las horas trabajadas:");
		double hrT = entrada.nextDouble();

		System.out.println("Ingrese las horas extra:");
		double hrE = entrada.nextDouble();
        
		System.out.println("Ingrese el sueldo por hora:");
		double sueldo = entrada.nextDouble();

		System.out.println("Ingrese el sueldo extra por hora:");
		double sueldoExtra = entrada.nextDouble();
       
		// Create an instance of CalculoNomina
		CalculoNomina nomina = new CalculoNomina(nombre, puesto, hrT, hrE, sueldo, sueldoExtra);
		nomina.mostrarNomina();
		
		entrada.close(); // Close the scanner to release resources
	}
}

    
