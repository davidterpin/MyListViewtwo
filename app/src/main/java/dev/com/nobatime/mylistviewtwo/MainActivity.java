package dev.com.nobatime.mylistviewtwo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {




    private ListView list;
    //private ArrayAdapter arrayAdapter;
    @Override



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);

        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array
       // arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, monthsArray);
       list.setAdapter(new stickAdapter(this));
    }

    class SingleRow {
            String hole ;
            String par;
        String distance;

        SingleRow(String par,String distance,String hole)


        {
            this.par=par;

            this.distance=distance;
            this.hole=hole;
        }


    }


    class stickAdapter extends BaseAdapter {

            ArrayList<SingleRow> list;

            Context context;
         stickAdapter(Context c)
        {
            list =new ArrayList<SingleRow>();
        context=c;


            Resources res=c.getResources();
            String[] par= res.getStringArray(R.array.par);

            String[] distance=res.getStringArray(R.array.distance);
            String[] hole =res.getStringArray(R.array.hole);

        for (int i=0; i<5;i ++) {

            list.add(new SingleRow(par[i], distance[i], hole[i]));
        }

        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row =inflater.inflate(R.layout.single_row,viewGroup,false);
            TextView par= (TextView) row.findViewById(R.id.textView2);
            TextView distance= (TextView) row.findViewById(R.id.textView3);

            TextView hole= (TextView) row.findViewById(R.id.textView4);


           SingleRow temp=list.get(i);
            par.setText(temp.par);


            distance.setText(temp.distance);
            hole.setText(temp.hole);

           return row;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
