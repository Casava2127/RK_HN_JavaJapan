package ra.com.repository.imp;

import com.mysql.cj.protocol.Resultset;
import ra.com.entity.Categories;
import ra.com.util.ConnEcommerceDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class CategoriesRepositoryImp implements ra.com.repository.CategoriesRepository {
    @Override
    public List<Categories> findAll() {
        Connection conn = null; // khoi tao bien kieu Connection de luu tru ket noi csdl
        CallableStatement callStm = null; // khoi tao bien callStm kieu ... de goi procedure
        List<Categories> listCategories = null; // khoi tao bien listCategories de luu tru danh sach cac danh muc


        try{
            conn = ConnEcommerceDB.openConnection();
            callStm = conn.prepareCall("{call find_all_categories()}");// mo ket noi csdl
            ResultSet rs =  callStm.executeQuery();
            listCategories = new ArrayList<>();

            while (rs.next()) {
                Categories categories = new Categories();
                categories.setCatalogId(rs.getInt("catalog_id"));
                categories.setCatalogName(rs.getString("catalog_name"));
                categories.setDescription(rs.getString("catalog_description"));
                categories.setStatus(rs.getBoolean("catalog_status"));
                listCategories.add(categories);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnEcommerceDB.closeConnection(conn,callStm);
        }
        return listCategories;
    }
    @Override
    public boolean save(Categories catalog) {
        Connection conn = null;
        CallableStatement callStm = null;
        boolean result = false;
        try{
            conn = ConnEcommerceDB.openConnection();
            callStm = conn.prepareCall("call create_new_catalog(?,?,?)");
            callStm.setString(1, catalog.getCatalogName());
            callStm.setString(2,catalog.getDescription());
            callStm.setBoolean(3, catalog.isStatus());
            callStm.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnEcommerceDB.closeConnection(conn,callStm);
        }
        return false;
    }
    @Override
    public Categories findById(int catalogId){
        Connection conn = null;
        CallableStatement callStm = null;
        Categories catalog = null;
        try{
            conn = ConnEcommerceDB.openConnection();
            callStm = conn.prepareCall("{call find_catalog_by_id(?)}");
            callStm.setInt(1,catalogId);
            ResultSet rs = callStm.executeQuery();
            catalog = new Categories();

            if(rs.next()){
                catalog.setCatalogId(rs.getInt("catalog_id"));
                catalog.setCatalogName(rs.getString("catalog_name"));
                catalog.setDescription(rs.getString("catalog_description"));
                catalog.setStatus(rs.getBoolean("catalog_status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnEcommerceDB.closeConnection(conn,callStm);
        }
        return catalog;
    }

    @Override
    public boolean update(Categories catalog) {
        Connection conn = null;
        CallableStatement callStm = null;
        boolean result = false;

        try{
            conn = ConnEcommerceDB.openConnection();
            callStm = conn.prepareCall("call update_catalog(?,?,?,?)");
            callStm.setInt(1,catalog.getCatalogId());
            callStm.setString(2,catalog.getCatalogName());
            callStm.setString(3,catalog.getDescription());
            callStm.setBoolean(4,catalog.isStatus());
            callStm.executeUpdate(); // Cần thêm dòng này trước khi return true;

            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnEcommerceDB.closeConnection(conn,callStm);
        }
        return result;
    }

    @Override
    public boolean delete(int catalogId) {
        Connection conn = null;
        CallableStatement callStm = null;
        boolean result = false;

        try{
            conn = ConnEcommerceDB.openConnection();
            callStm = conn.prepareCall("call delete_catalog(?)");
            callStm.setInt(1,catalogId);
            callStm.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnEcommerceDB.closeConnection(conn,callStm);
        }
        return result;
    }
}
