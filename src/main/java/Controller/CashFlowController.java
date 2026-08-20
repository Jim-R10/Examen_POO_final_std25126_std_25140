package Controller;

import Model.CashFlow;
import Service.CashFlowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CashFlowController {
    private final CashFlowService cashFlowService;

    @GetMapping("/cash-flows")
    public List<CashFlow> getCashFlows(@RequestParam(required = false) String type) {
        return CashFlowService.findByType(type);
    }
}
