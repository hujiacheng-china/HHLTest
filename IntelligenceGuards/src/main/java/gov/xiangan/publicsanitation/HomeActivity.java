package gov.xiangan.publicsanitation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gov.xiangan.publicsanitation.activity.CheckRandomActivity;
import gov.xiangan.publicsanitation.activity.supervise.DailyTaskActivity;
import gov.xiangan.publicsanitation.activity.FileQueryActivity;
import gov.xiangan.publicsanitation.activity.LoginActivity;
import gov.xiangan.publicsanitation.activity.MapActivity;
import gov.xiangan.publicsanitation.activity.OtherOnsActivity;
import gov.xiangan.publicsanitation.activity.PhotographActivity;
import gov.xiangan.publicsanitation.activity.QuickCheckActivity;
import gov.xiangan.publicsanitation.activity.SuperviseTaskActivity;
import gov.xiangan.publicsanitation.activity.WarningTipsActivity;
import gov.xiangan.publicsanitation.utils.AutoPlayGallery;
import gov.xiangan.publicsanitation.utils.ImageAdapter;
import gov.xiangan.publicsanitation.utils.ToastUtil;

/**
 * 主界面
 * @author HuJiaCheng on 2017/6/1
 */
public class HomeActivity extends Activity {

    @Bind(R.id.home_title_item)
    ImageView homeTitleItem;
    @Bind(R.id.autoGallery)
    AutoPlayGallery autoGallery;
    @Bind(R.id.cv_task)
    CardView cvTask;
    @Bind(R.id.cv_warn)
    CardView cvWarn;
    @Bind(R.id.cv_query)
    CardView cvQuery;
    @Bind(R.id.cv_map)
    CardView cvMap;
    @Bind(R.id.cv_more)
    CardView cvMore;
    @Bind(R.id.cv_double_check)
    CardView cvDoubleCheck;
    @Bind(R.id.cv_supervise)
    CardView cvSupervise;
    @Bind(R.id.cv_camera)
    CardView cvCamera;
    @Bind(R.id.cv_check)
    CardView cvCheck;
    private long exitTime = 0;  //退出响应时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initAdv();
    }
    /**
     * 初始化广告
     */
    private void initAdv() {
        AutoPlayGallery g = (AutoPlayGallery) findViewById(R.id.autoGallery);
        ArrayList<Drawable> drawables = new ArrayList<Drawable>();
        drawables.add(getResources().getDrawable(R.drawable.banner));
        drawables.add(getResources().getDrawable(R.drawable.banner));
        drawables.add(getResources().getDrawable(R.drawable.banner));
        ImageAdapter adapter = new ImageAdapter(this, drawables);
        g.setAdapter(adapter);
    }

    /**
     * 初始化点击事件
     * @param view
     */
    @OnClick({R.id.home_title_item, R.id.cv_task, R.id.cv_warn, R.id.cv_query, R.id.cv_map, R.id.cv_more, R.id.cv_double_check, R.id.cv_supervise, R.id.cv_camera, R.id.cv_check})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_title_item:
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                break;
            case R.id.cv_task:
                startActivityDelayed(SuperviseTaskActivity.class);
                break;
            case R.id.cv_warn:
                startActivityDelayed(WarningTipsActivity.class);
                break;
            case R.id.cv_query:
                startActivityDelayed(FileQueryActivity.class);
                break;
            case R.id.cv_map:
                startActivityDelayed(MapActivity.class);
                break;
            case R.id.cv_more:
                startActivityDelayed(OtherOnsActivity.class);
                break;
            case R.id.cv_double_check:
                startActivityDelayed(CheckRandomActivity.class);
                break;
            case R.id.cv_supervise:
                startActivityDelayed(DailyTaskActivity.class);
                break;
            case R.id.cv_camera:
                startActivityDelayed(PhotographActivity.class);
                break;
            case R.id.cv_check:
                startActivityDelayed(QuickCheckActivity.class);
                break;
        }
    }

    private void startActivityDelayed(final Class clazz){
        homeTitleItem.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(HomeActivity.this, clazz));
            }
        },300);
    }

    /**
     * 重写返回事件
     */
    @Override
    public void onBackPressed() {// 捕获返回按键
        exitDialog(HomeActivity.this, "提示", "亲！您真的要退出吗？");
    }

    /**
     * 退出对话框
     * @param context
     * @param title
     * @param msg
     */
    private void exitDialog(Context context, String title, String msg) {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            ToastUtil.show("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

}
