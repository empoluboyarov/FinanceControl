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
public class IncomeOperation extends AbstractOperation {

    private Source fromSource;
    private Storage toStorage;
    private BigDecimal amount;
    private Currency currency;

//TODO для всех классов создать конструкторы без id, так как это поле будут автоинкрементым

    public IncomeOperation(BigDecimal amount, Currency currency, Source fromSource, Storage toStorage) {
        this.amount = amount;
        this.currency = currency;
        this.fromSource = fromSource;
        this.toStorage = toStorage;
    }

    public IncomeOperation(String addInfo, Calendar dateTime, long id, BigDecimal amount, Currency currency, Source fromSource, Storage toStorage) {
        super(addInfo, dateTime, id);
        this.amount = amount;
        this.currency = currency;
        this.fromSource = fromSource;
        this.toStorage = toStorage;
    }

    public IncomeOperation(long id, BigDecimal amount, Currency currency, Source fromSource, Storage toStorage) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.fromSource = fromSource;
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

    public Source getFromSource() {
        return fromSource;
    }

    public void setFromSource(Source fromSource) {
        this.fromSource = fromSource;
    }

    public Storage getToStorage() {
        return toStorage;
    }

    public void setToStorage(Storage toStorage) {
        this.toStorage = toStorage;
    }
}
