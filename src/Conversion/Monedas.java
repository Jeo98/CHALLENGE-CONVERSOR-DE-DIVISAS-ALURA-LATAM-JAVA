package Conversion;

public class Monedas {

    private double valorMonedaOriginal=0.0; //moneda sin convertir
    private double valorMonedaConvertida=0.0;
    private String divisaACambiar;
    private String divisaARecibir;

    public String getDivisaACambiar() {
        return divisaACambiar;
    }

    public void setDivisaACambiar(String divisaACambiar) {
        this.divisaACambiar = divisaACambiar;
    }

    public String getDivisaARecibir() {
        return divisaARecibir;
    }

    public void setDivisaARecibir(String divisaARecibir) {
        this.divisaARecibir = divisaARecibir;
    }

    public double getvalorMonedaOriginal() {
        return valorMonedaOriginal;
    }

    public void setvalorMonedaOriginal(double monedaOriginal) {
        this.valorMonedaOriginal = monedaOriginal;
    }

    public double getvalorMonedaConvertida() {
        return valorMonedaConvertida;
    }

    public void setvalorMonedaConvertida(double monedaConvertida) {
        this.valorMonedaConvertida = monedaConvertida;
    }

    public String menu(){

        return("-----------------------JEO CONVERSOR DE MONEDAS-------------------------"+
                "\n1- Dólar            ---> Peso Argentino"+
                "\n2- Peso Argentino   ---> Dólar"+
                "\n3- Dolar            ---> Real brasileño"+
                "\n4- Real brasileño   ---> Dolar"+
                "\n5- Dolar            ---> Peso Colombiano"+
                "\n6- Peso Colombiano  ---> Dolar"+
                "\n9- SALIR DE CONVERSOR");
    }
}
