/*
 * License: Open Source
 */
package com.nicolesiomos.infinitedndserver.api;

import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */

public class HealthDto {
    public enum State {OK, WARN, ERROR}
    
    private State state;
    private LocalDateTime timestamp;

    public HealthDto() {
    }

    public HealthDto(State state, LocalDateTime timestamp) {
        this.state = state;
        this.timestamp = timestamp;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}
