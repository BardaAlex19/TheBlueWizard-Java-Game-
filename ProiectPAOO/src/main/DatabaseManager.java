package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:ProiectPAOO/src/game.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS player (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "level INTEGER NOT NULL" +
                ");";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Table 'player' is ready.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void savePlayerState(int level) {
        String sql = "INSERT INTO player(level) VALUES(?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, level);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static PlayerState loadPlayerState() {
        String sql = "SELECT * FROM player ORDER BY id DESC LIMIT 1";
        PlayerState playerState = null;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                int level = rs.getInt("level");
                playerState = new PlayerState(level);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return playerState;
    }
}
