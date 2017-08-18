package com.nby.test_rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2017/8/1.
 */

public class NewsContentFragment extends Fragment {
    @BindView(R.id.news_title)
    TextView newsTitle;
    @BindView(R.id.news_content)
    TextView newsContent;
    @BindView(R.id.visibility_layout)
    LinearLayout visibilityLayout;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public void refresh(String newsTitles, String newsContents) {
        visibilityLayout.setVisibility(View.VISIBLE);
        newsTitle.setText(newsTitles);
        newsContent.setText(newsContents);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
