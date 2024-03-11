package quyenvvph20946.fpl.geoteachapplication.model.response;

import com.example.hn_2025_online_shop.model.District;

import java.util.Collection;
import java.util.List;

import quyenvvph20946.fpl.geoteachapplication.model.District;

public class DistrictResponse {
    private List<District> results;

    public DistrictResponse() {
    }

    @Override
    public String toString() {
        return "DistrictResponse{" +
                "results=" + results +
                '}';
    }

    public Collection<? extends District> getResults() {
        return results;
    }

    public void setResults(List<District> results) {
        this.results = results;
    }
}
