package com.pasha.pickles.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;

import com.pasha.pickles.R;
import com.pasha.pickles.view.ScrollableGridView;


/**
 * 
 * This class is used as adapter for display tags,which creates a view and
 * insert into the list
 * 
 * @author viral
 * 
 */

public class MenuListAdapater extends BaseAdapter {
	private LayoutInflater inflater;
	Activity activity = null;
	int getDeviceColumns = 0,deficit = 0;
	View previousMessageContentView,previousSubCatView;
	String TAG = "ItemsListAdapater";
	
			

	// initializing the variables
	public MenuListAdapater(Activity activity) {
		this.activity = activity;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}

	// return the total number of tags
	@Override
	public int getCount() {
		
		return 30;
	}

	// returns the tag position
	@Override
	public Object getItem(int position) {
		return position;
	}

	// returns the tag position
	@Override
	public long getItemId(int position) {
		return position;
	}

	// returns the corresponding view to the adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// inflates the layout if its not inflated
		
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.row_list_menu, null);
		}
		ScrollableGridView menuGridView = (ScrollableGridView)convertView.findViewById(R.id.grid_menu);
		MenuItemsGridAdpater gridAdapter = new MenuItemsGridAdpater(activity);
		menuGridView.setAdapter(gridAdapter);
		
		return convertView;
	}


	private void hideAllViews(View rootView,int []viewIds){
		for(int viewId:viewIds){
			View v = rootView.findViewById(viewId);
			v.setVisibility(View.INVISIBLE);
		}
	}




	
	
	private void animateIn(View v){
		Animation moveRightToLeft = new TranslateAnimation(500, 0, 0, 0);
		moveRightToLeft.setDuration(500);
		moveRightToLeft.setFillAfter(true);
		v.startAnimation(moveRightToLeft);
	}

	private void animateaOut(final View v){
		Animation moveLefttoRight = new TranslateAnimation(0, -800, 0, 0);
		moveLefttoRight.setDuration(500);
		moveLefttoRight.setFillAfter(true);
		moveLefttoRight.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				v.setVisibility(View.GONE);
			}
		});
		v.startAnimation(moveLefttoRight);

	}

	

}
