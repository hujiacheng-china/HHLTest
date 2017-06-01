package gov.xiangan.publicsanitation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import gov.xiangan.publicsanitation.R;
import gov.xiangan.publicsanitation.adapter.CheckRandomListAdapter;

/** 双随机检查 */
public class CheckRandomActivity extends Activity implements OnClickListener, OnItemClickListener {
	private List<String> list;// 双随机检查数据
	private ListView listView;// 声明ListView控件
	private CheckRandomListAdapter listAdapter;// 声明MapListAdapter适配器
	private ImageButton checkrandom_back;// 声明ImageButton控件

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_checkrandom);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_checkrandom);
		initData();
		initView();
		initListener();
	}

	// 初始化数据
	private void initData() {
		list = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			list.add("厦门第一中学" + i);
		}

	}

	// 初始化控件
	private void initView() {
		listView = (ListView) findViewById(R.id.checkrandom_listView);
		checkrandom_back = (ImageButton) findViewById(R.id.checkrandom_back);// 返回按钮
		listAdapter = new CheckRandomListAdapter(this, list);
	}

	// 初始化监听
	private void initListener() {
		checkrandom_back.setOnClickListener(this);
		listView.setAdapter(listAdapter);
		listView.setOnItemClickListener(this);
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
		case R.id.checkrandom_back:
			finish();
			break;

		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}
