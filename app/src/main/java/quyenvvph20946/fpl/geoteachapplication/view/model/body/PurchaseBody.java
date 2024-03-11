package quyenvvph20946.fpl.geoteachapplication.view.model.body;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import quyenvvph20946.fpl.geoteachapplication.view.model.OptionAndQuantity;

public class PurchaseBody {
    @SerializedName("_id")
    private String id;
    @SerializedName("user_id")
    private String userId;
    private List<OptionAndQuantity> productsOrder;
    @SerializedName("total_price")
    private int totalPrice;
    @SerializedName("info_id")
    private String infoId;

    public PurchaseBody() {
    }

    public PurchaseBody(String id, String userId, List<OptionAndQuantity> productsOrder, int totalPrice, String infoId) {
        this.id = id;
        this.userId = userId;
        this.productsOrder = productsOrder;
        this.totalPrice = totalPrice;
        this.infoId = infoId;
    }

    @Override
    public String toString() {
        return "PurchaseBody{" +
                "productsOrder=" + productsOrder +
                ", totalPrice='" + totalPrice + '\'' +
                ", infoId='" + infoId + '\'' +
                '}';
    }

    public List<OptionAndQuantity> getProductsOrder() {
        return productsOrder;
    }

    public void setProductsOrder(List<OptionAndQuantity> productsOrder) {
        this.productsOrder = productsOrder;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
