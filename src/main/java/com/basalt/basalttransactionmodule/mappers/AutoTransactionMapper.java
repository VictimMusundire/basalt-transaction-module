package com.basalt.basalttransactionmodule.mappers;

import com.basalt.basalttransactionmodule.dtos.TransactionDto;
import com.basalt.basalttransactionmodule.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Victim Musundire
 */

@Mapper
public interface AutoTransactionMapper {

    AutoTransactionMapper MAPPER = Mappers.getMapper(AutoTransactionMapper.class);

    TransactionDto mapToTransactionDto(Transaction transaction);

    Transaction mapToTransaction(TransactionDto transactionDto);
}
