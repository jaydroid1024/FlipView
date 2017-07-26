package org.jay.flipview.flipview.flipviewview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.jay.flipview.R;
import org.jay.flipview.flipview.FlipView;
import org.jay.flipview.flipview.OverFlipMode;

public class FlipActivity extends AppCompatActivity implements FlipAdapter.Callback, FlipView.OnFlipListener, FlipView.OnOverFlipListener {

    private FlipView mFlipView;
    private FlipAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFlipView = (FlipView) findViewById(R.id.flip_view);
        mAdapter = new FlipAdapter(this);
        mAdapter.setCallback(this);
        mFlipView.setAdapter(mAdapter);
        mFlipView.setOnFlipListener(this);
        mFlipView.peakNext(false);
        mFlipView.setOverFlipMode(OverFlipMode.RUBBER_BAND);
        mFlipView.setEmptyView(findViewById(R.id.empty_view));
        mFlipView.setOnOverFlipListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.orientation:
                return true;
            case R.id.vertical:
                mFlipView.setOrientation(FlipView.VERTICAL);
                return true;
            case R.id.horizontal:
                mFlipView.setOrientation(FlipView.HORIZONTAL);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageRequested(int page) {
        mFlipView.smoothFlipTo(page);
    }

    @Override
    public void onFlippedToPage(FlipView v, int position, long id) {
        Log.i("pageflip", "Page: " + position);
        if (position > mFlipView.getPageCount() - 3 && mFlipView.getPageCount() < 30) {
            mAdapter.addItems(5);
        }
    }

    @Override
    public void onOverFlip(FlipView v, OverFlipMode mode,
                           boolean overFlippingPrevious, float overFlipDistance,
                           float flipDistancePerPage) {
        Log.i("overflip", "overFlipDistance = " + overFlipDistance);
    }
}