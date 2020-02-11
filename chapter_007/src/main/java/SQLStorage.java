import java.sql.*;

public class SQLStorage {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
        String username = "postgres";
        String password = "1324qewr";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("create table survey (id int, name VARCHAR(30) );");
            st.setString(1, "NEW JAVA USER");
            st.setInt(2, 4);
            st.executeUpdate();
//            PreparedStatement st = conn.prepareStatement("SELECT * FROM users u WHERE u.id in (?, ?)");
//            st.setInt(1, 1);
//            st.setInt(2, 3);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                System.out.println(String.format("%s %s", rs.getString("login"), rs.getTimestamp("create_date")));
//            }
//            rs.close();
//            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
