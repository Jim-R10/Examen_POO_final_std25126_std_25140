package Service;

import DTO.BalanceDTO;
import Model.CashFlow;
import Model.Donation;
import Model.Expense;
import Repository.CashFlowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CashFlowService {
    private final CashFlowRepository cashFlowRepository;

    public List<CashFlow> findByType(String type) {

        if (type == null) {
            return cashFlowRepository.findAll();
        }

        if (!type.equalsIgnoreCase("donation") && !type.equalsIgnoreCase("expense")) {
            throw new IllegalArgumentException("Type inconnu: " + type);
        }
        return cashFlowRepository.findByType(type.toLowerCase());
    }

    public List<CashFlow> getListCashFlows(String userId, String type) {

        if (type == null) {
            return cashFlowRepository.findByUserId(userId);
        }

        if (!type.equalsIgnoreCase("donation") && !type.equalsIgnoreCase("expense")) {
            throw new IllegalArgumentException("Type inconnu: " + type);
        }

        return cashFlowRepository.findByUserIdAndType(userId, type.toLowerCase());
    }

    public BalanceDTO calculateBalance(String userId) {

        List<CashFlow> cashFlows = (userId == null)
                ? cashFlowRepository.findAll()
                : cashFlowRepository.findByUserId(userId);

        BigDecimal totalDonation = BigDecimal.ZERO;
        BigDecimal totalExpense = BigDecimal.ZERO;

        for (CashFlow cashFlow : cashFlows) {
            if (cashFlow instanceof Donation) {
                totalDonation = totalDonation.add(cashFlow.getAmount());
            } else if (cashFlow instanceof Expense) {
                totalExpense = totalExpense.add(cashFlow.getAmount());
            }
        }

        BigDecimal balance = totalDonation.subtract(totalExpense);

        return new BalanceDTO(totalDonation, totalExpense, balance);
    }
}