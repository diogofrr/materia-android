package com.example.appgaseta.model;

public class Combustiveis {
    private float gasolina;
    private float etanol;
    private String resutado;

    public Combustiveis(){

    }

    public Combustiveis(float gasolina, float etanol) {
        this.gasolina = gasolina;
        this.etanol = etanol;
    }

    public float getGasolina() {
        return gasolina;
    }

    public float setGasolina(float gasolina) {
        this.gasolina = gasolina;
        return gasolina;
    }

    public float getEtanol() {
        return etanol;
    }

    public float setEtanol(float etanol) {
        this.etanol = etanol;
        return etanol;
    }

    public String getResutado() {
        return resutado;
    }

    public void setResutado(String resutado) {
        this.resutado = resutado;
    }

    @Override
    public String toString() {
        return "Combustiveis{" +
                ", gasolina=" + gasolina +
                ", etanol=" + etanol +
                ", resutado='" + resutado + '\'' +
                '}';
    }
}
