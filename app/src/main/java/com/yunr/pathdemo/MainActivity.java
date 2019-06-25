package com.yunr.pathdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.wuyr.pathlayoutmanager.PathLayoutManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView testView = findViewById(R.id.path_test_view);
        CanvasView drawView = findViewById(R.id.path_draw_view);
        RecyclerView pathRecyclerView = findViewById(R.id.path_recycler_view);

        int width = getWindowsWidth(this);
        int height = getWindowsWidth(this) / 2;
        int radius = dip2px(this, 100);
        Path path = new Path();
        path.addCircle(width / 2, height / 2, radius, Path.Direction.CCW);
        drawView.setPath(path);
        final PathLayoutManager pathLayoutManager = new PathLayoutManager(path, dip2px(this, 86));
        pathLayoutManager.setOrientation(RecyclerView.VERTICAL);
        pathLayoutManager.setScrollMode(PathLayoutManager.SCROLL_MODE_LOOP);
        pathLayoutManager.setAutoSelect(true);
        pathLayoutManager.setItemDirectionFixed(true);
        pathLayoutManager.setAutoSelectFraction(0.5f);

        pathRecyclerView.setLayoutManager(pathLayoutManager);
        pathRecyclerView.setAdapter(new DemoAdapter(20));
        pathLayoutManager.scrollToPosition(0);

        pathRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                int position = pathLayoutManager.findClosestPosition();
                testView.setText("滑动过程距离最近的Position:" + position);
            }
        });
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 获取屏幕的宽度
     */
    public final static int getWindowsWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

}
