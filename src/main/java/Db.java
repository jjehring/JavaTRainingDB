import java.sql.*;
import org.apache.log4j.Logger;

public class Db {
    public static void main(String[] args) {
        System.out.println("DB TEst");
        Logger logger = Logger.getLogger("myLog");
        logger.error("ERROR");
        logger.debug("DEBUG");

        logger.info("Just an Info");
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:./chinook.db";
            conn = DriverManager.getConnection(url);
            String sql = "select firstname, lastname from  customers where lastname = 'Gruber'";
            sql = "SELECT albumid, title, ArtistId FROM albums ORDER BY title ";
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            {
                // loop through the result set
      //while (true) {
                while (rs.next()) {
                    logger.info(rs.getInt("albumid") +  "\t" +
                            rs.getString("title")  +  "\t" +
                            rs.getString("ArtistId")    );
                    System.out.println(
                            rs.getInt("albumid") +  "\t" +
                            rs.getString("title")  +  "\t" +
                            rs.getString("ArtistId")
                    );
                } }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
