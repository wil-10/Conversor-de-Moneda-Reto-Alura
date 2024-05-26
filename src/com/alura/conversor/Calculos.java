package com.alura.conversor;

public class Calculos {
    public String calculo(int n, Double m) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        Moneda moneda = consulta.buscaMoneda(n);
        Double result = 0.0;
        String texto="";
        if (n == 1) {
            result = moneda.MXN() * m;
            texto = String.format("El valor: %.2f[USD] Actualmente es: %.2f[MXN]",m,result);
        }
        if (n == 2) {
            result = moneda.USD() * m;
            texto = String.format("El valor: %.2f[MXN] Actualmente es: %.2f[USD]",m,result);
        }
        if (n == 3) {
            result = moneda.CRC() * m;
            texto = String.format("El valor: %.2f[USD] Actualmente es: %.2f[CRC]",m,result);
        }
        if (n == 4) {
            result = moneda.USD() * m;
            texto = String.format("El valor: %.2f[CRC] Actualmente es: %.2f[USD]",m,result);
        }
        if (n == 5) {
            result = moneda.CAD() * m;
            texto = String.format("El valor: %.2f[USD] Actualmente es: %.2f[CAD]",m,result);
        }
        if (n == 6) {
            result = moneda.USD() * m;
            texto = String.format("El valor: %.2f[CAD] Actualmente es: %.2f[USD]",m,result);
        }
        return texto;

    }
}
