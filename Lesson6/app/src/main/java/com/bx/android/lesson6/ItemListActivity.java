package com.bx.android.lesson6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bx.android.lesson6.dummy.DummyContentFactory;
import com.bx.android.lesson6.dummy.DummyItem;

import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity implements ItemDetailFragment.FragmentInterface {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.detailContainer) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        Bundle bundle = new Bundle();
        bundle.putBoolean("TWO_PANE", mTwoPane);
        ListFragment listFragment = new ListFragment();
        listFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, listFragment).commit();
    }


    @Override
    public void doAction(String action) {

    }

    @Override
    public void setTextInTextView(String message) {
        ListFragment listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.mainContainer);
        listFragment.setTextInTextView(message);

    }
}
