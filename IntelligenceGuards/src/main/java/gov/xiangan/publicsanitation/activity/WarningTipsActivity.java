package gov.xiangan.publicsanitation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import gov.xiangan.publicsanitation.R;
import gov.xiangan.publicsanitation.adapter.WaringListAdapter;
import gov.xiangan.publicsanitation.entity.Model;

/** 预警提示 */
public class WarningTipsActivity extends Activity implements OnClickListener {
	// private List<String> waringlist;// 预警提示数据
	private ListView listView;// 声明ListView控件
	private WaringListAdapter waringListAdapter;// 声明waringlistAdapter适配器
	private ImageButton waring_back;// 声明ImageButton控件
	private CheckBox checkBox; // 声明checkBox控件
	private List<Model> models; // 声明models类
	public boolean mIsFromItem = false; // 监听来源

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_waring);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_waring);
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
			model.setSt(i + "******");
			model.setIscheck(false);
			model.setYy("营业执照" + i);
			models.add(model);
		}
	}

	/** 初始化控件 */
	private void initView() {
		listView = (ListView) findViewById(R.id.waring_listView);
		waring_back = (ImageButton) findViewById(R.id.waring_back);
		checkBox = (CheckBox) findViewById(R.id.waring_checkBox1);

	}

	/** 初始化监听 */
	private void initListener() {
		waring_back.setOnClickListener(this);
		waringListAdapter = new WaringListAdapter(this, models, new AllCheckListener() {

			@Override
			public void onCheckedChanged(boolean b) {
				// 根据不同的情况对checkBox做处理
				if (!b && !checkBox.isChecked()) {
					return;
				} else if (!b && checkBox.isChecked()) {
					mIsFromItem = true;
					checkBox.setChecked(false);
				} else if (b) {
					mIsFromItem = true;
					checkBox.setChecked(true);
				}
			}
		});
		listView.setAdapter(waringListAdapter);
//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//				Intent intent = new Intent(WarningTipsActivity.this, WaringTipsInfoActivity.class);
//				startActivity(intent);
//
//			}
//		});

		// 全选的点击监听
		checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				// 当监听来源为点击item改变maincbk状态时不在监听改变，防止死循环
				if (mIsFromItem) {
					mIsFromItem = false;
					Log.e("mainCheckBox", "此时我不可以触发");
					return;
				}

				// 改变数据
				for (Model model : models) {
					model.setIscheck(b);
				}
				// 刷新listview
				waringListAdapter.notifyDataSetChanged();
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
		case R.id.waring_back:
			finish();
			break;

		default:
			break;
		}

	}

	// 对item导致maincheckbox改变做监听
	public interface AllCheckListener {
		void onCheckedChanged(boolean b);
	}
}
