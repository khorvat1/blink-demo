package hr.khorvat.blink.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties({LiquibaseProperties.class})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "hr.khorvat.blink.repository")
@Slf4j
public class DBConfig {

    @Bean
    public SpringLiquibase liquibase(DataSourceProperties dataSourceProperties, LiquibaseProperties liquibaseProperties) {
        DataSource liquibaseDataSource = DataSourceBuilder.create()
                .driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(liquibaseProperties.getUser())
                .password(liquibaseProperties.getPassword())
                .build();

        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(liquibaseDataSource);
        liquibase.setChangeLog("classpath:db/changelog/master.xml");
        liquibase.setDefaultSchema("blink");
        return liquibase;
    }
}
