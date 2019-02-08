package phpTravel.pages.flightsPage;

public class FlightsPageData {
    public static final String FLIGHTS_PRICE_LIST = "//span[@class=\"strong\"]";
    public static final String CONFIRM_BOOKING = "//button[@class=\"btn btn-success btn-lg btn-block completebook\"]";
    public static final String RAPORT_TABLE = "//table[@id=\"invoiceTable\"]/tbody/tr[4]/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td/p";
    public static final String MONEY_TYPE="(//i[@class=\"icon-money-2 go-right\"])[2]";
    public static final String USD_TYPE = "(//a[contains(text(),'USD')])[2]";
}
