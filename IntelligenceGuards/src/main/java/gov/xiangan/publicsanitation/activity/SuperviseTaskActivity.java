package gov.xiangan.publicsanitation.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import gov.xiangan.publicsanitation.R;
import gov.xiangan.publicsanitation.adapter.SupListAdapter;

/** 监督任务 */
public class SuperviseTaskActivity extends Activity implements OnClickListener {
	private Button button1, button2;// 声明ImageView控件
	private List<String> suplist;// 监督任务数据
	private ListView listView;// 声明ListView控件
	private SupListAdapter supListAdapter;// 声明SupListAdapter适配器
	private ImageButton sup_back, sup_set;// 声明ImageButton控件
	private boolean btn_1_order = false;// 排序默认降序
	private boolean btn_2_order = false;// 排序默认降序

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_suptask);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_sup);
		initData();
		initView();
		initListener();
	}

	// 初始化数据
	private void initData() {
		suplist = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			suplist.add("A" + i);
		}

	}

	// 初始化控件
	private void initView() {
		button1 = (Button) findViewById(R.id.sup_btn_1);
		button2 = (Button) findViewById(R.id.sup_btn_2);
		listView = (ListView) findViewById(R.id.sup_listView);
		sup_back = (ImageButton) findViewById(R.id.sup_back);
		sup_set = (ImageButton) findViewById(R.id.sup_set);
		supListAdapter = new SupListAdapter(this, suplist);
	}

	// 初始化监听
	private void initListener() {
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		sup_back.setOnClickListener(this);
		listView.setAdapter(supListAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent = new Intent(SuperviseTaskActivity.this, SuperviseInfoActivity.class);
				startActivity(intent);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sup_back:
			finish();
			break;
		case R.id.sup_btn_1:
			if (!btn_1_order) {
				Drawable top = getResources().getDrawable(R.drawable.top);
				top.setBounds(0, 0, top.getMinimumWidth(), top.getMinimumHeight());
				button1.setCompoundDrawables(null, null, top, null);
				btn_1_order = true;
			} else {
				Drawable bottom = getResources().getDrawable(R.drawable.bottom);
				bottom.setBounds(0, 0, bottom.getMinimumWidth(), bottom.getMinimumHeight());
				button1.setCompoundDrawables(null, null, bottom, null);
				btn_1_order = false;
			}
			break;
		case R.id.sup_btn_2:
			if (!btn_2_order) {
				Drawable top = getResources().getDrawable(R.drawable.top);
				top.setBounds(0, 0, top.getMinimumWidth(), top.getMinimumHeight());
				button2.setCompoundDrawables(null, null, top, null);
				btn_2_order = true;
			} else {
				Drawable bottom = getResources().getDrawable(R.drawable.bottom);
				bottom.setBounds(0, 0, bottom.getMinimumWidth(), bottom.getMinimumHeight());
				button2.setCompoundDrawables(null, null, bottom, null);
				btn_2_order = false;

			}
			break;
		default:
			break;
		}
	}

}
