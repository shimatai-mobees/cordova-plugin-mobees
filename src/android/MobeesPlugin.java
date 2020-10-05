package br.com.mobees.parceiro.plugin;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class MobeesPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        final Context context = super.cordova.getContext();

        if (action.equals("toast")) {

            String message = data.getString(0);
            callbackContext.success(message);
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();

            return true;

        } else if (action.equals("isGpsEnabled")) {
            final LocationManager manager = (LocationManager)  context.getSystemService(Context.LOCATION_SERVICE );
            callbackContext.success(manager.isProviderEnabled(LocationManager.GPS_PROVIDER) + "");

            return true;
        } else if (action.equals("hasGpsPermission")) {
            callbackContext.success("" + hasGpsPermission());

        } else if (action.equals("requestGpsPermission")) {

            ActivityCompat.requestPermissions(super.cordova.getActivity(), new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  }, 1000);
            callbackContext.success("requested");

        } else if (action.equals("isConnected")) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            callbackContext.success(isConnected + "");

            return true;
        }

        return false;
    }

    private boolean hasGpsPermission() {
        return (ContextCompat.checkSelfPermission(super.cordova.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED);
    }
}
