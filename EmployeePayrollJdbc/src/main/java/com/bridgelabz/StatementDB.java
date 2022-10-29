package com.bridgelabz;

import java.sql.*;
import java.util.*;

public class StatementDB {
	final static String FETCH_DB = "SELECT e.id, e.name, e.start_date, e.gender,"
			+ "	e.phone, e.address, d.department, p.salary, p. basic_pay, p.deductions,"
			+ "	p.taxable_pay, p.income_tax, p.net_pay FROM employee_payroll e LEFT JOIN department d"
			+ "	ON e.id = d.employee_id LEFT JOIN payroll p ON p.id = e.id";
	final static String UPDATE_DB = "UPDATE payroll SET Salary = 3000000 WHERE name = 'Terissa'";
	final static String SELECT_UPDATE = "SELECT Salary FROM payroll WHERE name = 'Terissa'";
	Connection connection;

	public StatementDB(Connection connection) {
		this.connection = connection;
	}

	public void read() {

		ArrayList<EmployeePayroll> db = EmployeeDB.getEmployeeDB();
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery(FETCH_DB);

			while (result.next()) {
				EmployeePayroll e = new EmployeePayroll(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getInt(5), result.getString(6), result.getString(7),
						result.getDouble(8), result.getDouble(9), result.getDouble(10), result.getDouble(11),
						result.getDouble(12), result.getDouble(13));
				db.add(e);
				System.out.println(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update() {

		ArrayList<EmployeePayroll> db = EmployeeDB.getEmployeeDB();
		Statement statement = null;

		try {
			statement = connection.createStatement();
			statement.execute(UPDATE_DB);

			for (EmployeePayroll employeePayroll : db) {
				if (employeePayroll.getName().equals("Terissa")) {
					employeePayroll.setSalary(3000000);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
