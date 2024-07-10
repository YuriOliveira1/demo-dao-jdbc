package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.DB;
import database.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    public SellerDaoJDBC() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void insert(Seller seller) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Seller seller) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*, department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE seller.Id = ? ");

            st.setInt(1, id);
            rs = st.executeQuery();
            
            if (rs.next()) {
                Department dep = instantiateDeparment(rs);
                Seller objSeller = instantiateSeller(rs, dep);
                return objSeller;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller objSeller = new Seller();
        objSeller.setId(rs.getInt("Id"));
        objSeller.setName(rs.getString("Name"));
        objSeller.setEmail(rs.getString("Email"));
        objSeller.setBaseSalary(rs.getDouble("BaseSalary"));
        objSeller.setBirthDate(rs.getDate("BirthDate"));
        objSeller.setDepartment(dep);

        return objSeller;
    }

    private Department instantiateDeparment(ResultSet rs) throws SQLException {
        Department dep = new Department();

        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));

        return dep;
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
