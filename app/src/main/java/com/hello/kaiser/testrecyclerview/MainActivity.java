package com.hello.kaiser.testrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Cell> things = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        for (int i = 0; i < 10; i++) {
            int randomType = (int) (Math.random() * 10);
            Cell cell = new Cell();
            if (randomType > 5) {
                cell.setType("DUCK");
            } else {
                cell.setType("CAR");
            }
            things.add(cell);
        }
        TestRecyclerView adapter = new TestRecyclerView(things);
        mRecyclerView.setAdapter(adapter);
    }
}
