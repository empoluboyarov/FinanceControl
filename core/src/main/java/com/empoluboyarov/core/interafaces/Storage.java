package com.empoluboyarov.core.interafaces;

import com.empoluboyarov.core.exceptions.AmountException;
import com.empoluboyarov.core.exceptions.CurrencyException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;

//TODO Изменить класс BigDecimal на готовый клас по работе с деньгами

public interface Storage {

    String getName();

    // получение баланса (остатка)
    Map<Currency, BigDecimal> getCurrencyAmounts(); // остаток по каждой доступной валюте в хранилище
    BigDecimal getAmount(Currency currency) throws CurrencyException; // остаток по определенной валюте
    BigDecimal getApproxAmount(Currency currency)throws CurrencyException;// примерный остаток в переводе всех денег в одну валюту

    // изменение баланса (остатка)
    void changeAmount(BigDecimal amount, Currency currency) throws CurrencyException; // изменение баланса по определенной валюте
    void addAmount(BigDecimal amount, Currency currency) throws CurrencyException; // добавить сумму в валюте
    void expenseAmount(BigDecimal amount, Currency currency) throws CurrencyException, AmountException;  // отнять сумму в валюте

    // работа с валютой
    void addCurrency(Currency currency) throws CurrencyException; // добавить новую валюту в хранилище
    void deleteCurrency(Currency currency)throws CurrencyException; // удалить валюту из хранилища
    Currency getCurrency(String code) throws CurrencyException; // получить валюту по коду
    List<Currency> getAvailableCurrencies(); // получить все доступные валюты хранилища в отдельной коллекции

}
