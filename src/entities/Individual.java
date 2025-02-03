package entities;

public class Individual extends TaxPayer{

    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double limit = 20000.00;
        double tax = 0;
        if (getAnualIncome() < limit) {
            tax = 0.15;
        }else {
            tax = 0.25;
        }

        return (getAnualIncome() * tax) - (healthExpenditures * 0.5);
    }
}
