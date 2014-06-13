package com.devoxx.android.bigbang.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.devoxx.android.bigbang.PersonListActivity;
import com.devoxx.android.bigbang.PersonListFragment;
import com.devoxx.android.bigbang.R;

/**
 * Big Bang instrumentation tests.
 */
public class BigBangMainActivityTest extends ActivityInstrumentationTestCase2<PersonListActivity> {

    private PersonListActivity mPersonListActivity;
    private PersonListFragment mPersonListFragment;

    public BigBangMainActivityTest() {
        super(PersonListActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();

        mPersonListActivity = getActivity();
        android.support.v4.app.FragmentManager fragmentManager = mPersonListActivity.getSupportFragmentManager();
        mPersonListFragment = (PersonListFragment) fragmentManager.findFragmentById(R.id.person_list);
    }

    public void testActivityIsSetup() {
        assertNotNull(mPersonListActivity);
        assertNotNull(mPersonListActivity.getFragmentManager());
        assertNotNull(mPersonListFragment);
    }

    public void testListPresent() {
        ListView listView = mPersonListFragment.getListView();
        assertNotNull(listView);
    }

    public void testPersonsInList() throws InterruptedException {
        Thread.sleep(2000);
        ListAdapter listAdapter = mPersonListFragment.getListAdapter();
        assertNotNull(listAdapter);
        assertEquals("5 Persons should be present in the list", 5, listAdapter.getCount());
    }

    public void testPersonSelection() {
        final ListView listView = mPersonListFragment.getListView();
        mPersonListActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listView.setSelection(0);
            }
        });
    }
}
