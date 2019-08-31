package com.yxf.codecoveragetest;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.WindowManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

/**
 * Created by xifeng.yang on 2019/3/14.
 */

@LargeTest
@RunWith(AndroidJUnit4.class)
public abstract class BaseActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
        protected void beforeActivityLaunched() {
            super.beforeActivityLaunched();
        }

        @Override
        protected void afterActivityLaunched() {
            super.afterActivityLaunched();
        }
    };

    protected Class<? extends Activity> getActivityClass() {
        return MainActivity.class;
    }

    @Before
    public void registerIdlingResource() throws Throwable {
        //getPermissions();
        IdlingPolicies.setMasterPolicyTimeout(3, TimeUnit.MINUTES);
        IdlingPolicies.setIdlingResourceTimeout(3, TimeUnit.MINUTES);

        final Activity activity = mActivityTestRule.getActivity();
        if (activity != null) {
            mActivityTestRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //turn the screen on
                    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                            | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                            | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
                }
            });
        }

        startActivityClass();
    }

    private void startActivityClass() {
        final Class<? extends Activity> activityClass = getActivityClass();
        if (activityClass != null) {
            Intent intent = new Intent(mActivityTestRule.getActivity(), activityClass);
            mActivityTestRule.getActivity().startActivityForResult(intent, 0);
        }

    }

    protected void sleep(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            //ignore.
        }
    }
}
