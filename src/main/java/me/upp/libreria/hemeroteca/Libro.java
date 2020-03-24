package me.upp.libreria.hemeroteca;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString (
        callSuper = true
)
public class Libro extends Hemeroteca implements IPrestable {

    @Getter @Setter
    private boolean prestado = false;

    public Libro(String codigo, String titulo, int anioPublicacion) {
        super(codigo, titulo, anioPublicacion);
    }

    public Libro(String codigo, String titulo, int anioPublicacion, boolean prestado) {
        super(codigo, titulo, anioPublicacion);
        this.prestado = prestado;
    }

    public Libro(boolean prestado) {
        this.prestado = prestado;
    }

    public Libro() {
    }

    public void prestar() {
        setPrestado(true);
        System.out.println("El libro se presto");
    }

    public void devolver() {
        setPrestado(false);
        System.out.println("El libro se devolvio");
    }

    public void prestado() {
        if (isPrestado()) {
            System.out.println("El libro ya esta prestado");
            return;
        }
        System.out.println("El libro no esta prestado");
    }
}
