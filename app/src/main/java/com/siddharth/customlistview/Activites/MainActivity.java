package com.siddharth.customlistview.Activites;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.siddharth.customlistview.Data.CustomListViewAdapter;
import com.siddharth.customlistview.R;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String[] bookTitles = new String[]{
                "Gone Girl,",
                "The Thief",
                "Night Prayers",
                "And When She Was Good",
                "Dare Me",
                "The Man Who Loved Dogs",
                "Every Man a Menace",
                "The Long Drop",
                "Reebecca"

        };

        final String[] bookPages = new String[]{
                "300 pages",
                "330 pages",
                "220 pages",
                "250 pages",
                "170 pages",
                "230 pages",
                "350 pages",
                "120 pages",
                "190 pages",

        };

        final String[] authors = new String[]{

                "Gillian Flynn",
                "Fuminori Nakamura",
                "Santiago Gamboa",
                "Laura Lippman",
                "Megan Abbott",
                "Leonardo Padura",
                "Patrick Hoffman",
                "Denise Mina",
                "Dame Daphne du"

        };

        ArrayList<HashMap<String, String>> authorList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {

            HashMap<String, String> data = new HashMap<>();
            data.put("title", bookTitles[i]);
            data.put("pages", bookPages[i]);
            data.put("author", authors[i]);


            authorList.add(data);

        }

        listView =  findViewById(R.id.list);

        //Setup adapter
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), authorList);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int myPosition = position;

                String itemClickedId = listView.getItemAtPosition(myPosition).toString();

                Toast.makeText(getApplicationContext(), "Id Clicked: " + itemClickedId, Toast.LENGTH_LONG).show();


            }
        });


    }
}
