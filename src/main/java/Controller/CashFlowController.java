package Controller;

import DTO.BalanceDTO;
import Model.CashFlow;
import Service.CashFlowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CashFlowController {
    private final CashFlowService cashFlowService;

    @GetMapping("/cash-flows")
    public List<CashFlow> getCashFlows(@RequestParam(required = false) String type) {
        return cashFlowService.findByType(type);
    }

    @GetMapping("/users/{userId}/cash-flows")
    public List<CashFlow> getListCashFlows(@PathVariable String userId, @RequestParam(required = false) String type) {
        return cashFlowService.getListCashFlows(userId, type);
    }

    @GetMapping("/balance")
    public BalanceDTO getBalance(@RequestParam(required = false) String userId) {
        return cashFlowService.calculateBalance(userId);
    }
}