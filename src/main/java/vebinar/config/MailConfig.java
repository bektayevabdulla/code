package vebinar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vebinar.service.Sender;

@Configuration
@ComponentScan(basePackages = {"vebinar.service"})
public class MailConfig {
    @Bean
    public Sender getSender(){
        return new Sender("forjavamessage@gmail.com","8240602Jm");
    }

}
