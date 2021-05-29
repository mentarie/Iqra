package proyek.android.iqra.apihelper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveSharedPreference {
    //simpan status login
    public static final String LOGGED_IN_PREF = "logged_in_status";
    public static String KEY_USERNAME = "username";
    public static String KEY_EMAIL = "email";
    public static String KEY_ID = "id";

    public static String KEY_TOKEN = "token";

    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    public static void setLoggedIn(Context context, boolean loggedIn, String username, String email, String id, String token) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_ID, id);
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    public static void setUpdateUsername(Context context, boolean loggedIn, String username){
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    public static void setUpdateEmail(Context context, boolean loggedIn, String email){
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    public static void setLoggedOut(Context context, boolean loggedIn){
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.apply();
    }

    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false);
    }

    public static void setKeyToken(Context context, boolean loggedIn, String keyToken) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.putString(KEY_TOKEN, keyToken);
        editor.apply();
    }
}
