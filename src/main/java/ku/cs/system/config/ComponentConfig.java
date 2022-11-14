package ku.cs.system.config;

import ku.cs.system.services.ProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ComponentConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    public ProductService service(){
        return new ProductService();
    }
}
