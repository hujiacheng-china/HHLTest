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
import gov.xiangan.publicsanitation.adapter.QuickCheckListAdapter;
import gov.xiangan.publicsanitation.entity.Model;

/** 现场快检 */
public class QuickCheckActivity extends Activity implements OnClickListener {
	private ListView listView;// 声明ListView控件
	private QuickCheckListAdapter listAdapter;// 声明ListAdapter适配器
	private ImageButton quickcheck_back;// 声明ImageButton控件
	private List<Model> models; // 声明models类

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_quickcheck);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_quickcheck);
		initData();
		initView();
		initListener();
	}

	/** 初始化数据 */
	private void initData() {
		// 模拟数据
		models = new ArrayList<Model>();
		Model model;
		for (int i = 0; i < 15; i++) {
			model = new Model();
			model.setSt("张珊珊" + i);
			model.setIscheck(false);
			model.setYy("卫生抽检" + i);
			models.add(model);
		}
	}

	/** 初始化控件 */
	private void initView() {
		listView = (ListView) findViewById(R.id.quickcheck_listView);
		quickcheck_back = (ImageButton) findViewById(R.id.quickcheck_back);

	}

	/** 初始化监听 */
	private void initListener() {
		quickcheck_back.setOnClickListener(this);
		listAdapter = new QuickCheckListAdapter(this, models);
		listView.setAdapter(listAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// Intent intent = new Intent();
				// startActivity(intent);

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
		case R.id.quickcheck_back:
			finish();
			break;

		default:
			break;
		}

	}

}
