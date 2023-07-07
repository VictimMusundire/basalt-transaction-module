package com.basalt.basalttransactionmodule.models;

import com.basalt.basalttransactionmodule.enums.Currency;
import com.basalt.basalttransactionmodule.enums.DebitCreditIndicator;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;


@Data
@Entity
@Inheritance
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {
        "reference",
        "amount",
        "currency"
})
public class Transaction extends BaseEntity {
    private String reference;
    private BigDecimal amount;
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private DebitCreditIndicator debitCreditIndicator;
}
