package phpTravel.pages.homePage;

public class HomePageData {
    public static final String URL = "https://www.phptravels.net/";
    public static final String MY_ACCOUNT = "(//li[@id=\"li_myaccount\"])[2]";
    public static final String LOGIN = "(//a[@href=\"https://www.phptravels.net/login\"])[2]";
    public static final String FLIGHT_FROM = "//div[@id=\"s2id_location_from\"]";
    public static final String FLIGHT_INPUT = "//div[@id=\"select2-drop\"]/div/input";
    public static final String FLIGHT_TO = "//div[@id=\"s2id_location_to\"]";
    public static final String ROUND_TRIP = "//input[@id=\"round\"]/parent::div/ins";
    public static final String RETURN = "//input[@class=\"form form-control input-lg arrivalTime\"]";
    public static final String DEPART = "//input[@class=\"form form-control input-lg departureTime\"]";
    public static final String PASSANGERS = "//input[@name=\"totalManualPassenger\"]";
    public static final String CLASS = "//select[@class=\"form-control fs12 class\"]";
    public static final String SEARCH_BUTTON = "//button[@class=\"btn-primary btn btn-lg btn-block pfb0\"]";
    public static final String FLIGHTS_RESULT = "//ul[@class=\"select2-results\"]/li/div";
}
