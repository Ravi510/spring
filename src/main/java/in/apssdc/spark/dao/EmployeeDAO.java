package in.apssdc.spark.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import in.apssdc.spark.security.model.Employee;

public class EmployeeDAO
{
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveEmployee(Employee e)
	{
		String query = "insert into test.employee(firstname,lastname,id) values('"
				+ e.getFirstName() + "','" + e.getLastName() + "','" + e.getEmployeeId() + "')";
		return jdbcTemplate.update(query);
	}

	public int updateEmployee(Employee e)
	{
		String query = "update test.employee set firstname='" + e.getFirstName() + "' , lastname='"
				+ e.getLastName() + "' where id='" + e.getEmployeeId() + "' ";
		return jdbcTemplate.update(query);
	}

	public int deleteEmployee(Employee e)
	{
		String query = "delete from test.employee where id='" + e.getEmployeeId() + "' ";
		return jdbcTemplate.update(query);
	}

	public List<Map<String, Object>> getAll()
	{
		String query = "select * from test.employee";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		System.out.println(rows);
		return rows;
	}

}