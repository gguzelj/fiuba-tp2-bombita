package com.bombitarodriguez.utils;


public enum Direccion {

    ABAJO(0), IZQUIERDA(1), ARRIBA(2), DERECHA(3);
    
    private final Integer valor;

    private Direccion(Integer valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

}
