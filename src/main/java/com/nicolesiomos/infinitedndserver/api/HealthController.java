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
    private Logger logger = LoggerFactory.getLogger(HealthController.class);

    
	@RequestMapping(method = GET, path = "/health")
	public HealthDto generateHealthReport() {
            logger.info(String.format("Requested health report. Generating."));
            
            HealthDto ret = new HealthDtoBuilder()
                    .setState(HealthDto.State.OK)
                    .setTimestamp(LocalDateTime.now())
                    .createHealthDto();
            
            logger.info(String.format("Generated health report: \"%s\".", ret));
            return ret;
	}    
}
