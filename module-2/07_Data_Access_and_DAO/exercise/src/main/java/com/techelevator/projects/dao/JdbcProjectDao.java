package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date FROM project WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		while(results.next()){
			project = mapRowToProject(results);
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> allProjects = new ArrayList<Project>();

		String sql = "SELECT project_id, name, from_date, to_date FROM project";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()){
			allProjects.add(mapRowToProject(results));
		}

		return allProjects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) " +
				"VALUES(?, ?, ?) RETURNING project_id";
		int projectId = jdbcTemplate.queryForObject(sql, Integer.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		newProject.setId(projectId);

		return newProject;
	}

	@Override
	public void deleteProject(int projectId) {

		List<Integer> employeesOnProject = getProjectEmployee(projectId);

		for(int employeeId : employeesOnProject){
			removeProjectFromProjectEmployee(projectId, employeeId);
		}


		String sql = "DELETE FROM project WHERE project_id = ?";
		jdbcTemplate.update(sql, projectId);

	}

	private List<Integer> getProjectEmployee(int projectId) {
		List<Integer> employees = new ArrayList<Integer>();

		String sql = "SELECT employee_id FROM project_employee " +
				"JOIN project ON project_employee.project_id = project.project_id " +
				"WHERE project.project_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		while (results.next()){
			employees.add(results.getInt("employee_id"));
		}

		return employees;
	}

	private void removeProjectFromProjectEmployee(int projectId, int employeeId){
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";

		jdbcTemplate.update(sql, projectId, employeeId);

	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getInt("project_id"));
		project.setName(rowSet.getString("name"));
		if(rowSet.getDate("from_date") != null) {
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if(rowSet.getDate("to_date") != null) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}

		return project;
	}
	

}
