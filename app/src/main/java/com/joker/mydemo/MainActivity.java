package com.joker.mydemo;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.joker.mydemo.base.BaseActivity;
import com.joker.mydemo.utils.Global;


public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ListView list;
    private String [] array = {"条目1","条目2","条目3"};
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        initToolbar();
        initView();
    }

    @Override
    protected void showItem(int position) {
        WaterFallFragment fragment = null;
        switch (position) {
            case Global.FIRST_POSITION:
                fragment = new WaterFallFragment();
                break;
            default:
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.mian_layout, fragment).commit();
    }

    private void initToolbar()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //设置toolbar标题
        toolbar.setTitle("Drawer");
        //设置Navigation
        toolbar.setNavigationIcon(R.drawable.abc_cab_background_internal_bg);
        //设置点击Navigation的方法
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //为了让ToolBar各项设置都生效的话，这个方法必须放到最后
        setSupportActionBar(toolbar);
    }

    private void initView()
    {
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        list = (ListView) findViewById(R.id.listDrawer);
        list.setAdapter(adapter);
    }

    //此方法定义Menu的布局样式，返回false则不显示Menuq
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //此方法定义点击Menu按钮产生的事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //点击侧滑弹出的事件
        if (id == R.id.action_settings) {
            if (drawer.isDrawerOpen(Gravity.RIGHT))
            {
                drawer.closeDrawer(Gravity.RIGHT);
            }
            else
            {
                drawer.openDrawer(Gravity.RIGHT);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
