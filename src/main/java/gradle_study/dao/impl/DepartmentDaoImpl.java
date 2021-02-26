package gradle_study.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gradle_study.dao.DepartmentDao;
import gradle_study.dto.Department;
import gradle_study.util.JdbcUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	
	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();

	public static DepartmentDaoImpl getInstance() {
		
		return instance;
	}
	
	private DepartmentDaoImpl() {
		
	}

	@Override
	public List<Department> selectDepartmentByAll() {
		String sql = "select deptNo,deptName,floor from department";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Department> list = new ArrayList<>();
				do {
					list.add(getDepartment(rs));
				}while(rs.next());
				return list;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("deptno");
		String deptName = rs.getString("deptname");
		int floor = rs.getInt("floor");
		
		return new Department(deptNo,deptName,floor);
	}

	@Override
	public Department selectDepartmentBydeptNo(Department dept) {
		String sql = "select deptNo,deptName,floor from department where deptNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, dept.getDeptNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getDepartment(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertDepartment(Department dept) {
		String sql = "insert into department values(?,?,?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.setString(2, dept.getDeptName());
			pstmt.setInt(3, dept.getFloor());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateDepartment(Department dept) {
		String sql = "update department set deptName = ? where deptNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, dept.getDeptName());
			pstmt.setInt(2, dept.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDepartment(int deptNo) {
		String sql = "delete from department where deptNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, deptNo);;
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDepartment(Department dept) {
		// TODO Auto-generated method stub
		return 0;
	}

}
