package Service;

import Model.CashFlow;
import Repository.CashFlowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashFlowService {
    private final CashFlowRepository cashFlowRepository;

    public CashFlowService(CashFlowRepository cashFlowRepository) {
        this.cashFlowRepository = cashFlowRepository;
    }

    public List<CashFlow> findByType(String type) {

        if (type == null) {
            return cashFlowRepository.findAll();
        }

        if (!type.equalsIgnoreCase("donation") && !type.equalsIgnoreCase("expense")) {
            throw new IllegalArgumentException("Type inconnu: " + type);
        }

        return cashFlowRepository.findByType(type.toLowerCase());
    }
}