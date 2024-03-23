package quyenvvph20946.fpl.geotech.model.response;

import com.example.hn_2025_online_shop.model.City;

import java.util.Collection;
import java.util.List;

import quyenvvph20946.fpl.geotech.model.City;

public class CityResponse {
    private List<City> results;

    public CityResponse() {
    }

    @Override
    public String toString() {
        return "CityResponse{" +
                "results=" + results +
                '}';
    }

    public Collection<? extends City> getResults() {
        return results;
    }

    public void setResults(List<City> results) {
        this.results = results;
    }
}
