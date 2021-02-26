package gradle_study.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gradle_study.dao.impl.DepartmentDaoImpl;
import gradle_study.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DepartmentDaoTest {

	private static DepartmentDao dao = DepartmentDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectDepartmentByAll() {
		System.err.printf("%s()%n", "testSelectDepartmentByAll");
		List<Department> deptList = dao.selectDepartmentByAll();
		Assert.assertNotNull(deptList);
		for (Department d : deptList) {
			System.out.println(d);
		}
	}

	@Test
	public void test05SelectDepartmentBydeptNo() {
		System.err.printf("%s()%n", "testSelectDepartmentBydeptNo");
		Department dept = new Department(2);
		Department serachDept = dao.selectDepartmentBydeptNo(dept);
		Assert.assertNotNull(serachDept);
		System.out.println(serachDept);
	}

	@Test
	public void test01InsertDepartment() {
		System.err.printf("%s()%n", "testInsertDepartment");
		Department newDept = new Department(5, "인사", 3);
		int res = dao.insertDepartment(newDept);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentBydeptNo(newDept));
	}

	@Test
	public void test02UpdateDepartment() {
		System.err.printf("%s()%n", "testUpdateTitle");
		Department newDept = new Department(1, "마케팅");
		int res = dao.updateDepartment(newDept);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentBydeptNo(newDept));
	}

	@Test
	public void test04DeleteDepartment() {
		System.err.printf("%s()%n", "testDeleteTitle");

		int res = dao.deleteDepartment(5);
		Assert.assertEquals(1, res);
		System.out.println("Delete Complete");
		dao.selectDepartmentByAll().stream().forEach(System.out::println);
	}

}
