package inheritancemethods;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal unitWeight;
    private int numberOfDecimals = 2;

    public Product(String name, BigDecimal unitWeight, int numberOfDecimals) {
        this.name = name;
        this.unitWeight = unitWeight;
        this.numberOfDecimals = numberOfDecimals;
    }

    public Product(String name, BigDecimal unitWeight) {
        this.name = name;
        this.unitWeight = unitWeight;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }

    public BigDecimal totalWeight(int pieces) {
        BigDecimal precisionHelper = BigDecimal.valueOf(Math.pow(10.0,numberOfDecimals));
       return unitWeight.multiply(BigDecimal.valueOf(pieces)).multiply(precisionHelper).divide(precisionHelper);
    }

}
