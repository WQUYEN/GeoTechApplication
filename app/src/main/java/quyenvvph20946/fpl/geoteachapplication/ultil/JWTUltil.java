package quyenvvph20946.fpl.geoteachapplication.ultil;

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

import quyenvvph20946.fpl.geoteachapplication.model.DataToken;

public class JWTUltil {
    public static DataToken decoded(String JWTEncoded) {
        try {
            String [] split = JWTEncoded.split("\\.");
            Log.d(Tag.toString,"Header:"  + getJson(split[0]));
            Log.d(Tag.toString,"Header:"  + getJson(split[1]));
            Gson gson = new Gson();
            DataToken dataToken = gson.fromJson(getJson(split[1]), DataToken.class);
            return dataToken;
        } catch (UnsupportedEncodingException e) {
            return new DataToken();
        }
    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException{
        byte [] decodeBytes = Base64.decode(strEncoded,Base64.URL_SAFE);
        return new String (decodeBytes,"UTF-8");
    }
}