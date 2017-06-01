package gov.xiangan.publicsanitation;

import android.app.Application;
import android.content.Context;

/**
 * Created by HuJiaCheng on 2017/3/9.
 */

public class MyApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getmContext() {
        return mContext;
    }
}
