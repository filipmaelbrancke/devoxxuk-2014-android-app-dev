package com.devoxx.android.bigbang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devoxx.android.bigbang.dummy.DummyData;
import com.squareup.picasso.Picasso;

/**
 * A fragment representing a single Person detail screen.
 * This fragment is either contained in a {@link PersonListActivity}
 * in two-pane mode (on tablets) or a {@link PersonDetailActivity}
 * on handsets.
 */
public class PersonDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_PERSON_ID = "person_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyData.BigBangCharacter mPerson;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PersonDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_PERSON_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mPerson = DummyData.PERSON_MAP.get(getArguments().getString(ARG_PERSON_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_person_detail, container, false);

        // Show the dummy content
        if (mPerson != null) {
            ImageView image = (ImageView) rootView.findViewById(R.id.imageView);
            Picasso.with(getActivity()).load(mPerson.imageResource).into(image);
            ((TextView) rootView.findViewById(R.id.characterName)).setText(mPerson.toString());
            ((TextView) rootView.findViewById(R.id.profession)).setText(mPerson.profession);
            ((TextView) rootView.findViewById(R.id.realname)).setText(mPerson.realName);
            ((TextView) rootView.findViewById(R.id.personDetail)).setText(mPerson.bio);
        }

        return rootView;
    }
}
