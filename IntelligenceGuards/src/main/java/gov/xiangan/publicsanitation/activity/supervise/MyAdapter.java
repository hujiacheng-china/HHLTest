package gov.xiangan.publicsanitation.activity.supervise;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import gov.xiangan.publicsanitation.R;

/**
 * Created by jianghejie on 15/11/26.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public ArrayList<SuperviseQueryBean> datas = null;
    public MyAdapter(ArrayList<SuperviseQueryBean> datas) {
        this.datas = datas;
    }
    public interface onItemClickListener{
        public void onClick(int position);
    }
    private onItemClickListener clickListener;

    public void setOnItemClickListener(onItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_supervise_query,viewGroup,false);
        return new ViewHolder(view);
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.item_dw.setText(datas.get(position).getDw());
        viewHolder.item_zy.setText(datas.get(position).getZy());
        viewHolder.item_lb.setText(datas.get(position).getLb());
        viewHolder.item_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick(position);
            }
        });
    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView item_dw;
        public TextView item_zy;
        public TextView item_lb;
        public LinearLayout item_ll;
        public ViewHolder(View view){
            super(view);
            item_dw = (TextView) view.findViewById(R.id.item_dw);
            item_zy = (TextView) view.findViewById(R.id.item_zy);
            item_lb = (TextView) view.findViewById(R.id.item_lb);
            item_ll = (LinearLayout) view.findViewById(R.id.item_ll);
        }
    }
}
