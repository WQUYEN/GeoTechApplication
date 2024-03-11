package quyenvvph20946.fpl.geoteachapplication.view.model.response;
import java.util.List;

import quyenvvph20946.fpl.geoteachapplication.view.model.City;

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

    public List<City> getResults() {
        return results;
    }

    public void setResults(List<City> results) {
        this.results = results;
    }
}
