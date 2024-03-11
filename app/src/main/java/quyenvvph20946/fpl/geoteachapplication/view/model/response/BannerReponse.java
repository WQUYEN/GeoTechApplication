package quyenvvph20946.fpl.geoteachapplication.view.model.response;

import java.util.List;

import quyenvvph20946.fpl.geoteachapplication.view.model.Banner;

public class BannerReponse {
    private int code;
    private String message;
    private List<Banner> data;

    public BannerReponse() {
    }

    public BannerReponse(int code, String message, List<Banner> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Banner> getData() {
        return data;
    }

    public void setData(List<Banner> data) {
        this.data = data;
    }
}
