/**
 * @author Tania
 * @date 30 nov. 2018
 * @version 1.0
 * @description Program that allows CRUD for a MongoDB
 * 
 */


package pevalmongo;

import java.util.Scanner;


/**
 * Class Main
 */
public class Main {
	/**
	 * @variable_name subjectName
	 * @type String
	 */
	static String subjectName = "";
	/**
	 * @variable_name studentName
	 * @type String
	 */
	static String studentName = "";
	/**
	 * Method to run the program
	 * @name main
	 * @param args 
	 */
	public static void main(String[] args) {
		MongoDB mongoDB = new MongoDB();
		mongoDB.createCollections();
		mongoDB.queryCollections();
		menu(mongoDB);
	}
	
	/**
	 * Method to display and select menu options
	 * @name menu
	 * @param mongoDB 
	 */
	public static void menu(MongoDB mongoDB) {
		String option = "";

		do {
			Scanner kb = new Scanner(System.in);
			
			System.out.println("\n1......Insertar calificaciones");
			System.out.println("2......Consultar calificaciones");
			System.out.println("3......Actualizar calificaciones");
			System.out.println("4......Eliminar calificaciones");	
			System.out.println("5......Salir");
			System.out.print("\nTeclea una opción:");
			
			option = kb.nextLine();			
			
			switch(option) {
				case "1":
					fillData(kb);
					mongoDB.insertMarks(subjectName, studentName);
					option = "correct";
					break;
				case "2":
					String[] operators = { "=", ">", "<", ">=", "<=", "!=" };
					String operator;
					boolean isValid = false;
					String value;
					
					do {
						System.out.println("Introduzca el nombre de la asignatura: ");
						subjectName = kb.nextLine();	
						
						if (subjectName.equals("")) {
							System.err.println("Error. El nombre no puede estar vacío");
						}
					} while(subjectName.equals(""));
					
					do {
						System.out.println("Introduzca un operador: ");
						System.out.println("(Operadores admitidos: =, >, <, >=, <=, !=)");
						operator = kb.nextLine();
						
						for (int i = 0; i < operators.length; i++) {
							if(operators[i].equals(operator)) {
								isValid = true;
							}
						}
						
						if(isValid == false) {
							System.err.println("Error. No ha introducido un operador correcto");
						}
					} while (isValid == false);
					
					do {
						System.out.println("Introduzca un valor: ");
						value = kb.nextLine();
						
						if(!mongoDB.tryParseInt(value)) {
							System.err.println("Error. No ha introducido un número");
						}
					} while(!mongoDB.tryParseInt(value));
					
					mongoDB.queryMarks(subjectName, operator, Integer.parseInt(value));
					option = "correct";
					break;
				case "3":
					fillData(kb);
					mongoDB.updateMarks(subjectName, studentName);
					option = "correct";
					break;
				case "4":
					fillData(kb);
					mongoDB.deleteMarks(subjectName, studentName);
					option = "correct";
					break;	
				case "5":
					option = "correct";
					System.exit(0); 
					break;
			}
			
			if(!option.equals("correct")) {
				System.err.println("Error. no ha seleccionado una opción válida.");
			}
			
		} while (!option.equals("5"));
	}
	
	/**
	 * Method to insert data by typing
	 * @name fillData
	 * @param kb 
	 */
	static void fillData(Scanner kb) {
		do {
			System.out.println("Introduzca el nombre de la asignatura: ");
			subjectName = kb.nextLine();	
			
			if (subjectName.equals("")) {
				System.err.println("Error. El nombre no puede estar vacío");
			}
		}while(subjectName.equals(""));
		
		do {
				System.out.println("Introduzca el nombre del alumno: ");
				studentName = kb.nextLine();	
				
				if (studentName.equals("")) {
					System.err.println("Error. El nombre no puede estar vacío");
				}
		} while(studentName.equals(""));
	}
}
