package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory extends RandomNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        List temp = new ArrayList<PhoneNumber>();
        int count = 0;
        while (count <= phoneNumberCount) {
            temp.add(createRandomPhoneNumber());
            count++;
            PhoneNumber[] numbers = (PhoneNumber[]) temp.toArray();
            return numbers;
        } return null;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        Integer areaCode = createRandom3Digits();
        Integer centralOfficeCode = createRandom3Digits();
        Integer phoneLineCode = createRandom4Digits();
        PhoneNumber number = createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
        return number;
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        logger.log(Level.INFO, "(###)-###-#### is not a valid phone number.");
        try {
            String phoneNumber = String.format("(%d)-%d-%d", areaCode, centralOfficeCode, phoneLineCode);
            return createPhoneNumber(phoneNumber);
        } catch (InvalidPhoneNumberFormatException e) {
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        logger.log(Level.INFO, "Attempting to create a new Phone Number object with a value of (###)-###-####.");
        return new PhoneNumber(phoneNumberString);
    }
}
