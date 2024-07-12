package view;

import model.Currency;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Currency> currencys = new ArrayList<>();


        currencys.add(new Currency("USD", "Dolar Americano"));
        currencys.add(new Currency("ARS", "Peso Argentino"));
        currencys.add(new Currency("COP", "Peso Colombiano"));
        currencys.add(new Currency("CLP", "Peso Chileno"));
        currencys.add(new Currency("BRL", "Real Brasileño"));
        currencys.add(new Currency("PEN", "Sol Peruano"));

        try {

            Menu.deployMenu(currencys);

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }
    }
}
