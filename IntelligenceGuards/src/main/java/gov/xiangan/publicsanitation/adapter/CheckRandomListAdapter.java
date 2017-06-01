package gov.xiangan.publicsanitation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import gov.xiangan.publicsanitation.R;

/**
 * 双随机抽查
 * 
 * @author hhl
 * 
 */
public class CheckRandomListAdapter extends BaseAdapter {

	private Context mContext;
	private List<String> lists;
	private LayoutInflater mInflater;
	private int mSelectedPos = 0;

	public CheckRandomListAdapter(Context context, List<String> list) {
		super();
		this.mContext = context;
		this.lists = list;
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return (null == lists) ? 0 : lists.size();
	}

	@Override
	public String getItem(int position) {
		return (null == lists) ? null : lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHoder hd;
		if (null == mContext) {
			return null;
		}

		if (null == lists || lists.size() == 0 || lists.size() <= position) {
			return null;
		}

		if (null == convertView) {
			convertView = mInflater.inflate(R.layout.list_item_checkrandom, parent, false);
			hd = new ViewHoder();
			hd.textView1 = (TextView) convertView.findViewById(R.id.checkrandom_txtle);
			hd.textView2 = (TextView) convertView.findViewById(R.id.checkrandom_txtde);
			convertView.setTag(hd);
		}
		hd = (ViewHoder) convertView.getTag();
		hd.textView1.setText(lists.get(position));
		return convertView;
	}

	class ViewHoder {
		TextView textView1;
		TextView textView2;
	}

	public void setSelectedPos(int position) {
		this.mSelectedPos = position;
		notifyDataSetChanged();
	}

}
