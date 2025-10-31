package Models;

import DataBase.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WizardDAO {

    private Connection conn;

    public WizardDAO() {
        conn = DBConnection.getConnection();
    }

    public void create(Wizard wizard) throws SQLException {
        String sql = "insert into wizard(name, age, house_id, wand_id) values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, wizard.getName());
        ps.setInt(2, wizard.getAge());
        ps.setInt(3, wizard.getHouseId());
        ps.setInt(4, wizard.getWandId());
        ps.executeUpdate();
        ps.close();
    }

    public List<Wizard> getAll() {
        List<Wizard> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM wizard";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Wizard w = new Wizard();
                w.setId(rs.getInt("id"));
                w.setName(rs.getString("name"));
                w.setAge(rs.getInt("age"));
                w.setHouseId(rs.getInt("house_id"));
                w.setWandId(rs.getInt("wand_id"));

                list.add(w);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("❌ERROR❌" + e.getMessage());
        }
        return list;
    }


    public void delete (int id) throws SQLException{

        String sql = "delete from wizard where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    }//endclass
