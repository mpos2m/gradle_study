package gradle_study.dao;

import java.util.List;

import gradle_study.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	Department selectDepartmentBydeptNo(Department dept);
	
	int insertDepartment(Department dept);
	int updateDepartment(Department dept);
	int deleteDepartment(int dept);
	int deleteDepartment(Department dept);
	
}
