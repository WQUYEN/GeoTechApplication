package quyenvvph20946.fpl.geoteachapplication.view.model.response;


import java.util.List;

import quyenvvph20946.fpl.geoteachapplication.view.model.Ward;

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

    public List<Ward> getResults() {
        return results;
    }

    public void setResults(List<Ward> results) {
        this.results = results;
    }
}
