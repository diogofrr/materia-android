package devandroid.diogoferreira.imc.model;

import androidx.annotation.NonNull;

public class Pessoa {
    private final double peso;
    private final double altura;

    public Pessoa(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    @NonNull
    @Override
    public String toString() {
        return "Pessoa{" +
                "peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
