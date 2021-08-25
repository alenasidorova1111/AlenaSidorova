package com.epam.tc.hw7.tests;

import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.utils.JsonDataParser;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    public static User DEFAULT_USER = new User().set(
        u -> {
            u.userName = "Roman";
            u.password = "Jdi1234";
        }
    );

    @DataProvider(name = "metalsAndColorsDataSet")
    public static Object[][] metalsAndColorsDataSet() throws IOException {
        return JsonDataParser.jsonMetalsAndColorsParser("src/test/resources/JDI_ex8_metalsColorsDataSet.json");
    }

}
