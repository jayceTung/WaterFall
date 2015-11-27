package com.joker.mydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.joker.mydemo.base.BaseFragment;
import com.joker.mydemo.base.GsonRequest;
import com.joker.mydemo.base.SpaceItem;
import com.joker.mydemo.bean.Joke;
import com.joker.mydemo.utils.VolleyHelper;

/**
 * Created by Joker on 2015/11/27.
 */
public class WaterFallFragment extends BaseFragment {
    private static final String TAG = "WaterFallFragment";

    private RecyclerView mRecyclerView;
    private WaterFallAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.waterfall_fragment, container, false);
        initView(view);
        request();
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.waterfall_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


    }

    private void request() {
        GsonRequest<Joke> gsonRequest = new GsonRequest<Joke>("http://api.1-blog.com/biz/bizserver/xiaohua/list.do",
                Joke.class, new Response.Listener<Joke>() {
            @Override
            public void onResponse(Joke response) {
                mAdapter = new WaterFallAdapter(response);
                mRecyclerView.setAdapter(mAdapter);
                SpaceItem item = new SpaceItem(10);
                mRecyclerView.addItemDecoration(item);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "网络连接失败", Toast.LENGTH_LONG).show();
            }
        });
        VolleyHelper.getInstance().getQueue().add(gsonRequest);
    }

}
