package gov.xiangan.publicsanitation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import gov.xiangan.publicsanitation.R;

public class WaringTipsInfoActivity extends Activity implements OnClickListener {
	private ImageButton waring_back;// 声明ImageButton控件

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_waring_info);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_waring);
		initData();
		initView();
		initListener();
	}

	private void initData() {
		// TODO Auto-generated method stub

	}

	private void initView() {
		waring_back = (ImageButton) findViewById(R.id.waring_back);
	}

	private void initListener() {
		waring_back.setOnClickListener(this);

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

}
