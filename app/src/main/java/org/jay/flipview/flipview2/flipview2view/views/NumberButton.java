package org.jay.flipview.flipview2.flipview2view.views;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class NumberButton extends android.support.v7.widget.AppCompatButton {

  private int number;

  public NumberButton(Context context, final int n) {
    super(context, null, android.R.attr.buttonStyleInset);
    setNumber(n);
    setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(v.getContext(), "Clicked button " + number, Toast.LENGTH_SHORT).show();
      }
    });
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
    setText(Integer.toString(number));
  }

  @Override
  public String toString() {
    return "NumberButton: " + number;
  }
}
