public class Tax implements PersonalAccount {
    private double profits;
    private double expenses;
    private double tax;

    public double getProfits() {
        return profits;
    }

    public double getExpenses() {
        return expenses;
    }

    @Override
    public void setProfits(double newProfits) {
        if (newProfits >= 0) {
            this.profits = newProfits;
        } else {
            System.out.println("Некорректное значение параметра доход");
            this.profits = 0;
        }

    }

    @Override
    public void setExpenses(double newExpenses) {
        if (newExpenses >= 0) {
            this.expenses = newExpenses;
        } else {
            System.out.println("Некорректное значение параметра расход");
            this.expenses = 0;
        }

    }

    public double incomeTax(double newProfits) {
        setProfits(newProfits);
        if (getProfits() == 0){
            tax = 0;
        } else {
            tax = getProfits() * 0.06;
        }
        return tax;

    }

    public double differenceTax(double newProfits, double newExpenses) {
        setProfits(newProfits);
        setExpenses(newExpenses);
        if ( getProfits() == 0 || getExpenses() == 0) {
            tax = 0;
        } else {
            if (getProfits() - getExpenses() < 0) {
                tax = 0;
            } else {
                tax = (getProfits() - getExpenses()) * 0.15;
            }
        }
        return tax;
    }

}
