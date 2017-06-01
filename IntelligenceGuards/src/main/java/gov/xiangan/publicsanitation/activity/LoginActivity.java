package gov.xiangan.publicsanitation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import gov.xiangan.publicsanitation.R;
import gov.xiangan.publicsanitation.ctrl.Constants;
import gov.xiangan.publicsanitation.utils.Code;
import gov.xiangan.publicsanitation.utils.HttpClientUtil;

public class LoginActivity extends Activity implements OnClickListener {
	private EditText lgoin_accounts, login_password;
	private ImageView vc_image;
	private EditText vc_code;
	private String getCode = null;
	private Button login_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.login_);
		lgoin_accounts = (EditText) findViewById(R.id.lgoin_accounts);
		login_password = (EditText) findViewById(R.id.login_password);
		vc_image = (ImageView) findViewById(R.id.vc_image);
		vc_image.setImageBitmap(Code.getInstance().getBitmap());
		vc_code = (EditText) findViewById(R.id.vc_code);
		login_btn = (Button) findViewById(R.id.login_btn);
		login_btn.setOnClickListener(this);
		vc_image.setOnClickListener(this);
		vc_code.setOnClickListener(this);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}

	public void tip(View view) {
		Toast.makeText(this, "����������ⲿ�رմ���~", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_btn:
			//
			// String v_code = vc_code.getText().toString().trim();
			// if (v_code == null || v_code.equals("")) {
			// Toast.makeText(LoginActivity.this, "û����д��֤��", 1).show();
			// } else if (!v_code.equals(getCode)) {
			// Toast.makeText(LoginActivity.this, "��֤����д����ȷ", 1).show();
			// } else {
			// // submit();
			// }
			// vc_image.setImageBitmap(Code.getInstance().getBitmap());
			// getCode = Code.getInstance().getCode();
			getPOST(Constants.URL + "/wisdom-api/login");
			break;
		case R.id.vc_image:
			vc_image.setImageBitmap(Code.getInstance().getBitmap());
			getCode = Code.getInstance().getCode();
			break;

		default:
			break;
		}

	}

	public void getPOST(String uri) {
		RequestParams params = new RequestParams();
		try {
			params.put("username", "hhl");
			params.put("password", "DmT5EYhr8sghDyRKn1BjVg==");
			HttpClientUtil.post(uri, params, new AsyncHttpResponseHandler() {

				@Override
				public void onStart() {
					super.onStart();
				}

				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					String json = new String(responseBody);
					try {
						JSONObject jsonObject = new JSONObject(json);
						String code = jsonObject.getString("code");
						String message = jsonObject.getString("message");
					} catch (JSONException e) {
						e.printStackTrace();
					}
					Toast.makeText(LoginActivity.this, json, 1).show();
					;
					// System.out.println("responseBody=" + new
					// String(responseBody));
				}

				@Override
				public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//					
//					String s="";
//					s=new String(responseBody);
					Toast.makeText(LoginActivity.this, "onFailure="+statusCode +","+headers, 1).show();
				}

				@Override
				public void onFinish() {
					super.onFinish();
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
