package com.ehsanrc.labbaik;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

	public static final String LOGTAG = null;
	private DrawerLayout dLayout;
	private ActionBarDrawerToggle drawerToggle;
	private ListView drawerList;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private MyAdapter adapter;
	private String[] strings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTitle = mDrawerTitle = getTitle();
		drawerList = (ListView) findViewById(R.id.lv);
		strings = getResources().getStringArray(R.array.drawer_item);
		adapter = new MyAdapter(this, strings);
		drawerList.setAdapter(adapter);

		drawerList.setOnItemClickListener(new DrawerItemClickListener());
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		drawerToggle = new ActionBarDrawerToggle(this, dLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu();
			}
		};

		dLayout.setDrawerListener(drawerToggle);

		if (savedInstanceState == null) {
			Fragment fragment = null;
			fragment = new MainFragment();
			FragmentManager fragmentManager = getFragmentManager();

			fragmentManager.beginTransaction().replace(R.id.main, fragment)
					.commit();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {

		Fragment fragment = null;

		if (position == 0) {
			fragment = new MainFragment();
		}
		else {
			fragment = new About(position);
		}

		FragmentManager fragmentManager = getFragmentManager();

		fragmentManager.beginTransaction().replace(R.id.main, fragment)
				.commit();

		// update selected item and title, then close the drawer
		drawerList.setItemChecked(position, true);
		dLayout.closeDrawer(drawerList);

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

}