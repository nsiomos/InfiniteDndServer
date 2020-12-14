package com.nicolesiomos.infinitedndserver.api;

import java.time.LocalDateTime;


public class HealthDtoBuilder {

    private HealthDto.State state;
    private LocalDateTime timestamp;

    public HealthDtoBuilder() {
    }

    public HealthDtoBuilder setState(HealthDto.State state) {
        this.state = state;
        return this;
    }

    public HealthDtoBuilder setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public HealthDto createHealthDto() {
        return new HealthDto(state, timestamp);
    }
    
}
