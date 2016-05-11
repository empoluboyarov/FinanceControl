package com.empoluboyarov.core.impls.operations;

import com.empoluboyarov.core.abstracts.AbstractOperation;
import com.empoluboyarov.core.interafaces.Storage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Evgeniy on 11.05.2016.
 */
public class TransferOperation extends AbstractOperation {

    private Storage fromStorage;
    private Storage toStorage;
    private BigDecimal amount;
    private Currency currency;

    public TransferOperation(BigDecimal amount, Currency currency, Storage fromStorage, Storage toStorage) {
        this.amount = amount;
        this.currency = currency;
        this.fromStorage = fromStorage;
        this.toStorage = toStorage;
    }

    public TransferOperation(String addInfo, Calendar dateTime, long id, BigDecimal amount, Currency currency, Storage fromStorage, Storage toStorage) {
        super(addInfo, dateTime, id);
        this.amount = amount;
        this.currency = currency;
        this.fromStorage = fromStorage;
        this.toStorage = toStorage;
    }

    public TransferOperation(long id, BigDecimal amount, Currency currency, Storage fromStorage, Storage toStorage) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.fromStorage = fromStorage;
        this.toStorage = toStorage;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Storage getFromStorage() {
        return fromStorage;
    }

    public void setFromStorage(Storage fromStorage) {
        this.fromStorage = fromStorage;
    }

    public Storage getToStorage() {
        return toStorage;
    }

    public void setToStorage(Storage toStorage) {
        this.toStorage = toStorage;
    }
}
