package cashregister;

class CashRegister {


    private final Printer printer;

    public CashRegister(Printer printerMock) {
        this.printer = printerMock;
    }

    public void process(Purchase purchase) {

        printer.print(purchase.asString());

    }
}
