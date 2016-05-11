package com.empoluboyarov.core.impls.operations;

import com.empoluboyarov.core.abstracts.AbstractOperation;
import com.empoluboyarov.core.interafaces.Storage;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Evgeniy on 11.05.2016.
 */
public class ConvertOperation extends AbstractOperation {

    private Storage fromStorage;
    private Storage toStorage;
    private Currency fromCurrency;
    private Currency toCurrency;
    private BigDecimal fromAmount;
    private BigDecimal toAmount;

    public ConvertOperation(BigDecimal fromAmount, Currency fromCurrency, Storage fromStorage, BigDecimal toAmount, Currency toCurrency, Storage toStorage) {
        this.fromAmount = fromAmount;
        this.fromCurrency = fromCurrency;
        this.fromStorage = fromStorage;
        this.toAmount = toAmount;
        this.toCurrency = toCurrency;
        this.toStorage = toStorage;
    }

    public ConvertOperation(String addInfo, Calendar dateTime, long id, BigDecimal fromAmount, Currency fromCurrency, Storage fromStorage, BigDecimal toAmount, Currency toCurrency, Storage toStorage) {
        super(addInfo, dateTime, id);
        this.fromAmount = fromAmount;
        this.fromCurrency = fromCurrency;
        this.fromStorage = fromStorage;
        this.toAmount = toAmount;
        this.toCurrency = toCurrency;
        this.toStorage = toStorage;
    }

    public ConvertOperation(long id, BigDecimal fromAmount, Currency fromCurrency, Storage fromStorage, BigDecimal toAmount, Currency toCurrency, Storage toStorage) {
        super(id);
        this.fromAmount = fromAmount;
        this.fromCurrency = fromCurrency;
        this.fromStorage = fromStorage;
        this.toAmount = toAmount;
        this.toCurrency = toCurrency;
        this.toStorage = toStorage;
    }

    public BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Storage getFromStorage() {
        return fromStorage;
    }

    public void setFromStorage(Storage fromStorage) {
        this.fromStorage = fromStorage;
    }

    public BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Storage getToStorage() {
        return toStorage;
    }

    public void setToStorage(Storage toStorage) {
        this.toStorage = toStorage;
    }
}
