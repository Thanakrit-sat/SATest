package ku.cs.system.services;

import ku.cs.system.models.CO;
import ku.cs.system.models.Pre_prod;
import ku.cs.system.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Configurable
public class Pre_ProdService {
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:8888/Pre_Prod";

    public List<Pre_prod> getAll() {
        ResponseEntity<List<Pre_prod>> response =
                restTemplate.exchange("http://localhost:8888/Pre_Prod",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Pre_prod>>(){});
        System.out.println(response);
        List<Pre_prod> products = (List<Pre_prod>) response.getBody();
        return products;
    }

    public Pre_prod getPre_Prod(int id) {
        id--;
        Pre_prod[] products = getAll().toArray(new Pre_prod[0]);
        return products[id];
    }

    public Pre_prod create(Pre_prod product){
        return restTemplate.postForObject(url, product, Pre_prod.class);
    }
}
