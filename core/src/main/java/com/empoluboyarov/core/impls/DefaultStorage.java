package com.empoluboyarov.core.impls;

import com.empoluboyarov.core.exceptions.AmountException;
import com.empoluboyarov.core.exceptions.CurrencyException;
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

    //блок конструкторов
    public DefaultStorage() {
    }

    public DefaultStorage(String name) {
        this.name = name;
    }

    public DefaultStorage(List<Currency> currencyList, Map<Currency, BigDecimal> currencyAmounts, String name) {
        this.currencyList = currencyList;
        this.currencyAmounts = currencyAmounts;
        this.name = name;
    }

    public DefaultStorage(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }

    public DefaultStorage(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Map<Currency, BigDecimal> getCurrencyAmounts() {

        return currencyAmounts;
    }

    public void setCurrencyAmounts(Map<Currency, BigDecimal> currencyAmounts) {
        this.currencyAmounts = currencyAmounts;
    }


    @Override
    public List<Currency> getAvailableCurrencies() {
        return currencyList;
    }
    
    @Override
    public BigDecimal getAmount(Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);
        return currencyAmounts.get(currency);
    }

    @Override
    public BigDecimal getApproxAmount(Currency currency) {
        //TODO Реализовать расчет остатка с приведенем в одну валюту
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void changeAmount(BigDecimal amount, Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);
        currencyAmounts.put(currency, amount);
    }

    @Override
    public void addAmount(BigDecimal amount, Currency currency) throws CurrencyException {
        checkCurrencyExist(currency);
        BigDecimal oldAmount = currencyAmounts.get(currency);
        BigDecimal newAmount = oldAmount.add(amount);
        currencyAmounts.put(currency, newAmount);
    }

    @Override
    public void expenseAmount(BigDecimal amount, Currency currency) throws CurrencyException, AmountException {

        checkCurrencyExist(currency);

        BigDecimal oldAmount = currencyAmounts.get(currency);
        BigDecimal newAmount = oldAmount.subtract(amount);

        checkAmount(newAmount);

        currencyAmounts.put(currency, newAmount);
    }

    @Override
    public void addCurrency(Currency currency) throws CurrencyException {
        // проверяем есть ли уже такая валюта ....
        if (currencyAmounts.containsKey(currency))
            throw new CurrencyException("Currency already exist");
        currencyList.add(currency);
        currencyAmounts.put(currency, BigDecimal.ZERO);
    }

    @Override
    public void deleteCurrency(Currency currency) throws CurrencyException {

        checkCurrencyExist(currency);

        //проверяем есть ли в хранилище деньги по этой валюте
        if (!currencyAmounts.get(currency).equals(BigDecimal.ZERO))
            throw new CurrencyException("Can't delete currency with amount");

        currencyList.remove(currency);
        currencyAmounts.remove(currency);
    }

    @Override
    public Currency getCurrency(String code) throws CurrencyException {
        for (Currency currency : currencyList) {
            if (currency.getCurrencyCode().equals(code))
                return currency;
        }
        throw new CurrencyException("Currency (code=" + code + ") not exist in storage");
    }

    private void checkCurrencyExist(Currency currency) throws CurrencyException {
        if (!currencyAmounts.containsKey(currency))
            throw new CurrencyException("Currency " + currency + " not exist");
    }

    private void checkAmount(BigDecimal amount) throws AmountException {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new AmountException("Amount can't be < 0");
    }
}
