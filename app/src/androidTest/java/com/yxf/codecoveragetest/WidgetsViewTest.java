package com.yxf.codecoveragetest;

import android.app.Activity;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by xifeng.yang on 2019/8/30.
 */
public class WidgetsViewTest extends BaseActivityTest {

    @Override
    protected Class<? extends Activity> getActivityClass() {
        return SecondActivity.class;
    }

    @Test
    public void testToast() {
        onView(withId(R.id.btn_show_toast)).perform(click());
        sleep(5000);
    }
}
