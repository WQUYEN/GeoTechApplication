package quyenvvph20946.fpl.geoteachapplication.view.model.response;


import java.util.List;

import quyenvvph20946.fpl.geoteachapplication.view.model.ProductByCategory;

public class ProductByCategoryReponse {
    private int code;
    private String message;
    private List<ProductByCategory> result;

    public ProductByCategoryReponse() {
    }

    public ProductByCategoryReponse(int code, String message, List<ProductByCategory> result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    @Override
    public String toString() {
        return "ProductByCategoryReponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
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

    public List<ProductByCategory> getResult() {
        return result;
    }

    public void setResult(List<ProductByCategory> result) {
        this.result = result;
    }
}
