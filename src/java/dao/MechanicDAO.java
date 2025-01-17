package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.mechanic;
import mylib.DBUntils;

/**
 *
 * @author this pc
 */
public class MechanicDAO {

    public ArrayList<mechanic> getMechanic(String name) {
        ArrayList<mechanic> result = new ArrayList();
        Connection cn = null;
        try {
            cn = DBUntils.getConnection();
            if (cn != null) {
                // Sử dụng '=' thay vì 'LIKE' để tìm kiếm chính xác tên
                String sql = "SELECT mechanicName FROM [dbo].[Mechanic] WHERE mechanicName = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, name);  // So khớp chính xác tên
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String mechanicName = table.getString("mechanicName");
                        mechanic me = new mechanic(mechanicName);
                        result.add(me);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
