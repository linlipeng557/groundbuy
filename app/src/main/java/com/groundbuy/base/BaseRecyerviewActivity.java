package com.groundbuy.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.groundbuy.R;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseRecyerviewActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    ConstraintLayout topBar;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.title_tv)
    TextView title_tv;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_recyerview;
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        if (!TextUtils.isEmpty(title())) {
            title_tv.setText(title());
        }
        if (layoutManager() != null)
            rv.setLayoutManager(layoutManager());
        doMore(savedInstanceState, rv);
    }

    public abstract void doMore(Bundle savedInstanceState, RecyclerView recyclerView);


    @Override
    public View topBar() {
        return topBar;
    }

    protected abstract String title();

    protected RecyclerView.LayoutManager layoutManager() {
        return new LinearLayoutManager(this);
    }

}
