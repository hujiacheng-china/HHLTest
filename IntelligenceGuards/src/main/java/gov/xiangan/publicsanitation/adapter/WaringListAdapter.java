package gov.xiangan.publicsanitation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import gov.xiangan.publicsanitation.R;
import gov.xiangan.publicsanitation.activity.WaringTipsInfoActivity;
import gov.xiangan.publicsanitation.activity.WarningTipsActivity;
import gov.xiangan.publicsanitation.entity.Model;

/**
 * 预警提示
 * 
 * @author hhl
 * 
 */
public class WaringListAdapter extends BaseAdapter {
	private List<Model> data;// 传入全选类
	private Context mContext;
	private LayoutInflater mInflater;
	private WarningTipsActivity.AllCheckListener allCheckListener;
	// default selected item
	private int mSelectedPos = 0;
	

	public WaringListAdapter(Context context, List<Model> data, WarningTipsActivity.AllCheckListener allCheckListener) {
		super();
		this.data = data;
		this.mContext = context;
		this.allCheckListener = allCheckListener;
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return (null == data) ? 0 : data.size();
	}

	@Override
	public Model getItem(int position) {
		return (null == data) ? null : data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHoder hd;
		if (null == mContext) {
			return null;
		}

		if (null == data || data.size() == 0 || data.size() <= position) {
			return null;
		}

		if (null == convertView) {
			convertView = mInflater.inflate(R.layout.list_item_waring, parent, false);
			hd = new ViewHoder();
			hd.textView = (TextView) convertView.findViewById(R.id.waring_txtze);
			hd.checkBox = (CheckBox) convertView.findViewById(R.id.waring_checkbox);
			hd.button = (Button) convertView.findViewById(R.id.waring_itemsend);
			convertView.setTag(hd);
		}
		Model mModel = data.get(position);
		hd = (ViewHoder) convertView.getTag();
		hd.textView.setText(mModel.getSt());
		if (position % 2 == 0) {
			hd.button.setBackgroundResource(R.drawable.shape_btn_red1);
			hd.button.setText("发送失败");
		} else if (position % 3 == 0) {
			hd.button.setBackgroundResource(R.drawable.shape_btn_blue);
			hd.button.setText("发送成功");
		}

		hd.button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "--waring", 1).show();

			}
		});
		final ViewHoder hdFinal = hd;
		hd.checkBox.setChecked(mModel.ischeck());
		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				 long exitTime = 0;// 点击响应时间
				if ((System.currentTimeMillis() - exitTime) > 2000) {
					exitTime = System.currentTimeMillis();
					Toast.makeText(mContext, "再按一次进入详情", 0).show();
					CheckBox checkBox = hdFinal.checkBox;
					if (checkBox.isChecked()) {
						checkBox.setChecked(false);
						data.get(position).setIscheck(false);
					} else {
						checkBox.setChecked(true);
						data.get(position).setIscheck(true);
					}
					// 监听每个item，若所有checkbox都为选中状态则更改main的全选checkbox状态
					for (Model model : data) {
						if (!model.ischeck()) {
							allCheckListener.onCheckedChanged(false);
							return;
						}
					}
					allCheckListener.onCheckedChanged(true);

				} else {
					Intent intent = new Intent(mContext, WaringTipsInfoActivity.class);
					mContext.startActivity(intent);
				}
			}

		});

		// hd.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener()
		// {
		//
		// @Override
		// public void onCheckedChanged(CompoundButton buttonView, boolean
		// isChecked) {
		// if (isChecked) {
		// data.get(position).setIscheck(false);
		// } else {
		// data.get(position).setIscheck(true);
		// }
		// // 监听每个item，若所有checkbox都为选中状态则更改main的全选checkbox状态
		// for (Model model : data) {
		// if (!model.ischeck()) {
		// allCheckListener.onCheckedChanged(false);
		// return;
		// }
		// }
		// allCheckListener.onCheckedChanged(true);
		//
		// }
		// });
		return convertView;
	}

	public void setSelectedPos(int position) {
		this.mSelectedPos = position;
		notifyDataSetChanged();
	}

	class ViewHoder {
		TextView textView;
		CheckBox checkBox;
		Button button;
	}
}
