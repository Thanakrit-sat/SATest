package ku.cs.system.services;

import ku.cs.system.models.Product;
import ku.cs.system.models.Supp;
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
public class SuppService {
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:8888/Supp";

    public List<Supp> getAll() {
        ResponseEntity<List<Supp>> response =
                restTemplate.exchange("http://localhost:8888/Supp",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Supp>>(){});
        System.out.println(response);
        List<Supp> supps = (List<Supp>) response.getBody();
        return supps;
    }

    public Supp getSupp(int id) {
        id--;
        Supp[] supps = getAll().toArray(new Supp[0]);
        return supps[id];
    }

    public Supp create(Supp supp){
        return restTemplate.postForObject(url, supp, Supp.class);
    }
}
