package gov.xiangan.publicsanitation.activity.supervise;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gov.xiangan.publicsanitation.R;

public class SuperviseQueryActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.xrecyclerview)
    XRecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private ArrayList<SuperviseQueryBean> listData;
    private int refreshTime = 0;
    private int times = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervise_query);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.arrow_down);

//        View header = LayoutInflater.from(this).inflate(R.layout.recyclerview_header, (ViewGroup)findViewById(android.R.id.content),false);
//        mRecyclerView.addHeaderView(header);

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime ++;
                times = 0;
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        listData.clear();
                        for(int i = 0; i < 15 ;i++){
                            listData.add(new SuperviseQueryBean("新单位"+i,"新专业","新类别"));
                        }
                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                if(times < 2){
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            for(int i = 0; i < 15 ;i++){
                                listData.add(new SuperviseQueryBean("加载单位"+i,"加载专业","加载类别"));
                            }
                            mRecyclerView.loadMoreComplete();
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for(int i = 0; i < 9 ;i++){
                                listData.add(new SuperviseQueryBean("加载单位","加载专业","加载类别"));
                            }
                            mRecyclerView.setNoMore(true);
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
                times ++;
            }
        });

        listData = new ArrayList<SuperviseQueryBean>();
        mAdapter = new MyAdapter(listData);
        mAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onClick(int position) {
                listData.get(position);
                startActivity(new Intent(SuperviseQueryActivity.this,SuperviseDetailActivity.class));
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.refresh();


    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
