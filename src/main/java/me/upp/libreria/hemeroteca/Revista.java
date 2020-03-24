package me.upp.libreria.hemeroteca;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString (
        callSuper = true
)
public class Revista extends Hemeroteca {

    @Getter @Setter
    private int numero;

    public Revista(String codigo, String titulo, int anioPublicacion, int numero) {
        super(codigo, titulo, anioPublicacion);
        this.numero = numero;
    }

    public Revista(int numero) {
        this.numero = numero;
    }

}
