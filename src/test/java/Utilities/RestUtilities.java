package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilities {

    public static String userNameValidValidFormat() {
        String generatedStringName = RandomStringUtils.randomAlphabetic(1);
        return ("Michale" + generatedStringName);

    }

        public static String userEmailValidFormat() {
        String generatedStringEmail = RandomStringUtils.randomAlphabetic(1);
        return ("Michal." + generatedStringEmail + "@ipl.com");
    }

    public static String userEmailInValidFormat() {
        String generatedStringEmail = RandomStringUtils.randomAlphabetic(1);
        return ("Michal." + generatedStringEmail + "ipl.com");
    }

//
//    public static String userGender(String gender) {
//        return userGender(gender);
//    }
//
//
//    public static String userStatus(String status) {
//        return userStatus(status);
//    }

}
