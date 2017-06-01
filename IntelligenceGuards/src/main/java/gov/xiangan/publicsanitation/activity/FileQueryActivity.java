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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import gov.xiangan.publicsanitation.R;
import gov.xiangan.publicsanitation.adapter.FileQueryListAdapter;

/** 档案查询 */
public class FileQueryActivity extends Activity implements OnClickListener {
	// private ImageView imageView1, imageView2;// 声明ImageView控件
	private List<String> fileqlist;// 档案查询数据
	private ListView listView;// 声明ListView控件
	private FileQueryListAdapter fileqListAdapter;// 声明SupListAdapter适配器
	private ImageButton fileq_back, fileq_set;// 声明ImageButton控件
	private List<String> spinner_list1 = new ArrayList<String>();// 监督专业下拉框数据
	private List<String> spinner_list2 = new ArrayList<String>();// 监督类别下拉框数据
	private Spinner spinner1, spinner2;// spinner1-监督专业、spinner2-监督类别
	private ArrayAdapter<String> spinner_adapter1;
	private ArrayAdapter<String> spinner_adapter2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_filequery);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_filequery);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		initData();
		initView();
		initListener();
	}

	/** 初始化数据 */
	private void initData() {
		fileqlist = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			fileqlist.add("张珊珊" + i);
		}
		spinner_list1 = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			spinner_list1.add("公共场所" + i);
		}
		spinner_list2 = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			spinner_list2.add("类别" + i);
		}

	}

	/** 初始化控件 */
	private void initView() {
		spinner1 = (Spinner) findViewById(R.id.spinner_fileq1);
		spinner2 = (Spinner) findViewById(R.id.spinner_fileq2);
		listView = (ListView) findViewById(R.id.filequery_listView);
		fileq_back = (ImageButton) findViewById(R.id.fileq_back);
		fileq_set = (ImageButton) findViewById(R.id.image_fileqset);
		fileqListAdapter = new FileQueryListAdapter(this, fileqlist);
	}

	/** 初始化监听 */
	private void initListener() {
		fileq_back.setOnClickListener(this);
		listView.setAdapter(fileqListAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// Intent intent = new Intent();
				// startActivity(intent);

			}
		});

		registerSpinner1();// 注册监督专业下拉框
		registerSpinner2();// 注册监督类别下拉框

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// 为监督专业下拉框配置数据
	private void registerSpinner1() {

		// 为下拉列表定义一个适配器。
		spinner_adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_list1);
		// 为适配器设置下拉列表下拉时的菜单样式。
		spinner_adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将适配器添加到下拉列表上
		spinner1.setAdapter(spinner_adapter1);
		// 为下拉列表设置各种事件的响应，这个事响应菜单被选中
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	// 为监督类别下拉框配置数据
	private void registerSpinner2() {
		// 为下拉列表定义一个适配器。
		spinner_adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_list2);
		// 为适配器设置下拉列表下拉时的菜单样式。
		spinner_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将适配器添加到下拉列表上
		spinner2.setAdapter(spinner_adapter2);
		// 为下拉列表设置各种事件的响应，这个事响应菜单被选中
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fileq_back:
			finish();
			break;

		default:
			break;
		}

	}

}
