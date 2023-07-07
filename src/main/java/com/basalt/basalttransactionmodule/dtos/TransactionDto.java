package com.basalt.basalttransactionmodule.dtos;

import com.basalt.basalttransactionmodule.enums.Currency;
import com.basalt.basalttransactionmodule.enums.DebitCreditIndicator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TransactionDto extends BaseDto {
    private String reference;
    private String accountNumber;
    private BigDecimal amount;
    private Currency currency;
    private DebitCreditIndicator debitCreditIndicator;
}
