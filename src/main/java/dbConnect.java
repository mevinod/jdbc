import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class dbConnect {
    public static void main( String args[] ) {
        try
        {
            String query1 =  "SELECT count (*) FROM users";
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:database:@localhost:1521:XE","username", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query1);

            int recordCount = rs.getInt(1);

            System.out.println("Total record count is - "+recordCount);

            if (recordCount > 50000) {
                System.out.println("Record count is more than 50K");
            }
            else
                System.out.println("Record count is less than 50K");

            rs.close();
            stmt.close();
            con.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
