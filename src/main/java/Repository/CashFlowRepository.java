package Repository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
@AllArgsConstructor
public class CashFlowRepository {
    private final static Connection connection;


}
