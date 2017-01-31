package com.bx.android.lesson6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bx.android.lesson6.dummy.DummyContentFactory;

public class ListFragment extends Fragment {

    private boolean mTwoPane = false;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTwoPane = getArguments().getBoolean("TWO_PANE");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View recyclerView = view.findViewById(R.id.item_list);
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        SimpleItemRecyclerViewAdapter.RecycleViewListener listener = new SimpleItemRecyclerViewAdapter.RecycleViewListener() {
            @Override
            public void onItemClick(String id) {
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.detailContainer, fragment)
                            .commit();
                } else {
                    Intent intent = new Intent(ListFragment.this.getActivity(), ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
                    startActivity(intent);
                }
            }
        };
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContentFactory.ITEMS, listener));
    }

    public void setTextInTextView(String message) {
        TextView textView = (TextView) getView().findViewById(R.id.textView);
        if (textView != null) {
            textView.setText(message);
        }
    }
}
