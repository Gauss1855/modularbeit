package com.example.gauss.modularbeit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
        private List<Error> errors;
        private Context ctx;


        public ListViewAdapter(Context ctx, List<Error> errors) {
            this.errors = errors;
            this.ctx = ctx;

        }

        @Override
        public int getCount() {


            return errors.size();
        }

        @Override
        public Object getItem(int i) {
            return errors.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

           /* if (view == null) {
                LayoutInflater inflater = (LayoutInflater) ctx
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vi = inflater.inflate(R.layout.content_alertview, null);
            }*/
            if (view == null) {
                view = LayoutInflater.from(ctx).
                        inflate(R.layout.content_alertview, viewGroup, false);
            }

            //TextView departure = vi.findViewById(R.id.departure);
            TextView to = (TextView) view.findViewById(R.id.to);
            TextView name = (TextView) view.findViewById(R.id.name);

            //ArrayList<ErrorMessage> lol = manager.getErrorMessages();
            Error error = (Error) getItem(5);

            to.setText(error.getErrorMessage());
            //name.setText(error.getErrorNumber());
            return view;
        }

}








