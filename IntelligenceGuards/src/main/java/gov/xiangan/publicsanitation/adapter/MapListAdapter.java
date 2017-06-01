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
 * 地图
 * 
 * @author hhl
 * 
 */
public class MapListAdapter extends BaseAdapter {

	private Context mContext;
	private List<String> lists;
	private LayoutInflater mInflater;
	private int mSelectedPos = 0;

	public MapListAdapter(Context context, List<String> lists) {
		super();
		this.mContext = context;
		this.lists = lists;
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

		if (null == mContext) {
			return null;
		}

		if (null == lists || lists.size() == 0 || lists.size() <= position) {
			return null;
		}
		// if (null == convertView) {
		convertView = mInflater.inflate(R.layout.list_item_map, parent, false);
		TextView textView = (TextView) convertView.findViewById(R.id.map_txtpe);
		textView.setText(lists.get(position));
		// }

		return convertView;

	}

	public void setSelectedPos(int position) {
		this.mSelectedPos = position;
		notifyDataSetChanged();
	}

}
