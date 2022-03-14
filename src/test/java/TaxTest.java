import org.junit.jupiter.api.Assertions;
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
    @CsvFileSource(resources = {"incomeTaxTest.csv"})
    public void incomeTaxTest(String title, double newProfits, double expected) {
        Tax account = new Tax();
        account.setProfits(newProfits);
        double actual = account.incomeTax(account.getProfits());
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = {"differenceTaxTest.csv"})
    public void differenceTaxTest(String title, double newProfits, double newExpenses, double expected) {
        Tax account = new Tax();
        account.setProfits(newProfits);
        account.setExpenses(newExpenses);
        double actual = account.differenceTax(account.getProfits(), account.getExpenses());
        Assertions.assertEquals(expected, actual);
    }
}
