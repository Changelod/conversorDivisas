package model;

public class Currency {

    String base_code;
    String nombre;
    double conversion_result;

    public Currency(String base_code, String nombre) {

        this.base_code = base_code;
        this.nombre = nombre;
        this.conversion_result = 0.0;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getNombre() {
        return nombre;
    }

    public double getConversion_result() {
        return conversion_result;
    }
}
