package seedu.addressbook.data.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Parent class for different components in an address: block, street, unit and postalCode
 *  
 */
public class AddressComponent {
    
    private final String value;

    public AddressComponent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Given an address input, extract the needed string using regex
     * 
     * @param address address string from user input, with a/ removed
     * @param regex to match the substring needed. Regex is expected to match only one substring and only the first match
     *              will be returned.
     * @return
     */
    protected static String extractValueFromAddress(String address, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(address);
        if (m.find()) {
            // From javadoc: Capturing groups are indexed from left to right, starting at one.
            return m.group(1).trim();
        } else {
            return null;
        }
    }
}

