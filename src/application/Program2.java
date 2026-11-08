package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Department> list = new ArrayList<>();
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: department findById ===");
		Department department = departmentDao.findById(6);
		System.out.println(department);
		
		System.out.println("=== TESTE 2: department findAll ===");
		list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TESTE 3: department insert ===");
		Department newDepartment = new Department(null, "Tintas");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		
		System.out.println("=== TESTE 4: department update ===");
		department = departmentDao.findById(4);
		department.setName("Thomas Turbano");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("=== TESTE 4: department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
