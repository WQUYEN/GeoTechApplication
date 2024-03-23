package quyenvvph20946.fpl.geotech.model.response;

import com.example.hn_2025_online_shop.model.Ward;

import java.util.Collection;
import java.util.List;

import quyenvvph20946.fpl.geotech.model.Ward;

public class WardResponse {
    private List<Ward> results;


    public WardResponse() {
    }

    @Override
    public String toString() {
        return "WardResponse{" +
                "results=" + results +
                '}';
    }

    public Collection<? extends Ward> getResults() {
        return results;
    }

    public void setResults(List<Ward> results) {
        this.results = results;
    }
}
