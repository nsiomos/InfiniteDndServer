package com.nicolesiomos.infinitedndserver.logging;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */
public enum MdcKey {
    DURATION_IN_MS("durationInMs");
    
    private String stringValue;
    
    MdcKey(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
