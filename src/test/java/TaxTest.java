import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TaxTest {
    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = {"setTest.csv"})
    public void setProfitTest(String title, double newProfits, double expected) {
        Tax account = new Tax();
        account.setProfits(newProfits);
        double actual = account.getProfits();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = {"setTest.csv"})
    public void setExpensesTest(String title, double newExpenses, double expected) {
        Tax account = new Tax();
        account.setExpenses(newExpenses);
        double actual = account.getExpenses();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = {"setThreeTest.csv"})
    public void setThreeProfitTest(String title, double newProfits, double expected) {
        Tax account = new Tax();
        account.setProfits(newProfits);
        account.setProfits(newProfits);
        account.setProfits(newProfits);
        double actual = account.getProfits();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = {"setThreeTest.csv"})
    public void setThreeExpensesTest(String title, double newExpenses, double expected) {
        Tax account = new Tax();
        account.setExpenses(newExpenses);
        account.setExpenses(newExpenses);
        account.setExpenses(newExpenses);
        double actual = account.getExpenses();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = {"incomeTaxTest.csv"})
    public void incomeTaxTest(String title, double newProfits, double expected) {
        Tax account = new Tax();
        account.setProfits(newProfits);
        double actual = account.incomeTax();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = {"incomeThreeTaxTest.csv"})
    public void incomeThreeTaxTest(String title, double newProfits, double expected) {
        Tax account = new Tax();
        account.setProfits(newProfits);
        account.setProfits(newProfits);
        account.setProfits(newProfits);
        double actual = account.incomeTax();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = {"differenceThreeTaxTest.csv"})
    public void differenceTaxTest(String title, double newProfits, double newExpenses, double expected) {
        Tax account = new Tax();
        account.setProfits(newProfits);
        account.setProfits(newProfits);
        account.setExpenses(newExpenses);
        account.setExpenses(newExpenses);
        double actual = account.differenceTax();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mixDifferenceTaxTest() {
        Tax account = new Tax();
        account.setProfits(600);
        account.setProfits(-300);
        account.setExpenses(150);
        account.setExpenses(-50);
        double expected = 67.5;
        double actual = account.differenceTax();
        Assertions.assertEquals(expected, actual);
    }
}
