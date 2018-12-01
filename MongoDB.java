/**
 * @author Tania
 * @date 30 nov. 2018
 * @version 1.0
 * @description Mongo Class that manage DB operations
 * 
 */

package pevalmongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.*;

/**
 * Class MongoDB
 */
public class MongoDB {
	/**
	 * @variable_name mongo
	 * @type MongoClient
	 */
	MongoClient mongo;
	/**
	 * @variable_name db
	 * @type DB
	 */
	DB database;
	/**
	 * @variable_name group
	 * @type DBCollection
	 */
	DBCollection group;
	/**
	 * @variable_name students
	 * @type DBCollection
	 */
	DBCollection students;
	/**
	 * @variable_name subjects
	 * @type DBCollection
	 */
	DBCollection subjects;
	/**
	 * @variable_name marks
	 * @type DBCollection
	 */
	DBCollection marks;

	/**
	 * Class MongoDB Constructor
	 */
	public MongoDB() {
		try {
			mongo = new MongoClient("localhost", 27017);
			List<String> dbs = mongo.getDatabaseNames();

			for (int i = 0; i < dbs.size(); i++) {
				if (dbs.get(i).equals("lopez")) {
					mongo.getDB("lopez").dropDatabase();
				}
			}
			database = mongo.getDB("lopez");
			System.out.println(mongo.getDatabaseNames());

		} catch (UnknownHostException e) {
			System.err.println("Error de conexión");
			// e.printStackTrace();
		}
	}

	/**
	 * Method to create collections
	 * 
	 * @name createCollections
	 */
	public void createCollections() {
		group = database.getCollection("CURSO");
		students = database.getCollection("ALUMNOS");
		subjects = database.getCollection("ASIGNATURAS");
		marks = database.getCollection("CALIFICACIONES");
		fillCollections();
	}

	/**
	 * Method to fill collections
	 * 
	 * @name fillCollections
	 */
	public void fillCollections() {
		BasicDBObject document1 = new BasicDBObject();
		document1.put("Cod_Curso", 1);
		document1.put("Descripcion", "1ºDAM");
		group.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Curso", 2);
		document1.put("Descripcion", "2ºDAM");
		group.insert(document1);

		document1 = new BasicDBObject();
		document1.put("DNI", "55555555E");
		document1.put("Nombre", "María");
		document1.put("Apellidos", "Ávila");
		document1.put("Cod_Curso", 1);
		students.insert(document1);
		document1 = new BasicDBObject();
		document1.put("DNI", "11111111A");
		document1.put("Nombre", "Roberto");
		document1.put("Apellidos", "Rodríguez");
		document1.put("Cod_Curso", 2);
		students.insert(document1);
		document1 = new BasicDBObject();
		document1.put("DNI", "22222222B");
		document1.put("Nombre", "Susana");
		document1.put("Apellidos", "Fernández");
		document1.put("Cod_Curso", 1);
		students.insert(document1);
		document1 = new BasicDBObject();
		document1.put("DNI", "33333333C");
		document1.put("Nombre", "Elías");
		document1.put("Apellidos", "Trigo");
		document1.put("Cod_Curso", 1);
		students.insert(document1);
		document1 = new BasicDBObject();
		document1.put("DNI", "44444444D");
		document1.put("Nombre", "Amaia");
		document1.put("Apellidos", "Santaella");
		document1.put("Cod_Curso", 2);
		students.insert(document1);

		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 1);
		document1.put("Descripcion", "ENDE");
		document1.put("Cod_Curso", 1);
		subjects.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 2);
		document1.put("Descripcion", "BADA");
		document1.put("Cod_Curso", 1);
		subjects.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 3);
		document1.put("Descripcion", "DEIN");
		document1.put("Cod_Curso", 2);
		subjects.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 4);
		document1.put("Descripcion", "PRSP");
		document1.put("Cod_Curso", 2);
		subjects.insert(document1);

		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 1);
		document1.put("DNI", "55555555E");
		document1.put("Calificacion", 5);
		marks.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 1);
		document1.put("DNI", "22222222B");
		document1.put("Calificacion", 6);
		marks.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 1);
		document1.put("DNI", "33333333C");
		document1.put("Calificacion", 7);
		marks.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 2);
		document1.put("DNI", "33333333C");
		document1.put("Calificacion", 3);
		marks.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 2);
		document1.put("DNI", "55555555E");
		document1.put("Calificacion", 8);
		marks.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 2);
		document1.put("DNI", "22222222B");
		document1.put("Calificacion", 10);
		marks.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 3);
		document1.put("DNI", "11111111A");
		document1.put("Calificacion", 8);
		marks.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 3);
		document1.put("DNI", "44444444D");
		document1.put("Calificacion", 9);
		marks.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 4);
		document1.put("DNI", "11111111A");
		document1.put("Calificacion", 4);
		marks.insert(document1);
		document1 = new BasicDBObject();
		document1.put("Cod_Asig", 4);
		document1.put("DNI", "44444444D");
		document1.put("Calificacion", 5);
		marks.insert(document1);
	}

	/**
	 * Method to query collections
	 * 
	 * @name queryCollections
	 */
	public void queryCollections() {
		System.out.println("" + database.getCollectionNames());
	}

	/**
	 * Method to query documents in CALIFICACIONES collection
	 * 
	 * @name queryMarks
	 * @param description
	 * @param operator
	 * @param value
	 */
	public void queryMarks(String description, String operator, int value) {
		boolean validOperator = false;
		int subjectCode = 0;
		String dni = "";
		BasicDBObject query = new BasicDBObject();
		query.put("Descripcion", description);
		DBCursor cur = subjects.find(query);

		while (cur.hasNext()) {
			subjectCode = (int) cur.next().get("Cod_Asig");
		}

		cur.close();
		BasicDBObject queryMark = new BasicDBObject();

		switch (operator) {
		case "=":
			queryMark.put("Calificacion", new BasicDBObject("$eq", value));
			break;
		case ">":
			queryMark.put("Calificacion", new BasicDBObject("$gt", value));
			break;
		case ">=":
			queryMark.put("Calificacion", new BasicDBObject("$gte", value));
			break;
		case "<=":
			queryMark.put("Calificacion", new BasicDBObject("$lte", value));
			break;
		case "<":
			queryMark.put("Calificacion", new BasicDBObject("$lt", value));
			break;
		case "!=":
			queryMark.put("Calificacion", new BasicDBObject("$ne", value));
			break;
		}

		queryMark.put("Cod_Asig", subjectCode);
		cur = marks.find(queryMark);
		if (!cur.hasNext()) {
			System.err.println("No existen documentos con esas características.");
		} else {
			printHeader();

			while (cur.hasNext()) {
				System.out.printf("%15s", description);
				dni = cur.next().get("DNI").toString();
				BasicDBObject query2 = new BasicDBObject();
				query2.put("DNI", dni);
				DBCursor cur2 = students.find(query2);

				while (cur2.hasNext()) {
					System.out.printf("%15s", cur2.next().get("Nombre").toString());
				}

				cur2.close();
				System.out.printf("%15s", cur.curr().get("Calificacion").toString() + "\n");
			}

			cur.close();
		}
	}

	/**
	 * Method to update documents in CALIFICACIONES collection
	 * 
	 * @name updateMarks
	 * @param description
	 * @param name
	 */
	public void updateMarks(String description, String name) {
		int subjectCode = 0;
		String mark = "";
		ArrayList<String> dni = new ArrayList<>();
		BasicDBObject query = new BasicDBObject();
		query.put("Descripcion", description);
		DBCursor cur = subjects.find(query);

		while (cur.hasNext()) {
			subjectCode = (int) cur.next().get("Cod_Asig");
		}

		cur.close();
		query = new BasicDBObject();
		query.put("Nombre", name);
		cur = students.find(query);

		while (cur.hasNext()) {
			dni.add(cur.next().get("DNI").toString());
		}

		cur.close();

		if (dni.size() == 0) {
			System.err.println("No se ha encontrado el alumno en la base de datos");
			System.err.flush();
		} else {
			boolean isNumber = false;
			Scanner kb = new Scanner(System.in);
			do {
				System.out.println("Introduzca la nueva nota: ");
				mark = kb.nextLine();
				
				if(tryParseInt(mark) == true) {
					if (Integer.parseInt(mark) < 1 || Integer.parseInt(mark) > 10) {
						System.err.println("Error. La nota debe estar entre 1 y 10");
						System.err.flush();
						mark = "";
					}								
				} else {
					System.err.println("Error. Debe introducir un número entero");
				}

			} while (tryParseInt(mark) == false);

			BasicDBObject update = new BasicDBObject();
			update.append("$set", new BasicDBObject().append("Calificacion", Integer.parseInt(mark)));

			for (int i = 0; i < dni.size(); i++) {
				query = new BasicDBObject();
				query.append("DNI", dni.get(i));
				query.append("Cod_Asig", subjectCode);
				cur = marks.find(query);

				if (cur.hasNext()) {
					marks.updateMulti(query, update);
					System.out.println("Se ha actualizado correctamente el documento de la base de datos");
				} else {
					System.err.println("Error. No existen documentos con los datos introducidos");
					System.err.println("No se ha actualizado ningún documento");
					System.err.flush();
				}

				cur.close();
			}

		}
	}

	/**
	 * Method to delete documents in CALIFICACIONES collection
	 * 
	 * @name deleteMarks
	 * @param description
	 * @param name
	 */
	public void deleteMarks(String description, String name) {
		int subjectCode = 0;
		ArrayList<String> dni = new ArrayList<>();
		BasicDBObject query = new BasicDBObject();
		query.put("Descripcion", description);
		DBCursor cur = subjects.find(query);

		while (cur.hasNext()) {
			subjectCode = (int) cur.next().get("Cod_Asig");
		}

		cur.close();
		query = new BasicDBObject();
		query.put("Nombre", name);
		cur = students.find(query);

		while (cur.hasNext()) {
			dni.add(cur.next().get("DNI").toString());
		}

		cur.close();
		if (dni.size() == 0) {
			System.err.println("Error. No existen documentos con los datos introducidos");
			System.err.println("No se ha borrado ningún documento");
			System.err.flush();
		} else {
			for (int i = 0; i < dni.size(); i++) {
				query = new BasicDBObject();
				query.append("DNI", dni.get(i));
				query.append("Cod_Asig", subjectCode);
				cur = marks.find(query);

				if (cur.hasNext()) {
					marks.remove(query);
					System.out.println("Se ha borrado correctamente el documento de la base de datos");
				} else {
					System.err.println("Error. No existen documentos con los datos introducidos");
					System.err.println("No se ha borrado ningún documento");
					System.err.flush();
				}

				cur.close();
			}
		}
	}

	/**
	 * Method to insert documents in CALIFICACIONES collection
	 * 
	 * @name insertMarks
	 * @param description
	 * @param name
	 */
	public void insertMarks(String description, String name) {
		int subjectCode = 0;
		boolean validSubject = false;
		String mark = "";
		ArrayList<String> dni = new ArrayList<>();
		BasicDBObject query = new BasicDBObject();
		query.put("Descripcion", description);
		DBCursor cur = subjects.find(query);

		while (cur.hasNext()) {
			subjectCode = (int) cur.next().get("Cod_Asig");
			validSubject = true;
		}

		cur.close();
		query = new BasicDBObject();
		query.put("Nombre", name);
		cur = students.find(query);

		while (cur.hasNext()) {
			dni.add(cur.next().get("DNI").toString());
		}

		cur.close();
		if (dni.size() == 0) {
			System.err.println("No se ha podido insertar porque no existe ningún alumno con ese nombre");
		} else {
			for (int i = 0; i < dni.size(); i++) {
				query = new BasicDBObject();
				query.append("DNI", dni.get(i));
				query.append("Cod_Asig", subjectCode);
				cur = marks.find(query);

				if (cur.hasNext()) {
					System.err.println(
							"No se ha podido insertar porque ya existe ese alumno con una nota en esa asignatura");
				} else {
					cur.close();
					if (validSubject == false) {
						System.err
								.println("No se ha podido insertar porque la asignatura no existe en la base de datos");
					} else {
						Scanner kb = new Scanner(System.in);
						do {
							System.out.println("Introduzca la nota: ");
							mark = kb.nextLine();
							
							if(tryParseInt(mark) == true) {
								if (Integer.parseInt(mark) < 1 || Integer.parseInt(mark) > 10) {
									System.err.println("Error. La nota debe estar entre 1 y 10");
									mark = "";
								}								
							} else {
								System.err.println("Error. Debe introducir un número entero");
							}

						} while (tryParseInt(mark) == false);

						query.append("Calificacion", Integer.parseInt(mark));
						marks.insert(query);
						System.out.println("Se ha insertado el documento correctamente");
					}
				}
			}
		}
	}

	/**
	 * Method to print a header for queries
	 * 
	 * @name printHeader
	 */
	public void printHeader() {
		System.out.printf("%15s%15s%15s", "Descripción", "Nombre", "Calificación\n");
	}

	/**
	 * Method that returns true if ParseInt works and false if not
	 * 
	 * @name tryParseInt
	 * @param value
	 * @return
	 */
	public boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			// e.printStackTrace();
			return false;
		}
	}
}
