package com.empoluboyarov.core.impls;

import com.empoluboyarov.core.interafaces.Storage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeniy on 10.05.2016.
 */
public class DefaultStorage implements Storage {

    private String name;
    private Map<Currency, BigDecimal> currencyAmounts = new HashMap<>();
    private List<Currency> currencyList = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Currency> getAvailableCurrencies() {
        return currencyList;
    }

    public void setAvailableCurrencies(List<Currency> availableCurrencies) {
        this.currencyList = availableCurrencies;
    }

    @Override
    public Map<Currency, BigDecimal> getCurrencyAmounts() {
        return currencyAmounts;
    }

    @Override
    public BigDecimal getAmount(Currency currency) {
        return null;
    }

    @Override
    public BigDecimal getApproxAmount(Currency currency) {
        //TODO Реализовать расчет остатка с приведенем в одну валюту
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void changeAmount(BigDecimal amount, Currency currency) {
        currencyAmounts.put(currency, amount);
    }

    @Override
    public void addAmount(BigDecimal amount, Currency currency) {
        BigDecimal oldAmount = currencyAmounts.get(currency);
        BigDecimal newAmount = oldAmount.add(amount);
        currencyAmounts.put(currency, newAmount);
    }

    @Override
    public void expenseAmount(BigDecimal amount, Currency currency) {
        BigDecimal oldAmount = currencyAmounts.get(currency);
        BigDecimal newAmount = oldAmount.subtract(amount);
        currencyAmounts.put(currency, newAmount);
    }

    @Override
    public void addCurrency(Currency currency) {
        currencyList.add(currency);
        currencyAmounts.put(currency, BigDecimal.ZERO);
    }

    @Override
    public void deleteCurrency(Currency currency) {
        currencyList.remove(currency);
        currencyAmounts.remove(currency);
    }

    @Override
    public Currency getCurrency(String code) {
        for (Currency currency : currencyList) {
            if (currency.getCurrencyCode().equals(code))
                return currency;
        }
        return null;
    }

    public void setCurrencyAmounts(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }


}
