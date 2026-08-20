package Repository;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class DatabaseConnection {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/donation",
                    "andrianarisoa",
                    ""
            );
        }catch (Exception e){
            System.out.println("Error with database connection: "+ e.getMessage());
        }
        return null;
    }
}
