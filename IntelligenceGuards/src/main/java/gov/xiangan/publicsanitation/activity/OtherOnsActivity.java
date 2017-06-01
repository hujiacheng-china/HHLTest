package gov.xiangan.publicsanitation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;

import gov.xiangan.publicsanitation.R;

/**附加程序*/
public class OtherOnsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_otherons);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_otherons);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
