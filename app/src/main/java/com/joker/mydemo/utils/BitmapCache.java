package com.joker.mydemo.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Joker on 2015/11/27.
 */
public class BitmapCache implements ImageLoader.ImageCache {
    private static volatile BitmapCache instance = null;

    private LruCache<String, Bitmap> cache;
    private static final int MAX_SIZE= 4 * 1024 * 1024;

    private BitmapCache() {
        cache = new LruCache<String, Bitmap>(MAX_SIZE) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    public static BitmapCache getInstance() {
        if (instance == null) {
            synchronized(BitmapCache.class) {
                if (instance == null) {
                    instance = new BitmapCache();
                }
            }
        }

        return instance;
    }



    @Override
    public Bitmap getBitmap(String url) {
        return cache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        cache.put(url, bitmap);
    }
}
