package com.developers.phonevalidation.validator;

import com.developers.phonevalidation.config.ConfigUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneValidator {

    @Autowired
    private ConfigUtility configUtility;

    public boolean validate(String phoneNumber)
    {
        //split to get the country code
        if (phoneNumber==null || phoneNumber.isEmpty() ||  phoneNumber.indexOf(")")==-1)
        {
            return false;
        }

        String countryCode = phoneNumber.substring(1, phoneNumber.indexOf(")"));
        if(countryCode==null || countryCode.isEmpty())
        {
            return false;
        }

        String regex=configUtility.getProperty(countryCode);
        if(regex==null || regex.isEmpty())
        {
            return false;
        }

        // validate with the expression
        return phoneNumber.matches(regex);
    }

}
