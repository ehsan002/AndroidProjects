package com.ehsanrc.labbaik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DailyTask extends Activity {

	private Button btn8, btn9, btn10, btn11;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daily_task);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		btn8 = (Button) findViewById(R.id.jil8);
		btn9 = (Button) findViewById(R.id.jil9);
		btn10 = (Button) findViewById(R.id.jil10);
		btn11 = (Button) findViewById(R.id.jil11);
		btn8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(DailyTask.this,DailyDetail.class);
				startActivity(intent);
				
			}
		});

		btn9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(DailyTask.this,Jilhajj9.class);
				startActivity(intent);
				
			}
		});

		btn10.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(DailyTask.this,Jilhajj10.class);
				startActivity(intent);
				

			}
		});

		btn11.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(DailyTask.this,Jilhajj11.class);
				startActivity(intent);
				

			}
		});

	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onBackPressed();
		return true;

	}

}
