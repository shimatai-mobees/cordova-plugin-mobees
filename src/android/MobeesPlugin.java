package br.com.mobees.parceiro.plugin;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

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
            callbackContext.success("" + hasPermission(Manifest.permission.ACCESS_FINE_LOCATION));

        } else if (action.equals("requestGpsPermission")) {

            ActivityCompat.requestPermissions(super.cordova.getActivity(), new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  }, 1000);
            callbackContext.success("requested");

        } else if (action.equals("isConnected")) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            callbackContext.success(isConnected + "");

            return true;
        } else if (action.equals("setUser")) {
            final String cpf = data.getString(0);
            final String authTk = data.getString(1);
            final SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPrefs.edit().putString("cpf", cpf).apply();
            sharedPrefs.edit().putString("authTk", authTk).apply();

            return true;
        } else if (action.equals("logout")) {
            final SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPrefs.edit().remove("cpf").apply();
            sharedPrefs.edit().remove("authTk").apply();
            callbackContext.success("true");
            
            return true;
        } else if (action.equals("hasNotificationPermission")) {
            callbackContext.success("" + NotificationManagerCompat.from(context).areNotificationsEnabled());
            return true;
        }

        return false;
    }

    private boolean hasPermission(final String permission) {
        return (ContextCompat.checkSelfPermission(super.cordova.getContext(), permission) != PackageManager.PERMISSION_GRANTED);
    }
}
