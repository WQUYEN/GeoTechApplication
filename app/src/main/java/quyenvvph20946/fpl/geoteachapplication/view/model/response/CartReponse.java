package quyenvvph20946.fpl.geoteachapplication.view.model.response;
import java.util.List;

import quyenvvph20946.fpl.geoteachapplication.view.model.OptionAndQuantity;

public class CartReponse {
    private int code;
    private List<OptionAndQuantity> data;

    public CartReponse() {
    }

    public CartReponse(int code, List<OptionAndQuantity> data) {
        this.code = code;
        this.data = data;
    }

    @Override
    public String toString() {
        return "CartReponse{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<OptionAndQuantity> getData() {
        return data;
    }

    public void setData(List<OptionAndQuantity> data) {
        this.data = data;
    }
}
