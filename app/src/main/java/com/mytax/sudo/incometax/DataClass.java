package com.mytax.sudo.incometax;

/**
 * Created by Ayaz on 5/28/2018.
 */

public class DataClass {
    int minimumRange, maximumRange,additionalAmount;
    double taxRate;

    public DataClass(int minimumRange, int maximumRange, int additionalAmount, double taxRate) {
        this.minimumRange = minimumRange;
        this.maximumRange = maximumRange;
        this.additionalAmount = additionalAmount;
        this.taxRate = taxRate;
    }

    public DataClass() {
    }

    public int getMinimumRange() {
        return minimumRange;
    }

    public void setMinimumRange(int minimumRange) {
        this.minimumRange = minimumRange;
    }

    public int getMaximumRange() {
        return maximumRange;
    }

    public void setMaximumRange(int maximumRange) {
        this.maximumRange = maximumRange;
    }

    public int getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(int additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
