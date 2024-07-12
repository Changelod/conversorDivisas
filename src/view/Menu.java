package view;

import controller.Connection;
import model.Currency;
import java.util.*;

public class Menu {

    private static String input() {
        Scanner input = new Scanner(System.in);
        String x = input.nextLine();
        return x;
    }

    public static void deployMenu(List<Currency> currencys) {

        HashMap<Integer, String> mapMenu = new HashMap<>();

        int j = 1, x = 0;

        System.out.println("Convertidor de divisas");

        do {

            x = 0;
            j = 1;

            System.out.println("***********************************");
            System.out.println("Elija su divisa");

            for (int i = 0; i < currencys.size(); i++) {

                System.out.println(j + ") " + currencys.get(i).getNombre() + " [" + currencys.get(i).getBase_code() + "]");
                mapMenu.put(j, currencys.get(i).getBase_code());
                j++;
            }

            System.out.println((mapMenu.size() + 1) + ") Salir");
            System.out.print("Elija una opcion: ");
            String opt = input();
            System.out.println("***********************************");

            System.out.println("");

            for (int i = 1; i <= mapMenu.size(); i++) {

                if (opt.trim().equals(String.valueOf(i))) {

                    deploySubMenu(mapMenu.get(i), currencys);
                    waitKey();
                    i = mapMenu.size() + 1;

                } else if (opt.trim().equals(String.valueOf(mapMenu.size() + 1))) {

                    System.out.println("Ejecucion finalizada");
                    x = 1;
                    i = mapMenu.size() + 1;

                } else if (i == mapMenu.size()) {

                    System.out.println("Opcion no valida, vuelve a intentar");
                    System.out.println("");
                }
            }

        } while(x == 0);
    }

    private static void deploySubMenu(String iso, List<Currency> currencys) {

        HashMap<Integer, String> mapSubMenu = new HashMap<>();

        int j = 1, x = 0;

        do {

            x = 0;
            j = 1;

            System.out.println("Selecione la moneda a la cual desea");
            System.out.println("hacer el cambio");


            for (int i = 0; i < currencys.size(); i++) {

                if(!(currencys.get(i).getBase_code().equals(iso))) {

                    System.out.println(j + ") " + currencys.get(i).getNombre() + " [" + currencys.get(i).getBase_code() + "]");
                    mapSubMenu.put(j, currencys.get(i).getBase_code());
                    j++;
                }
            }

            System.out.print("Elija una opcion: ");
            String opt = input();

            System.out.println("");

            for (int i = 1; i <= mapSubMenu.size(); i++) {

                if (opt.trim().equals(String.valueOf(i))) {

                    System.out.println(Connection.response(iso, mapSubMenu.get(i), enterValue(iso, mapSubMenu.get(i))));
                    break;

                } else if (i == mapSubMenu.size()) {

                    System.out.println("Opcion no valida, vuelva a intentar");
                    System.out.println("");
                    x = 1;
                }
            }

        } while(x != 0);

        System.out.println("***********************************");
    }

    private static double enterValue(String currencyOrigin, String currency) {

        while(true) {

            try {

                System.out.print("Digite el monto de " + currencyOrigin + " a cambiar a " + currency + ": $");
                String value = input();

                return Double.valueOf(value);

            } catch (Exception e) {

                System.out.println("");
                System.out.println("El monto debe ser numerico, vuelva a intentarlo");
                System.out.println("");
            }
        }
    }

    private static void waitKey() {

        System.out.println("");
        System.out.println("Presiona cualquier tecla para continuar");
        String x = input();
    }
}