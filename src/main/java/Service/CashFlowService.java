package Service;

import Model.CashFlow;
import Repository.CashFlowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}