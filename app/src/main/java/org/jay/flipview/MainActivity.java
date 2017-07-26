package org.jay.flipview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.jay.flipview.flipview2.flipview2view.Flip2Activity;
import org.jay.flipview.flipview.flipviewview.FlipActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onFlip01Click(View view) {
        Intent intent=new Intent(this, FlipActivity.class);
        startActivity(intent);
    }

    public void onFlip02Click(View view) {
        Intent intent=new Intent(this, Flip2Activity.class);
        startActivity(intent);
    }
}
