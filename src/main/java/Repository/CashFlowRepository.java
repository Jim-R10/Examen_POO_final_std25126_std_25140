package Repository;

import Model.CashFlow;
import Model.Donation;
import Model.Expense;
import Model.ExpenseFrequency;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class CashFlowRepository {
    private final DatabaseConnection databaseConnection;

    public CashFlowRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<CashFlow> findAll() {
        String sql = "SELECT * FROM cash_flow";
        return executeQuery(sql);
    }

    public List<CashFlow> findByType(String type) {
        String sql = "SELECT * FROM cash_flow WHERE type = ?";
        return executeQuery(sql, type);
    }

    private List<CashFlow> executeQuery(String sql, String... params) {
        List<CashFlow> result = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.add(mapRowToCashFlow(rs));
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des cash-flows: " + e.getMessage());
        }

        return result;
    }

    private CashFlow mapRowToCashFlow(ResultSet rs) throws SQLException {

        String type = rs.getString("type");

        String id = rs.getString("id");
        Instant createdAt = rs.getTimestamp("created_at").toInstant();
        BigDecimal amount = rs.getBigDecimal("amount");

        if (type.equalsIgnoreCase("donation")) {
            Donation donation = new Donation();
            donation.setId(id);
            donation.setCreatedAt(createdAt);
            donation.setAmount(amount);
            donation.setComment(rs.getString("comment"));
            return donation;
        }

        if (type.equalsIgnoreCase("expense")) {
            Expense expense = new Expense();
            expense.setId(id);
            expense.setCreatedAt(createdAt);
            expense.setAmount(amount);
            expense.setReason(rs.getString("reason"));
            expense.setExpenseFrequency(ExpenseFrequency.valueOf(rs.getString("expense_frequency")));
            return expense;
        }

        throw new IllegalStateException("Type inconnu en base: " + type);
    }
}