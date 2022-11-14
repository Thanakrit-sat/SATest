package ku.cs.system.services;

import ku.cs.system.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.*;

import java.util.List;

@Service
@Configurable
public class ProductService {
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:8888/Prod";

    public List<Product> getAll() {
        ResponseEntity<List<Product>> response =
                restTemplate.exchange("http://localhost:8888/Prod",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>(){});
        List<Product> products = (List<Product>) response.getBody();
        System.out.println(products.get(1));
        return products;
    }

    public Product getProduct(int id) {
        id--;
        Product[] products = getAll().toArray(new Product[0]);
        return products[id];
    }

    public Product create(Product product){
        return restTemplate.postForObject(url, product, Product.class);
    }
}
