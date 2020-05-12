package hr.khorvat.blink.config.external;

import feign.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlinkFeignClientConfig {

    @Value("${blink.rest.authorization}" )
    private String authorizationValue;

    @Bean
    public BlinkFeignClientInterceptor blinkFeignClientInterceptor() {
        return new BlinkFeignClientInterceptor(authorizationValue);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
