package com.joker.mydemo;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.joker.mydemo.bean.Joke;
import com.joker.mydemo.utils.BitmapCache;
import com.joker.mydemo.utils.VolleyHelper;

/**
 * Created by Joker on 2015/11/27.
 */
public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.WaterFallViewHolder>
        implements Response.Listener<Bitmap>, Response.ErrorListener{
    private static final String TAG = "WaterFallAdapter";

    private Joke mJoke = null;
    private ImageLoader mImageLoader = null;
    private ImageLoader.ImageListener mListener = null;

    public WaterFallAdapter(Joke joke) {
        this.mJoke = joke;
        mImageLoader = new ImageLoader(VolleyHelper.getInstance().getQueue(), BitmapCache.getInstance());
    }

    @Override
    public WaterFallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_waterfall_list_item, parent, false);
        return new WaterFallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WaterFallViewHolder holder, int position) {
        if (TextUtils.isEmpty(mJoke.getDetail().get(position).getPicUrl())) {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            mListener = ImageLoader.getImageListener(holder.imageView, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
            mImageLoader.get(mJoke.getDetail().get(position).getPicUrl(), mListener);
        }
        holder.textView.setText(mJoke.getDetail().get(position).getContent());

//        ImageRequest requeste = new ImageRequest(mList.get(position).getPicUrl(), this, 0, 0,
//                ImageView.ScaleType.CENTER_INSIDE,  Bitmap.Config.RGB_565,this);
//        VolleyHelper.getInstance().getQueue().add(requeste);
    }

    @Override
    public int getItemCount() {
        return mJoke.getDetail().size();
    }

    @Override
    public void onResponse(Bitmap response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    public static class WaterFallViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public WaterFallViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.waterfall_item_image);
            textView = (TextView) itemView.findViewById(R.id.waterfall_item_text);
        }
    }
}
