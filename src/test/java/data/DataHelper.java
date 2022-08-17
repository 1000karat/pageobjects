package data;

import java.util.Arrays;
import java.util.List;

public class DataHelper {
    private DataHelper() {

    }
    public static final String BASE_URL = "http://localhost:9999";
    public static final String LOGIN = "vasya";
    public static final String PASSWORD = "qwerty123";
    public static final String CODE = "12345";
    public static String cardNumberList(int index) {
        List<String> cardList = Arrays
                .asList("5559 0000 0000 0001", "5559 0000 0000 0002", "5559 0000 0000 0003");
        return cardList.get(index);
    }
}
