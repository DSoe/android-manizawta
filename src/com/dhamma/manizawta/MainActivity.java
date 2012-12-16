package com.dhamma.manizawta;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

	private Button btnPrevious;
	private Button btnReset;
	private Button btnNext;
	private ImageView image;
	private int i = 1;
	final static int DEFAULT_NUM_IMAGES = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnReset = (Button) findViewById(R.id.btnReset);
		btnReset.setOnClickListener(this);

		btnPrevious = (Button) findViewById(R.id.btnPrevious);
		btnPrevious.setOnClickListener(this);
		// On app load, disable the Previous button
		btnPrevious.setEnabled(false);

		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
		btnNext.setEnabled(true);

		image = (ImageView) findViewById(R.id.imageView);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnReset:
			reset();
			break;

		case R.id.btnNext:
			displayNextImage();
			break;

		case R.id.btnPrevious:
			displayPreviousImage();
			break;

		}
	}

	private void reset() {
		image.setImageResource(R.drawable.img_1);
		btnPrevious.setEnabled(false);
		btnNext.setEnabled(true);
		i = 1;
	}

	private void displayNextImage() {
		int imageKey = getImageKey(i + 1);
		image.setImageResource(imageKey);
		i++;

		if (i > 1)
			btnPrevious.setEnabled(true);
		if (i == DEFAULT_NUM_IMAGES)
			btnNext.setEnabled(false);
	}

	private void displayPreviousImage() {
		int imageKey = getImageKey(i - 1);
		image.setImageResource(imageKey);
		i--;

		if (i > 1)
			btnPrevious.setEnabled(true);
		if (i == 1)
			btnPrevious.setEnabled(false);
		if (i == DEFAULT_NUM_IMAGES)
			btnNext.setEnabled(false);
		if (i < DEFAULT_NUM_IMAGES)
			btnNext.setEnabled(true);
	}

	private int getImageKey(int y) {
		String url = "drawable/" + "img_" + y;
		return getResources().getIdentifier(url, "drawable", getPackageName());
	}

}
