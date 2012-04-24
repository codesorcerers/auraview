package test.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button btn4 = (Button) findViewById(R.id.button4);
		final Button btn5 = (Button) findViewById(R.id.button5);
		btn4.getBackground().setAlpha(0);
		btn5.bringToFront();

		btn5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (R.id.button5 == view.getId()) {
					btn4.getBackground().setAlpha(255);
					btn4.bringToFront();
					btn5.getBackground().setAlpha(0);
				}
			}
		});

		btn4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				if (R.id.button4 == view.getId()) {
					btn5.getBackground().setAlpha(255);
					btn5.bringToFront();
					btn4.getBackground().setAlpha(0);
				}
			}
		});

	}
}