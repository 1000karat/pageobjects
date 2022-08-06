package data;

import java.sql.Array;
import java.util.ArrayList;

public class DataHelper {

    private static final String BASE_URL = "http://localhost:9999";
    private static final String LOGIN = "vasya";
    private static final String PASSWORD = "qwerty123";
    private static final String CODE = "12345";
    private static final String CARDNUMBERFIRST  = "5559 0000 0000 0001";
    private static final String CARDNUMBERSECOND = "5559 0000 0000 0002";
    private static final String CARDNUMBERTHIRD = "5559 0000 0000 0003";
    public String getBaseUrl() {
        return BASE_URL;
    }

    public String getLogin() {
        return LOGIN;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public String getCode() {
        return CODE;
    }

    public String getCardNumberFirst() {
        return CARDNUMBERFIRST;
    }

    public String getCardNumberSecond() {
        return CARDNUMBERSECOND;
    }
    public String getCardNumberThird() {
        return CARDNUMBERTHIRD;
    }
}