package edu.fiuba.algo3.modelo.amplificador;

public abstract class Factor {

    protected int factorBase;

    public abstract void multiplicar(Factor factor);

    public abstract int getFactor();
}