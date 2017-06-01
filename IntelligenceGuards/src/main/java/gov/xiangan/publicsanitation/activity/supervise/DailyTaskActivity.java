package gov.xiangan.publicsanitation.activity.supervise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gov.xiangan.publicsanitation.R;

/**
 * 主界面
 * @author HuJiaCheng on 2017/6/1
 */
public class DailyTaskActivity extends Activity {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.sp_place)
    Spinner spPlace;
    @Bind(R.id.sp_category)
    Spinner spCategory;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.ll_query)
    LinearLayout llQuery;
    @Bind(R.id.btn_licensed)
    Button btnLicensed;
    @Bind(R.id.btn_unlicensed)
    Button btnUnlicensed;

    private List<String> spinner_list1 = new ArrayList<String>();// 监督专业下拉框数据
    private List<String> spinner_list2 = new ArrayList<String>();// 监督类别下拉框数据
    private ArrayAdapter<String> spinner_adapter1;// 监督专业下拉框适配器
    private ArrayAdapter<String> spinner_adapter2;// 监督类别下拉框适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailytask);
        ButterKnife.bind(this);
        init();
    }

    /**
     * 初始化数据
     */
    private void init() {
        spinner_list1 = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            spinner_list1.add("公共场所" + i);
        }
        spinner_list2 = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            spinner_list2.add("类别" + i);
        }
        registerSpinner1();// 注册监督专业下拉框
        registerSpinner2();// 注册监督类别下拉框
    }

    /**
     * 为监督专业下拉框配置数据
     */
    private void registerSpinner1() {
        // 为下拉列表定义一个适配器。
        spinner_adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_list1);
        // 为适配器设置下拉列表下拉时的菜单样式。
        //spinner_adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 将适配器添加到下拉列表上
        spPlace.setAdapter(spinner_adapter1);
        // 为下拉列表设置各种事件的响应，这个事响应菜单被选中
        spPlace.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

    /**
     * 为监督专业下拉框配置数据
     */
    private void registerSpinner2() {
        // 为下拉列表定义一个适配器。
        spinner_adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_list2);
        // 为适配器设置下拉列表下拉时的菜单样式。
        //spinner_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 将适配器添加到下拉列表上
        spCategory.setAdapter(spinner_adapter2);
        // 为下拉列表设置各种事件的响应，这个事响应菜单被选中
        spCategory.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

    /**
     * 点击监听
     * @param view
     */
    @OnClick({R.id.iv_back, R.id.ll_query, R.id.btn_licensed, R.id.btn_unlicensed})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_query:
                startActivity(new Intent(DailyTaskActivity.this,SuperviseQueryActivity.class));
                break;
            case R.id.btn_licensed:
                break;
            case R.id.btn_unlicensed:
                break;
        }
    }
}
