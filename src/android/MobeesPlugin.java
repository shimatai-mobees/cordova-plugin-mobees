package br.com.mobees.parceiro.plugin;

import android.content.Context;
import android.location.LocationManager;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class MobeesPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("greet")) {

            String name = data.getString(0);
            String message = "Hi, " + name;
            callbackContext.success(message);

            return true;

        } else if (action.equals("isGpsEnabled")) {
            final LocationManager manager = (LocationManager)  super.cordova.getContext().getSystemService(Context.LOCATION_SERVICE );
            callbackContext.success(manager.isProviderEnabled(LocationManager.GPS_PROVIDER) + "");

            return true;
        } else {
            return false;
        }
    }
}
