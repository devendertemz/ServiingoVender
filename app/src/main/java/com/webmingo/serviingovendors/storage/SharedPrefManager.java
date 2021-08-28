package com.webmingo.serviingovendors.storage;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private Context mCtx;
    private static final String SHARED_PREF_NAME = "my_shared_preff";


    private static final String SHARED_PREF_NAME2 = "my_shared_preff2";


    public SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }

    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(mCtx);

        }
        return mInstance;
    }

    public void saveuser(User_login user_login) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("loginid", user_login.getLoginid());

        editor.putString("id", user_login.getId());
        editor.putString("fullname", user_login.getFullname());
        editor.putString("phone", user_login.getPhone());
        editor.putString("email", user_login.getEmail());
        editor.putString("role", user_login.getRole());
        editor.putString("access_token", user_login.getAccess_token());
        editor.apply();

    }

    public void OrderId(String idd, String addon_service_ids, String Quentiy) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("idd", idd);
        editor.putString("addon_service_ids", addon_service_ids);
        editor.putString("Quentiy", Quentiy);
        editor.apply();

    }

    public void OrderDetails(String package_id, String pack_quantity) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("package_id", package_id);
        editor.putString("pack_quantity", pack_quantity);
        editor.apply();
    }


    public String getpackage_id() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("package_id", null);

    }

    public void AddonseDetails(String Addonsepackage_id,String  Addonsequantity) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Addonsepackage_id", Addonsepackage_id);
        editor.putString("Addonsequantity", Addonsequantity);
        editor.apply();
    }
    public void CityIDDetails(String CityID) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("CityID", CityID);
        editor.apply();
    }
    public void categoriesID(String categoriesID) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("categoriesID", categoriesID);

        editor.apply();
    }

    public String getcategoriesID() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("categoriesID", null);

    }
    public String Addonsegetpackage_id() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Addonsepackage_id", null);

    }

    public String GetCityid() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("CityID", null);

    }
    public String Addonsequantityid() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Addonsequantity", null);

    }
    public String getpack_quantity() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("pack_quantity", null);

    }

    public static synchronized SharedPrefManager getInstans(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public String getUserId() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("id", null);

    }

    public String getIdd() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("idd", null);

    }

    public String getaddon_service_ids() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("addon_service_ids", null);

    }

    public String getQuentiy() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Quentiy", null);

    }

    public String getNumber() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("phone", null);

    }

    public String getfullname() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("fullname", null);

    }

    public String getemail() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("email", null);

    }

    public String getrole() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("role", null);

    }


    public String getaccess_token() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("access_token", null);

    }

    public boolean isLoggedin() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("loginid", -1) != -1;
    }

    public void clear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


    public void pacakgeClear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
