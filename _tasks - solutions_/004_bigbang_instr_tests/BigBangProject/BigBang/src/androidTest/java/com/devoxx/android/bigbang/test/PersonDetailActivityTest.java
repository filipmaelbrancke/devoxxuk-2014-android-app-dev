package com.devoxx.android.bigbang.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

import com.devoxx.android.bigbang.PersonDetailActivity;
import com.devoxx.android.bigbang.PersonDetailFragment;
import com.devoxx.android.bigbang.R;
import com.devoxx.android.bigbang.dummy.DummyData;

/**
 * Big Bang character detail instrumentation test.
 */
public class PersonDetailActivityTest extends ActivityInstrumentationTestCase2<PersonDetailActivity> {

    private PersonDetailActivity mPersonDetailActivity;
    private PersonDetailFragment mPersonDetailFragment;
    private DummyData.BigBangCharacter sheldon;

    public PersonDetailActivityTest() {
        super(PersonDetailActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();

        // get id for Sheldon
        sheldon = DummyData.PERSONS.get(0);
        Intent detailIntent = new Intent(getActivity(), PersonDetailActivity.class);
        detailIntent.putExtra(PersonDetailFragment.ARG_PERSON_ID, sheldon.id);

        mPersonDetailActivity = getActivity();
        android.support.v4.app.FragmentManager fragmentManager = mPersonDetailActivity.getSupportFragmentManager();
        mPersonDetailFragment = (PersonDetailFragment) fragmentManager.findFragmentById(R.id.person_detail_container);
    }

    public void testActivityIsSetup() {
        assertNotNull(mPersonDetailActivity);
        assertNotNull(mPersonDetailActivity.getFragmentManager());
        assertNotNull(mPersonDetailFragment);
    }

    public void testSheldonsInfoIsLoaded() throws InterruptedException {
        Thread.sleep(2000);
        View rootView = mPersonDetailFragment.getView();
        TextView nameTextView = (TextView) rootView.findViewById(R.id.characterName);
        assertEquals(sheldon.toString(), nameTextView.getText());
    }
}
