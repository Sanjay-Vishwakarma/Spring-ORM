package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student student = new Student(123,"rajiv","mumbai");
		 * 
		 * int r = studentDao.insert(student);
		 * 
		 * System.out.println("afected row...."+r);
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		boolean go = true;
		while (go) {

			System.out.println("PRESS 1 FOR ADD STUDENT");
			System.out.println("PRESS 2 FOR GET SINGLE STUDENT");
			System.out.println("PRESS 3 FOR GET ALL STUDENT");
			System.out.println("PRESS 4 FOR DELETE  STUDENT");
			System.out.println("PRESS 5 FOR UPDATE STUDENT");
			System.out.println("PRESS 6 FOR EXIT :\t");

			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// add student
					if (input == 1) {
						System.out.print("name:");
						String name = sc.next();
						System.out.print("city:");
						String city = sc.next();
						Student std = new Student();
						std.setName(name);
						std.setCity(city);

						int insert = studentDao.insert(std);
						System.out.println("done.." + insert);
					}

					break;

				case 2:
					// get single student

					System.out.print("Enter id get details: ");
					int id = sc.nextInt();
					Student student = studentDao.getStudent(id);
					System.out.println(student.getId() + " " + student.getName() + " " + student.getCity());

					break;

				case 3:

					// get all student
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st : allStudents) {
						System.out.println(
								"This is student : " + st.getId() + " " + st.getName() + " " + st.getCity() + "\n");
					}

				case 4:
					// delete student
					if(input==4)
					{
						System.out.print("Enter id for delete : ");
						int idD = sc.nextInt();
						studentDao.deleteStudent(idD);
						System.out.println("deleted sucessfully ..." + idD);

					}
					break;

				case 5:
					// update student
					System.out.print("enter id :");
					int idDu = sc.nextInt();
					System.out.print("name:");
					String name = sc.next();
					System.out.print("city:");
					String city = sc.next();
					Student std = new Student();
					std.setId(idDu);
					std.setName(name);
					std.setCity(city);

					studentDao.updateStudent(std);
					System.out.println("updated successfuly..");
					break;

				case 6:
//					System.exit(0);
					go = false;
					System.out.println("Thank you");

					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		}

	}
}
