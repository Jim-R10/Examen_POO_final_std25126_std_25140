package Repository;

import Model.Expense;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
public class ExpensesRepository {
    private final DatabaseConnection databaseConnection;

    public Expense save(Expense expense) {
        String sql = "INSERT INTO cash_flow (id, created_at, amount, type, reason, expense_frequency) " +
                "VALUES (?, ?, ?, 'expense', ?, ?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            String id = expense.getId() != null ? expense.getId() : UUID.randomUUID().toString();
            Instant createdAt = expense.getCreatedAt() != null ? expense.getCreatedAt() : Instant.now();

            expense.setId(id);
            expense.setCreatedAt(createdAt);

            statement.setString(1, id);
            statement.setTimestamp(2, Timestamp.from(createdAt));
            statement.setBigDecimal(3, expense.getAmount());
            statement.setString(4, expense.getReason());
            statement.setString(5, expense.getExpenseFrequency().name());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la création de l'expense: " + e.getMessage());

        }

        return expense;
    }
}
