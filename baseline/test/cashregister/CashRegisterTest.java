package cashregister;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by adhulip on 3/21/14.
 */
public class CashRegisterTest {

    @org.junit.Test
    public void shouldPrintPurchase() {

        PurchaseMock purchaseMock = new PurchaseMock();
        PrinterMock printerMock = new PrinterMock();

        CashRegister cashRegister = new CashRegister(printerMock);
        cashRegister.process(purchaseMock);
        assertTrue(printerMock.printed);
        assertThat(printerMock.printedArg, is("mac stuff"));
    }
}

class PrinterMock extends Printer{
    public boolean printed = false;
    public String printedArg;

    @Override
    public void print(String string) {
        this.printed = true;
        this.printedArg = string;
    }
}


class PurchaseMock extends Purchase{

    public PurchaseMock() {
        super(new Item[]{});
    }

    @Override
    public String asString(){
        return "mac stuff";
    }
}