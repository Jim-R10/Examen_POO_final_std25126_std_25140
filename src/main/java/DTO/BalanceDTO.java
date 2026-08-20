package DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BalanceDTO {
    private BigDecimal totalDonation;
    private BigDecimal totalExpense;
    private BigDecimal balance;
}