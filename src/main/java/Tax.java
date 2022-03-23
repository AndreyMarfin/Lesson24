public class Tax implements PersonalAccount {
    private double profits;
    private double expenses;

    public double getProfits() {
        return profits;
    }

    public double getExpenses() {
        return expenses;
    }

    @Override
    public void setProfits(double newProfits) {
        if (newProfits >= 0) {
            profits += newProfits;
        } else {
            System.out.println("Некорректное значение параметра доход " + newProfits);
        }

    }

    @Override
    public void setExpenses(double newExpenses) {
        if (newExpenses >= 0) {
            expenses += newExpenses;
        } else {
            System.out.println("Некорректное значение параметра расход " + newExpenses);
        }

    }

    public double incomeTax() {
        double tax;
        if (getProfits() == 0) {
            tax = 0;
        } else {
            tax = getProfits() * 0.06;
        }
        return tax;

    }

    public double differenceTax() {
        double tax;
        if (getProfits() == 0) {
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
