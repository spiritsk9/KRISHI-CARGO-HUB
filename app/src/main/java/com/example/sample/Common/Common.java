package com.example.sample.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.sample.Model.User;
import com.example.sample.Model.Driver;
import java.util.Calendar;
import java.util.Locale;

public class Common {

    public static String topicName = "News";

    public static User currentUser;
    public static User currentDriver;
    public static String currentKey;
    public static final String SHIPPER_INFO_TABLE = "ShippingOrders";

    public static String DISTANCE= "";
    public static String DURATION= "";
    public static String ESTIMATED_TIME = "";


    public static String PHONE_TEXT = "userPhone";


    private static final String BASE_URL = "https://fcm.googleapis.com/";
    private static final String GOOGLE_API_URL = "https://maps.googleapis.com/";




    public static final String DELETE = "Delete";
    public static final String USER_KEY = "User";
    public static final String Driver_KEY = "Driver";
    public static final String PWD_KEY = "password";



    public static boolean isConnectedToInternet(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager != null){

            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if(info != null){

                for(int i=0; i<info.length; i++){
                    if(info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false;
    }

    public static String getDate(long time)
    {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date = new StringBuilder(android.text.format.DateFormat.format("dd-MM-yyyy HH:mm"
                , calendar).toString());
        return date.toString();
    }

}
