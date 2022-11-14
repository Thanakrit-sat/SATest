package ku.cs.system.services;

import ku.cs.system.models.Product;
import ku.cs.system.models.SO;
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
public class SOService {
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:8888/SO";

    public List<SO> getAll() {
        ResponseEntity<List<SO>> response =
                restTemplate.exchange("http://localhost:8888/SO",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<SO>>(){});
        System.out.println(response);
        List<SO> sos = (List<SO>) response.getBody();
        return sos;
    }

    public SO getSO(int id) {
        id--;
        SO[] sos = getAll().toArray(new SO[0]);
        return sos[id];
    }

    public SO create(SO so){
        return restTemplate.postForObject(url, so, SO.class);
    }
}
