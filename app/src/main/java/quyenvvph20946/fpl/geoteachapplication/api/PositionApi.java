package quyenvvph20946.fpl.geoteachapplication.api;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import quyenvvph20946.fpl.geoteachapplication.model.response.CityResponse;
import quyenvvph20946.fpl.geoteachapplication.model.response.DistrictResponse;
import quyenvvph20946.fpl.geoteachapplication.model.response.WardResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PositionApi {
    Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
    PositionApi API = new Retrofit.Builder()
            .baseUrl("https://vapi.vnappmob.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(PositionApi.class);

    @GET("province/")
    Call<CityResponse> getListCity();



    @GET("province/district/{province_id}")
    Call<DistrictResponse> getListDistrict(@Path("province_id") String provinceId);

    @GET("province/ward/{district_id}")
    Call<WardResponse> getListWard(@Path("district_id") String districtId);
}
