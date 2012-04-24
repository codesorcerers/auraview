package com.codesorcerers.auraview;

import test.test.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class TestActivity extends Activity {

	AuraView rectangle = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_view);

		rectangle=new AuraView(getBaseContext(), 1, 1, 5, 5, Color.WHITE, 20, 10);
		layout.addView(rectangle);
		
		Button btn6Button = (Button) findViewById(R.id.button6);
		btn6Button.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				RelativeLayout layout = (RelativeLayout) view.getParent();
				int strokeWidth = rectangle.getStrokeWidth();
				rectangle.setLeft(view.getLeft());
				rectangle.setTop(view.getTop());
				rectangle.setRight(view.getRight());
				rectangle.setBottom(view.getBottom());

				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					rectangle.setVisibility(View.VISIBLE);
					layout.invalidate(view.getLeft() - strokeWidth, view.getTop() - strokeWidth, view.getRight() + strokeWidth, view.getBottom() + strokeWidth);
				}
				if (event.getAction() == MotionEvent.ACTION_UP) {
					rectangle.setVisibility(View.INVISIBLE);
					layout.invalidate(view.getLeft() - strokeWidth, view.getTop() - strokeWidth, view.getRight() + strokeWidth, view.getBottom() + strokeWidth);
				}
				return false;
			}
		});
	}
}