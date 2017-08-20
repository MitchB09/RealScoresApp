package com.realscores.activity.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realscores.R;
import com.realscores.activity.fragments.CourseFragment.OnListFragmentInteractionListener;
import com.realscores.obj.Course;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Course} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewAdapter.ViewHolder> {

  private final List<Course> mValues;
  private final CourseFragment.OnListFragmentInteractionListener mListener;

  public CourseRecyclerViewAdapter(List<Course> items, OnListFragmentInteractionListener listener) {
    mValues = items;
    mListener = listener;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.fragment_course, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mItem = mValues.get(position);
    holder.mIdView.setText(mValues.get(position).getCourseId());
    holder.mContentView.setText(mValues.get(position).getName());

    holder.mView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (null != mListener) {
          // Notify the active callbacks interface (the activity, if the
          // fragment is attached to one) that an item has been selected.
          mListener.onListFragmentInteraction(holder.mItem);
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return mValues.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    public Course mItem;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mIdView = (TextView) view.findViewById(R.id.id);
      mContentView = (TextView) view.findViewById(R.id.content);
    }

    @Override
    public String toString() {
      return super.toString() + " '" + mContentView.getText() + "'";
    }
  }
}
