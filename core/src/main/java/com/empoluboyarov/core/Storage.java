package com.empoluboyarov.core;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;

//TODO Изменить класс BigDecimal на готовый клас по работе с деньгами

public interface Storage {

    String getName();

    // получение баланса (остатка)
    Map<Currency, BigDecimal> getCurrencyAmounts(); // остаток по каждой доступной валюте в хранилище
    BigDecimal getAmount(Currency currency); // остаток по определенной валюте
    BigDecimal getApproxAmount(Currency currency);// примерный остаток в переводе всех денег в одну валюту

    // изменение баланса (остатка)
    void changeAmount(BigDecimal amount, Currency currency); // изменение баланса по определенной валюте
    void addAmount(BigDecimal amount, Currency currency); // добавить сумму в валюте
    void expenseAmount(BigDecimal amount, Currency currency);  // отнять сумму в валюте

    // работа с валютой
    void addCurrency(Currency currency); // добавить новую валюту в хранилище
    void deleteCurrency(Currency currency); // удалить валюту из хранилища
    Currency getCurrency(String code); // получить валюту по коду
    List<Currency> getAvailableCurrencies(); // получить все доступные валюты хранилища в отдельной коллекции

}
