package com.webmingo.serviingovendors.Util;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class util {


    public static void showMessageOKCancel(String message, Activity activity, Boolean aBoolean, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton("OKAY", okListener)
                .setCancelable(aBoolean)
                .create()
                .show();
    }
    public static boolean isOnline(Context ctx) {

        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        if (ctx != null) {
            ConnectivityManager cm = (ConnectivityManager) ctx
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo[] netInfo = cm.getAllNetworkInfo();
                for (NetworkInfo ni : netInfo) {

                    if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                        if (ni.isConnected())
                            haveConnectedWifi = true;
                    if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                        if (ni.isConnected())
                            haveConnectedMobile = true;
                }
            }
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public static String getTime(String dateTime) {
        String times = "";
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date d = f.parse(dateTime);

            DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
            DateFormat time = new SimpleDateFormat("hh:mm:ss a");
            System.out.println("Date: " + date.format(d));
            System.out.println("Time: " + time.format(d));//09:00:00 am

            String[] word = time.format(d).split(":");
            times = times + word[0] + ":" + word[1] + " " + word[2].split(" ")[1];

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }

    public static String getDate(String dateTime) {
        String dateStr = "";
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date d = f.parse(dateTime);

            DateFormat date = new SimpleDateFormat("EEE, d MMM yyyy");
//            System.out.println("Date: " + date.format(d));
            dateStr = date.format(d);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateStr;
    }



    public static void hideKeyboard(View view, Context context) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception ignored) {
        }
    }



    public static void Permission(Context context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
    }

    public  static void showSettingsDialog(Activity context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings(context);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                context.finish();
            }
        });
        builder.show();

    }
    // navigating user to app settings
    public static void openSettings(Activity context) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        context.startActivityForResult(intent, 101);
    }


    public static void checkDexter(Activity activity)
    {
        Dexter.withContext(activity.getApplicationContext())
                .withPermissions(Manifest.permission.CAMERA ,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        if (multiplePermissionsReport.areAllPermissionsGranted()) {
                            // do you work now
                         //   Toast.makeText(activity, "Granted", Toast.LENGTH_SHORT).show();

                            Permission(activity);
                        }

                        // check for permanent denial of any permission
                        if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied()) {
                            // permission is denied permenantly, navigate user to app settings
                            Toast.makeText(activity, "Denied", Toast.LENGTH_SHORT).show();
                            showSettingsDialog(activity);
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).onSameThread()
                .check();

    }
}