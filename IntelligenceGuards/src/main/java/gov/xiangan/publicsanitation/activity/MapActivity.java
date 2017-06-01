package gov.xiangan.publicsanitation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import gov.xiangan.publicsanitation.R;
import gov.xiangan.publicsanitation.adapter.MapListAdapter;

/** 地图 */
public class MapActivity extends Activity implements OnClickListener, OnItemClickListener {
	private List<String> list;// 地图数据
	private ListView listView;// 声明ListView控件
	private MapListAdapter listAdapter;// 声明MapListAdapter适配器
	private ImageButton map_back;// 声明ImageButton控件
	private Button map_maps;// 声明Button控件

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_map);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_map);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		initData();
		initView();
		initListener();
	}

	// 初始化数据
	private void initData() {
		list = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			list.add("0592-88666" + i);
		}

	}

	// 初始化控件
	private void initView() {
		listView = (ListView) findViewById(R.id.map_listView);
		map_back = (ImageButton) findViewById(R.id.map_back);// 返回按钮
		map_maps = (Button) findViewById(R.id.map_maps);// 地图模式
		listAdapter = new MapListAdapter(this, list);
	}

	// 初始化监听
	private void initListener() {
		map_back.setOnClickListener(this);
		map_maps.setOnClickListener(this);
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
		case R.id.map_back:
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
