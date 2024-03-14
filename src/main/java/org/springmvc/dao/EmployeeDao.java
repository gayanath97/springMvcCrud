package org.springmvc.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springmvc.entity.Employee;

public class EmployeeDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Employee emp) {
        String sql="insert into Emp(id,name,salary,designation) values('"+emp.getId()+"','"+emp.getName()+"',"+emp.getSalary()+",'"+emp.getDesignation()+"')";
        return template.update(sql);
    }

    public List<Employee> getEmployees() {
        return template.query("select * from Emp",new RowMapper<Employee>(){
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee e=new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setSalary(rs.getFloat(3));
                e.setDesignation(rs.getString(4));
                return e;
            }
        });
    }

    public Employee getEmpById(int id) {
        String sql="select * from Emp where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public int update(Employee emp) {
        String sql="update Emp set name='"+emp.getName()+"', salary="+emp.getSalary()+",designation='"+emp.getDesignation()+"' where id="+emp.getId()+"";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql="delete from Emp where id="+id+"";
        return template.update(sql);
    }
}
