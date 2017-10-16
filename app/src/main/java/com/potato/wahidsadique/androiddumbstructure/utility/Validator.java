package com.potato.wahidsadique.androiddumbstructure.utility;

import android.util.Patterns;

/**
 * Created by wahid.sadique on 10/16/2017.
 */

public class Validator {

    public static boolean emailValidator(String emailAddress) {
        return !(emailAddress == null || emailAddress.isEmpty()) && Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches();
    }

    public static boolean phoneNumberValidator(String phoneNumber) {
        return !(phoneNumber == null || phoneNumber.isEmpty()) && Patterns.PHONE.matcher(phoneNumber).matches();
    }
}
