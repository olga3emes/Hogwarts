package Models;

import DataBase.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WandDAO {

    private Connection conn;

    public WandDAO(){
        conn = DBConnection.getConnection();
    }

    public void create(Wand wand) throws SQLException{
        String sql = "insert into wand (wood, core, length) values (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, wand.getWood());
        ps.setString(2, wand.getCore());
        ps.setDouble(3,wand.getLength());
        ps.executeUpdate();
        ps.close();
    }

    public List<Wand> getAll() throws SQLException{
        List<Wand> list = new ArrayList<>();
        String sql = "SELECT * FROM wand";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Wand w = new Wand();
            w.setId(rs.getInt("id"));
            w.setWood(rs.getString("wood"));
            w.setCore(rs.getString("core"));
            w.setLength(rs.getDouble("length"));
            list.add(w);
        }
        rs.close();
        return list;
    }



}//end class
