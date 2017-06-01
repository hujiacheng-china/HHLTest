package gov.xiangan.publicsanitation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import gov.xiangan.publicsanitation.R;
import gov.xiangan.publicsanitation.entity.Model;

/**
 * 现场快检
 * 
 * @author hhl
 * 
 */
public class QuickCheckListAdapter extends BaseAdapter {
	private List<Model> data;// 传入全选类
	private Context mContext;
	private LayoutInflater mInflater;
	// default selected item
	private int mSelectedPos = 0;

	public QuickCheckListAdapter(Context context, List<Model> data) {
		super();
		this.data = data;
		this.mContext = context;
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
			convertView = mInflater.inflate(R.layout.list_item_quickcheck, parent, false);
			hd = new ViewHoder();
			hd.textView1 = (TextView) convertView.findViewById(R.id.quickcheck_txtle);
			hd.textView2 = (TextView) convertView.findViewById(R.id.quickcheck_txtxme);
			convertView.setTag(hd);
		}
		Model mModel = data.get(position);
		hd = (ViewHoder) convertView.getTag();
		hd.textView1.setText(mModel.getSt());
		hd.textView2.setText(mModel.getYy());
		return convertView;
	}

	public void setSelectedPos(int position) {
		this.mSelectedPos = position;
		notifyDataSetChanged();
	}

	class ViewHoder {
		TextView textView1,textView2;
	}
}
