package U6A3.demo.service;

import U6A3.demo.model.City;
import U6A3.demo.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> findAll() {

        return (List<City>) repository.findAll();
    }
}