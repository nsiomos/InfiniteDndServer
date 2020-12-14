package com.nicolesiomos.infinitedndserver.api;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */
@RestController
public class HealthController {

    @RequestMapping(method = GET, path = "/health")
    public HealthDto generateHealthReport() {
        HealthDto ret = new HealthDtoBuilder()
                .setState(HealthDto.State.OK)
                .setTimestamp(LocalDateTime.now())
                .createHealthDto();

        return ret;
    }
}
