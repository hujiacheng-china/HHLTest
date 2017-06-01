package gov.xiangan.publicsanitation.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import gov.xiangan.publicsanitation.R;
import gov.xiangan.publicsanitation.utils.AutoPlayGallery;
import gov.xiangan.publicsanitation.utils.ImageAdapter;

/** 拍照 ，视频，录音 */
public class PhotographActivity extends Activity implements OnClickListener {
	private Spinner spinner;// 当前位置
	private List<String> spinner_list = new ArrayList<String>();// 当前位置数据
	private ImageButton photo_back;// 声明ImageButton控件
	private ArrayAdapter<String> spinner_adapter1;// 当前位置适配器

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_photo);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_photo);
		initData();
		initView();
		initListener();

	}

	/** 初始化数据 */
	private void initData() {
		spinner_list = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			spinner_list.add("厦门第一中学" + i);
		}

	}

	/** 初始化控件 */
	private void initView() {
		spinner = (Spinner) findViewById(R.id.photo_spinner1);
		photo_back = (ImageButton) findViewById(R.id.photo_back);// 返回按钮
		initAdv();// 初始化顶部图片
	}

	/** 初始化监听 */
	private void initListener() {
		photo_back.setOnClickListener(this);

		registerSpinner();// 注册当前位置下拉框

	}

	// 初始顶部图片
	private void initAdv() {
		AutoPlayGallery g = (AutoPlayGallery) findViewById(R.id.photo_autoGallery);
		ArrayList<Drawable> drawables = new ArrayList<Drawable>();
		drawables.add(getResources().getDrawable(R.drawable.banner));
		ImageAdapter adapter = new ImageAdapter(this, drawables);
		g.setAdapter(adapter);
	}

	// 为当前位置下拉框配置数据
	private void registerSpinner() {

		// 为下拉列表定义一个适配器。
		spinner_adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_list);
		// 为适配器设置下拉列表下拉时的菜单样式。
		spinner_adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将适配器添加到下拉列表上
		spinner.setAdapter(spinner_adapter1);
		// 为下拉列表设置各种事件的响应，这个事响应菜单被选中
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.photo_back:
			finish();
			break;

		default:
			break;
		}

	}

}
