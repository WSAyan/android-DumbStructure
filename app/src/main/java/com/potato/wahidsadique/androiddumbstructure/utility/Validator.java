package com.potato.wahidsadique.androiddumbstructure.utility;

/**
 * Created by wahid.sadique on 10/16/2017.
 */

public class Validator {

    public static boolean emailValidator(String emailAddress) {
        return !(emailAddress == null || emailAddress.isEmpty()) && android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches();
    }

    public static boolean phoneNumberValidator(String phoneNumber) {
        return !(phoneNumber == null || phoneNumber.isEmpty()) && android.util.Patterns.PHONE.matcher(phoneNumber).matches();
    }
}
