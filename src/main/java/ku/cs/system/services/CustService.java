package ku.cs.system.services;

import ku.cs.system.models.Cust;
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
public class CustService {
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:8888/Cust";

    public List<Cust> getAll() {
        ResponseEntity<List<Cust>> response =
                restTemplate.exchange("http://localhost:8888/Cust",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Cust>>(){});
        System.out.println(response);
        List<Cust> custs = (List<Cust>) response.getBody();
        return custs;
    }

    public Cust getCust(int id) {
        id--;
        Cust[] custs = getAll().toArray(new Cust[0]);
        return custs[id];
    }

    public Cust create(Cust cust){
        return restTemplate.postForObject(url, cust, Cust.class);
    }
}
