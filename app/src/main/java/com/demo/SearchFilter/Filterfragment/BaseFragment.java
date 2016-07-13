package com.demo.SearchFilter.Filterfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.demo.SearchFilter.R;


public  class BaseFragment extends Fragment {
    protected FragmentActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;
    }

    protected void showNext(Fragment fragment, int id) {
        showNext(fragment, id, null, true);
    }
    protected void showNext(Fragment fragment, int id,Bundle b) {
        showNext(fragment, id, b, true);
    }


    protected void showNext(Fragment fragment, int id, Bundle b,boolean isAddBackStack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out);
        fragmentTransaction.replace(id, fragment);
        if (b != null) {
            fragment.setArguments(b);
        }
        if(isAddBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 返回上一个界面
     */
    protected void back() {
//		showHideFragment();
        getActivity().getSupportFragmentManager().popBackStackImmediate();
    }
}
