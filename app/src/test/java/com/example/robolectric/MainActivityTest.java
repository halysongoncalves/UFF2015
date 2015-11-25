package com.example.robolectric;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by bruno.vieira on 20/10/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18, packageName = "com.example.robolectric")
public class MainActivityTest {
    private MainActivity mainActivity;

    @Before
    public void setup() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }


    @Test
    public void redirectToNextActivity() throws Exception {
        mainActivity.findViewById(R.id.button_open_next_activity).performClick();
        assertThat(shadowOf(mainActivity).getNextStartedActivity().getComponent().getClassName())
                .isEqualTo(NextActivity.class.getName());
    }

}