package com.example.sportx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    //Adapter View
    private RecyclerView recyclerView;

    //Data Source
    private List<SportX> sportXList;

    //Adapter
    private Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        sportXList = new ArrayList<>();

        SportX s1 = new SportX(R.drawable.football, "Football");
        SportX s2 = new SportX(R.drawable.volley, "Volleyball");
        SportX s3 = new SportX(R.drawable.ping, "Ping Pong");
        SportX s4 = new SportX(R.drawable.basketball, "Basketball");
        SportX s5 = new SportX(R.drawable.tennis, "Tennis");


        sportXList.add(s1);
        sportXList.add(s2);
        sportXList.add(s3);
        sportXList.add(s4);
        sportXList.add(s5);

        myAdapter = new Adapter(sportXList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapter);

        myAdapter.setClickListener(this);




    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this,
                "You Choose: "+sportXList.get(pos).getSportName()
                , Toast.LENGTH_SHORT).show();
    }
}