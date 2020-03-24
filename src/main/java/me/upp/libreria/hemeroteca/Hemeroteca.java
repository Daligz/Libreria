package me.upp.libreria.hemeroteca;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Hemeroteca {

    @Getter @Setter
    private String codigo;
    @Getter @Setter
    private String titulo;
    @Getter @Setter
    private int anioPublicacion;

    public Hemeroteca(String codigo, String titulo, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public Hemeroteca() {
    }

}
