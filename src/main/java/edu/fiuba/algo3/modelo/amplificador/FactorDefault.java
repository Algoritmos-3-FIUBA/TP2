package edu.fiuba.algo3.modelo.amplificador;

public class FactorDefault extends Factor{

    public FactorDefault(int factor) {
        this.factorBase = factor;
    }

    @Override
    public void multiplicar(Factor factor) {
        factorBase *= factor.getFactor();
    }

    @Override
    public int getFactor() {
        return factorBase;
    }

}
