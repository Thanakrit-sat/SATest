package ku.cs.system.services;

import ku.cs.system.models.DO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.*;

import java.util.List;

@Service
@Configurable
public class DOService {
    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:8888/DO";

    public List<DO> getAll() {
        ResponseEntity<List<DO>> response =
                restTemplate.exchange("http://localhost:8888/DO",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<DO>>(){});
        System.out.println(response);
        List<DO> dos = (List<DO>) response.getBody();
        return dos;
    }

    public DO getDO(int id) {
        id--;
        DO[] dos = getAll().toArray(new DO[0]);
        return dos[id];
    }

    public DO create(DO delivery){
        return restTemplate.postForObject(url, delivery, DO.class);
    }
}
