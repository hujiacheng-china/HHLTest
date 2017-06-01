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
 * 监督任务
 * 
 * @author hhl
 * 
 */
public class SupListAdapter extends BaseAdapter {

	private Context mContext;
	private List<String> suplists;
	private LayoutInflater mInflater;
	// default selected item
	private int mSelectedPos = 0;

	public SupListAdapter(Context context, List<String> suplists) {
		super();
		this.mContext = context;
		this.suplists = suplists;
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return (null == suplists) ? 0 : suplists.size();
	}

	@Override
	public String getItem(int position) {
		return (null == suplists) ? null : suplists.get(position);
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

		if (null == suplists || suplists.size() == 0 || suplists.size() <= position) {
			return null;
		}

		// if (null == convertView) {
		convertView = mInflater.inflate(R.layout.list_item_sup, parent, false);
		TextView textView = (TextView) convertView.findViewById(R.id.sup_txtpe);
		textView.setText(suplists.get(position));
		// }

		return convertView;
	}

	public void setSelectedPos(int position) {
		this.mSelectedPos = position;
		notifyDataSetChanged();
	}

}
