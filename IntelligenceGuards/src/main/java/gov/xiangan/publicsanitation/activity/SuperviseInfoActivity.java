package gov.xiangan.publicsanitation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import gov.xiangan.publicsanitation.R;

public class SuperviseInfoActivity extends Activity implements OnClickListener {
	private ImageButton sup_back, sup_set;// 声明ImageButton控件

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_sup_info);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_sup);
		initData();
		initView();
		initListener();
	}

	private void initData() {
		// TODO Auto-generated method stub

	}

	private void initView() {
		sup_back = (ImageButton) findViewById(R.id.sup_back);
		sup_set = (ImageButton) findViewById(R.id.sup_set);
		sup_set.setVisibility(View.GONE);
	}

	private void initListener() {
		sup_back.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sup_back:
			finish();
			break;

		default:
			break;
		}
	}

}
