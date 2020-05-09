package hr.khorvat.blink.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "hr.khorvat.blink.external")
public class ApplicationConfiguration {
}
