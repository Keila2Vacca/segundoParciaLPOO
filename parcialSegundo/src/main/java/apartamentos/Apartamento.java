package apartamentos;

import inquilino.Inquilino;

public class Apartamento {

    private int numero;
    private Inquilino inquilino;

    public Apartamento(int numero, Inquilino inquilino) {
        this.numero = numero;
        this.inquilino = inquilino;
    }

    public int getNumero() {
        return numero;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }
}
