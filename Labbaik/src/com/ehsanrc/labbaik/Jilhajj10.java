package com.ehsanrc.labbaik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Jilhajj10 extends Activity {

	private Button btn_nxt, btn_prv, button;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jilhajj10);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		btn_nxt = (Button) findViewById(R.id.btn_10_nxt);
		btn_prv = (Button) findViewById(R.id.btn_10_prv);
		button = (Button) findViewById(R.id.btn_hme10);

		btn_nxt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Jilhajj10.this, Jilhajj11.class);
				startActivity(intent);
			}
		});

		btn_prv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Jilhajj10.this, Jilhajj9.class);
				startActivity(intent);
			}
		});

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(Jilhajj10.this, MainActivity.class);
				startActivity(intent);
			}
		});

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		super.onBackPressed();
		return true;

	}
}
