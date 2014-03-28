package com.example.connect_sdk_sampler;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.connect_sdk_sampler.fragments.AppsFragment;
import com.example.connect_sdk_sampler.fragments.BaseFragment;
import com.example.connect_sdk_sampler.fragments.FivewayFragment;
import com.example.connect_sdk_sampler.fragments.SystemFragment;
import com.example.connect_sdk_sampler.fragments.MediaPlayerFragment;
import com.example.connect_sdk_sampler.fragments.TVFragment;
import com.example.connect_sdk_sampler.fragments.WebAppFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
	private int[] mItems;
	private String[] mTitles;
	private FragmentManager mFragmentManager;
	private Context mContext;

	public SectionsPagerAdapter(Context context, FragmentManager fm) {
		super(fm);
		mContext = context;
		mFragmentManager = fm;
		
		TypedArray items = context.getResources().obtainTypedArray(R.array.tab_icons);
		mTitles = context.getResources().getStringArray(R.array.tab_titles);
		
		mItems = new int[items.length()];
		
		for (int i = 0; i < items.length(); i++) {
			mItems[i] = items.getResourceId(i, -1);
		}
		
		items.recycle();
	}

	@Override
	public Fragment getItem(int position) {
		BaseFragment newFragment;

        switch (position)
        {
            case 1:
            	newFragment = new WebAppFragment(mContext);
                break;

            case 2:
                newFragment = new FivewayFragment(mContext);
                break;

            case 3:
                newFragment = new AppsFragment(mContext);
                break;

            case 4:
                newFragment = new TVFragment(mContext);
                break;
           
            case 5:
                newFragment = new SystemFragment(mContext);
            	break;

            case 0:
            default:
                newFragment = new MediaPlayerFragment(mContext);
        }

		return newFragment;
	}
	
	public BaseFragment getFragment(int position) {
		return (BaseFragment) mFragmentManager.findFragmentByTag("android:switcher:" + R.id.pager + ":" + position);
	}

	@Override
	public int getCount() {
		return mItems.length;
	}
	
	public int getIcon(int position) {
		return mItems[position];
	}
	
	public String getTitle(int position) {
		return mTitles[position];
	}
}