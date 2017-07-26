package org.jay.flipview.flipview2.flipview2view;

import android.app.Activity;
import android.os.Bundle;

import org.jay.flipview.R;
import org.jay.flipview.flipview2.flip.FlipViewController;
import org.jay.flipview.flipview2.flipview2view.issue5.GalleryFlipAdapter;


public class Issue5Activity extends Activity {

  private FlipViewController flipView;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setTitle(R.string.activity_title);

    flipView = new FlipViewController(this);

    flipView.setAdapter(new GalleryFlipAdapter(this, flipView));

    setContentView(flipView);
  }

  @Override
  protected void onResume() {
    super.onResume();
    flipView.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    flipView.onPause();
  }
}