package edu.fiuba.algo3.modelo.amplificador;

public class FactorExclusividad extends Factor{

    private int factorAcumulado;

    public FactorExclusividad(int factor) {
        this.factorBase = factor;
        this.factorAcumulado = factor;
    }

    public void multiplicar(Factor factor) {
        this.factorAcumulado *= ((FactorExclusividad)factor).getFactorBase();
    }

    public int getFactorBase(){
        return factorBase;
    }

    @Override
    public int getFactor() {
        return factorAcumulado;
    }

}
