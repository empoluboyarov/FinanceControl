package com.empoluboyarov.core.impls.operations;

import com.empoluboyarov.core.abstracts.AbstractOperation;
import com.empoluboyarov.core.interafaces.Source;
import com.empoluboyarov.core.interafaces.Storage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Evgeniy on 11.05.2016.
 */
public class OutcomeOperation extends AbstractOperation {

    private Storage fromStorage;
    private Source toSource;
    private BigDecimal amount;
    private Currency currency;

//TODO для всех классов создать конструкторы без id, так как это поле будут автоинкрементым


    public OutcomeOperation(BigDecimal amount, Currency currency, Storage fromStorage, Source toSource) {
        this.amount = amount;
        this.currency = currency;
        this.fromStorage = fromStorage;
        this.toSource = toSource;
    }

    public OutcomeOperation(String addInfo, Calendar dateTime, long id, BigDecimal amount, Currency currency, Storage fromStorage, Source toSource) {
        super(addInfo, dateTime, id);
        this.amount = amount;
        this.currency = currency;
        this.fromStorage = fromStorage;
        this.toSource = toSource;
    }

    public OutcomeOperation(long id, BigDecimal amount, Currency currency, Storage fromStorage, Source toSource) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.fromStorage = fromStorage;
        this.toSource = toSource;
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

    public Source getToSource() {
        return toSource;
    }

    public void setToSource(Source toSource) {
        this.toSource = toSource;
    }

    public Storage getFromStorage() {
        return fromStorage;
    }

    public void setFromStorage(Storage fromStorage) {
        this.fromStorage = fromStorage;
    }
}
