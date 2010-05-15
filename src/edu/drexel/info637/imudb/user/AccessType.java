package edu.drexel.info637.imudb.user;

/**
 * This enumeration is used to track different access levels in the IMuDb site. Ascending levels of privileges are as
 * follows: MEMBER->CONTRIBUTOR->ADMINISTRATOR
 * @author Patrick Freestone
 */
public enum AccessType {
    /**
     * Denotes the access level of a typical site member
     */
    MEMBER("Member"),
    /**
     * Denotes the access level of a contributor to site content
     */
    CONTRIBUTOR("Contributor"),
    /**
     * Denotes the access level of an administrator
     */
    ADMINISTRATOR("Administrator");

    /**
     * Text value for each access level; can be used for any output such as UI presentation or logging
     */
    private String text;

    /**
     * Private constructor for the enum
     * @param text text values for the specific access level
     */
    private AccessType(String text) {
        this.text = text;
    }

    /**
     * Getter for the text value coupled with the specific enum value
     * @return text value coupled with the specific enum value
     */
    public String getText() {
        return text;
    }

}
