package it.balyfix.application;


import it.balyfix.config.CassandraConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
@PropertySource("classpath:/tatami/tatami-test.properties")
@ComponentScan(basePackages = {"it.balyfix"})
@Import(value = {
        CassandraConfiguration.class})
public class ApplicationTestConfiguration {

    private final Logger log = LoggerFactory.getLogger(ApplicationTestConfiguration.class);

    @PostConstruct
    public void initTatami() throws IOException{
        log.info("Tatami test context started!");
    }
}
