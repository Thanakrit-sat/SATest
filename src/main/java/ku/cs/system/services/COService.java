package ku.cs.system.services;

import ku.cs.system.models.CO;
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
public class COService {
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:8888/CO";

    public List<CO> getAll() {
        ResponseEntity<List<CO>> response =
                restTemplate.exchange("http://localhost:8888/CO",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CO>>(){});
        System.out.println(response);
        List<CO> cos = (List<CO>) response.getBody();
        return cos;
    }

    public CO getCO(int id) {
        id--;
        CO[] cos = getAll().toArray(new CO[0]);
        return cos[id];
    }

    public CO create(CO co){
        return restTemplate.postForObject(url, co, CO.class);
    }
}
