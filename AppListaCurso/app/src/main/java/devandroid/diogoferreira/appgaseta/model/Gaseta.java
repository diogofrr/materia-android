package devandroid.diogoferreira.appgaseta.model;

public class Gaseta {
    public double gasolina;
    public double etanol;

    public Gaseta(double gasolina, double etanol) {
        this.gasolina = gasolina;
        this.etanol = etanol;
    }

    public double getGasolina() {
        return gasolina;
    }

    public void setGasolina(double gasolina) {
        this.gasolina = gasolina;
    }

    public double getEtanol() {
        return etanol;
    }

    public void setEtanol(double etanol) {
        this.etanol = etanol;
    }
}
