package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

    public void insert(Department dp);
    public void update(Department dp);
    public void deleteById(Integer id);
    public Department findById(Integer id);
    public List<Department> findAll();
}
