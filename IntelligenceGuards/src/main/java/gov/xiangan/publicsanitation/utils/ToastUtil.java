package gov.xiangan.publicsanitation.utils;

import android.widget.Toast;

import gov.xiangan.publicsanitation.MyApplication;

/**
 * Created by HuJiaCheng on 2017/6/1.
 */

public class ToastUtil {
    public static void show(String msg){
        Toast.makeText(MyApplication.getmContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
