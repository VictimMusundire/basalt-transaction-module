package com.basalt.basalttransactionmodule.dtos;

import com.basalt.basalttransactionmodule.enums.Currency;
import com.basalt.basalttransactionmodule.enums.DebitCreditIndicator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Reference should not be null or empty")
    private String reference;
    @NotEmpty(message = "Account number should not be null or empty")
    private String accountNumber;
    @Min(value = 1, message = "Amount can not be less than 0")
    private BigDecimal amount;
    private Currency currency;
    private DebitCreditIndicator debitCreditIndicator;
}
