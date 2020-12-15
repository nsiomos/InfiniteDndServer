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

    public enum State {
        OK, WARN, ERROR
    }

    private State state;
    private long accountCount;
    private LocalDateTime timestamp;

    public HealthDto() {
    }

    public HealthDto(State state, long accountCount, LocalDateTime timestamp) {
        this.state = state;
        this.accountCount = accountCount;
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

    public long getAccountCount() {
        return accountCount;
    }

    public void setAccountCount(long accountCount) {
        this.accountCount = accountCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
