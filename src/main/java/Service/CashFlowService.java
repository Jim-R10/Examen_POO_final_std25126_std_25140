package Service;

import Model.CashFlow;
import Repository.CashFlowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CashFlowService {
    public final CashFlowRepository cashFlowRepository;

}
