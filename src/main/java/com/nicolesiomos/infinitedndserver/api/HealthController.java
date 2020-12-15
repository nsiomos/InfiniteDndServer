package com.nicolesiomos.infinitedndserver.api;

import com.nicolesiomos.infinitedndserver.db.DatasourceRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nicole Siomos <nicole.siomos at yahoo.com>
 */
@RestController
public class HealthController {

    @Autowired
    DatasourceRepository repository;

    @RequestMapping(method = GET, path = "/health")
    public HealthDto generateHealthReport() {
        HealthDto ret = new HealthDtoBuilder()
                .setState(HealthDto.State.OK)
                .setTimestamp(LocalDateTime.now())
                .setAccountCount(repository.getAccountCount())
                .createHealthDto();

        return ret;
    }
}
