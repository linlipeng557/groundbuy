package com.groundbuy.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.groundbuy.R;
import com.groundbuy.base.BaseActivity;
import com.groundbuy.ui.fragment.HomeFragment;
import com.groundbuy.ui.fragment.WDFragment;
import com.groundbuy.ui.fragment.YDFragment;
import com.groundbuy.ui.fragment.ZKFragment;
import com.groundbuy.ui.fragment.ZKZFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.io.Serializable;
import java.util.List;
import java.util.Stack;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bnve)
    BottomNavigationViewEx bnve;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_main;
    }

    private static final String FRAGMENT_STACK_KEY = "FRAGMENT_STACK_KEY";

    private Stack<StackEntry> fragmentsStack = new Stack<StackEntry>();
    FragmentManager fragmentManager;

    HomeFragment homeFragment;
    ZKFragment zkFragment;
    ZKZFragment zkzFragment;
    YDFragment ydFragment;
    WDFragment wdFragment;


    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        this.fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            Serializable serializable = savedInstanceState.getSerializable(FRAGMENT_STACK_KEY);
            if (serializable != null) {
                List arrayList = (List) serializable;
                this.fragmentsStack = new Stack();
                this.fragmentsStack.addAll(arrayList);
            }
            if (this.fragmentsStack.size() > 1) {
                FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
                for (int i = 0; i < this.fragmentsStack.size() - 1; i++) {
                    String fragTag = ((StackEntry) this.fragmentsStack.get(i)).getFragTag();
                    Fragment fragment = this.fragmentManager.findFragmentByTag(fragTag);
                    fragmentTransaction.hide(fragment);
                }
                fragmentTransaction.commit();
            }
        }

        this.fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                Fragment lastFragment = MainActivity.this.getLastFragment();
                if ((lastFragment != null) && (lastFragment.isHidden())) {
                    FragmentTransaction fragmentTransaction = MainActivity.this.fragmentManager.beginTransaction();
                    fragmentTransaction.show(lastFragment);
                    fragmentTransaction.commit();
                }
            }
        });
        bnve.enableAnimation(false);
        bnve.setTextSize(10);
        bnve.enableShiftingMode(false);
        bnve.setOnNavigationItemSelectedListener(this);
        bnve.setSelectedItemId(R.id.i_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.i_home:
                if (null == homeFragment) {
                    homeFragment = new HomeFragment();
                }
                switchContent(homeFragment);
                break;
            case R.id.i_zk:
                if (null == zkFragment) {
                    zkFragment = new ZKFragment();
                }
                switchContent(zkFragment);
                break;
            case R.id.i_zsz:
                if (null == zkzFragment) {
                    zkzFragment = new ZKZFragment();
                }
                switchContent(zkzFragment);
                break;
            case R.id.i_yd:
                if (null == ydFragment) {
                    ydFragment = new YDFragment();
                }
                switchContent(ydFragment);
                break;
            case R.id.i_wd:
                if (null == wdFragment) {
                    wdFragment = new WDFragment();
                }
                switchContent(wdFragment);
                break;
        }
        return false;
    }




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(FRAGMENT_STACK_KEY, fragmentsStack);
    }
    public boolean isFirstFragment() {
        return fragmentsStack.size() == 0;
    }

    public void switchContent(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment lastFragment = getLastFragment();
        if (lastFragment != null) {
            fragmentTransaction.hide(lastFragment);
        }
        String fragTag;
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
            fragTag = fragment.getTag();
        } else {
            fragTag = Long.toString(System.currentTimeMillis());
            fragmentTransaction.add(R.id.content_layout, fragment, fragTag);
        }
        if (!isFirstFragment()) {
            // Add to backstack only the first content fragment and not the state before (that has nothing)
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
        fragmentsStack.push(new StackEntry(fragTag));
    }


    private Fragment getLastFragment() {
        if (fragmentsStack.isEmpty()) return null;
        String fragTag = fragmentsStack.peek().getFragTag();
        Fragment fragment = fragmentManager.findFragmentByTag(fragTag);
        return fragment;
    }


    private static class StackEntry implements Serializable {
        private static final long serialVersionUID = -6162805540320628024L;

        private String fragTag = null;

        public StackEntry(String fragTag) {
            super();
            this.fragTag = fragTag;
        }

        public String getFragTag() {
            return fragTag;
        }
    }
}
