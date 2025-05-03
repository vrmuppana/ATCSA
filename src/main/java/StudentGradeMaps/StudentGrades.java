package StudentGradeMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StudentGrades {

	public StudentGrades() {

	}

//	public StudentMaps.StudentGrades(File file) {
//		
//	}

	/**
	 * Prints the options menu and returns the letter that the user types does not
	 * check for invalid selection
	 * 
	 * @return the next token on the input stream
	 * @throws IOException
	 */
	public static String printMenuAndGetChoice() throws IOException {

		System.out.println(
				"Choose one of the options below:\nA)dd student\nR)emove student\nM)odify grade\nP)rint all grades\nS)ave data\nQ)uit");
//		String str = "Choose one of the options below:\nA)dd student\nR)emove student\nM)odify grade\nP)rint all grades";
		String str = "";
		Map<Integer, Student> idToStudentMap = new HashMap<Integer, Student>();
		Map<Student, String> studentToGradeMap = new HashMap<Student, String>();

		Scanner s = new Scanner(System.in);
		String input = "";
		String allowed = "ARMPQS ";

		while (!input.equals("Q")) {
			input = s.nextLine().toUpperCase();
			if (input.equals("Q")) {
				break;
			}
			if (!allowed.contains(input)) {
				System.out.println("Try again. Not a valid input\n");
//				input = "";
			}
			if (input.equals("A")) {
				addStudent(studentToGradeMap, idToStudentMap);
			}
			if (input.equals("R")) {
				removeStudent(studentToGradeMap, idToStudentMap);
			}
			if (input.equals("M")) {
				modifyStudent(studentToGradeMap, idToStudentMap);
			}
			if (input.equals("P")) {
				printGrades2(studentToGradeMap);
			}
			if (input.equals("S")) {
				saveData(studentToGradeMap);
			}
			System.out.println(
					"Choose one of the options below:\nA)dd student\nR)emove student\nM)odify grade\nP)rint all grades\nS)ave data\nQ)uit");
		}
		System.out.println("Quit");
		return str;
	}

	public static void saveData(Map<Student, String> map) throws IOException {
		File newFile = new File("src/StudentGradeMaps/students.dat");
		FileWriter writer = new FileWriter(newFile);
		for (Student x : map.keySet()) {
			writer.write(x.getFirstName() + " " + x.getLastName() + " " + x.getID() + " " + map.get(x)+"\n");
		}
		writer.close();
//		Scanner sc = new Scanner(newFile);
//		while (sc.hasNext()) {
//			System.out.println(sc.nextLine());
//		}
	}
	
	public static void getData(File file, Map<Integer, Student> idToStudentMap, Map<Student, String> studentToGradeMap) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		while(sc.hasNext()) {
			String[] arr = sc.nextLine().split(" ");
			
			
		}
	}

	/**
	 * Prints the students and grades
	 * 
	 * @param gradeMap the map to print
	 */
	public static void printGrades(Map<String, String> gradeMap) {
		System.out.println("\nStudents - Grade");

		for (String x : gradeMap.keySet()) { // doesnt get in
			System.out.println(x + ": " + gradeMap.get(x));
		}
		System.out.println("\n");
	}

	/**
	 * Modifies an entry based on user input. Prints an error if an invalid student
	 * is modified
	 * 
	 * @param gradeMap the map to modify
	 */
	public static void modifyStudent(Map<String, String> gradeMap) {
		System.out.println("Enter student name:");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String allowed = "A+A-B+B-C+C-D+D-F+F-";

		if (!gradeMap.containsKey(str))
			System.out.println("Error, does not contain student");
		else {
			System.out.println("StudentMaps.Student grade: ");
			String str2 = s.nextLine();
			if (!allowed.contains(str2.toUpperCase())) {
				System.out.println("Error, put a valid input\n");
				return;
			}
			gradeMap.put(str, str2.toUpperCase());
		}
	}

	/**
	 * Removes a student from the map based on user input
	 * 
	 * @param gradeMap the map to remove the student from
	 */
	public static void removeStudent(Map<String, String> gradeMap) {
		System.out.println("Enter student name:");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();

		if (!gradeMap.containsKey(str))
			System.out.println("Error, does not contain student");
		else
			gradeMap.remove(str);
	}

	/**
	 * Adds a student based on user input. Prints an error if a student is added
	 * that already exists in the map.
	 * 
	 * @param gradeMap the map to add the student to
	 */
	public static void addStudent(Map<String, String> gradeMap) {
		String allowed = "A+A-B+B-C+C-D+D-F+F-";
		System.out.println("Enter student name:");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();

		for (String x : gradeMap.keySet()) {
			if (x.equalsIgnoreCase(str)) {
				System.out.println("Error, already contains\n");
				return;
			}
		}

		System.out.println("StudentMaps.Student grade: ");
		String str2 = s.nextLine();
		if (!allowed.contains(str2.toUpperCase())) {
			System.out.println("Error, put a valid input\n");
			return;
		}
		gradeMap.put(str, str2.toUpperCase());
	}

	// -----------------------------------------

	public static void printGrades2(Map<Student, String> studentToGradeMap) {
//		System.out.println("Stu to grade"+studentToGradeMap);

		System.out.println("\nStudents - Grade");
		for (Student x : studentToGradeMap.keySet()) {
//			System.out.println("test:: Stu to grade"+studentToGradeMap);
//			System.out.println("test:: stu:"+ x);
//			System.out.println("test:: map:"+studentToGradeMap.get(x));
			System.out.println(x + ": " + studentToGradeMap.get(x));
		}
		System.out.println("\n");
	}

	public static void addStudent(Map<Student, String> studentToGradeMap, Map<Integer, Student> idToStudentMap) {
		String allowed = "A+A-B+B-C+C-D+D-F+F-";
		System.out.println("Enter student first name:");
		Scanner s = new Scanner(System.in);
		String first = s.nextLine();
		System.out.println("Enter student last name:");
		String last = s.nextLine();
		System.out.println("Enter student ID:");
		int id = s.nextInt();

		Scanner m = new Scanner(System.in);
		System.out.println("StudentMaps.Student grade: ");
		String grade = m.nextLine();
		if (!allowed.contains(grade.toUpperCase())) {
			System.out.println("Error, put a valid input\n");
			return;
		}
		Student st = new Student(first, last, id);
		idToStudentMap.put(id, st);
		studentToGradeMap.put(st, grade);
//		System.out.println(studentToGradeMap);
//		System.out.println(idToStudentMap);
	}

	public static void modifyStudent(Map<Student, String> studentToGradeMap, Map<Integer, Student> idToStudentMap) {
		System.out.println("Enter student ID:");
		Scanner s = new Scanner(System.in);
		Integer in = s.nextInt();
		String allowed = "A+A-B+B-C+C-D+D-F+F-";

		if (!idToStudentMap.containsKey(in))
			System.out.println("Error, does not contain student");
		else {
			System.out.println("StudentMaps.Student grade: ");
			String str2 = s.nextLine();
			if (!allowed.contains(str2.toUpperCase())) {
				System.out.println("Error, put a valid input\n");
				return;
			}
			studentToGradeMap.put(idToStudentMap.get(in), str2);
		}
	}

	public static void removeStudent(Map<Student, String> studentToGradeMap, Map<Integer, Student> idToStudentMap) {
		System.out.println("Enter student name:");
		Scanner s = new Scanner(System.in);
		Integer in = s.nextInt();

		if (!idToStudentMap.containsKey(in))
			System.out.println("Error, does not contain student");
		else
			studentToGradeMap.remove(idToStudentMap.get(in));
		idToStudentMap.remove(in);
	}

	// -----------------------------------------

}
