package com.example.baothien.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList todos = new ArrayList<>();
        todos.add("kjøpe mat");
        todos.add("spise ost");
        todos.add("Trene");
        todos.add("programmer");

        final ArrayAdapter<String> todoListAdapter = new ArrayAdapter<String>(this, R.layout.todo_element, todos);
        final ListView todoListView = (ListView) findViewById(R.id.todoListView);

        todoListView.setAdapter(todoListAdapter);

        final EditText text = (EditText) findViewById(R.id.editText1);


        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = text.getEditableText().toString();
                todos.add(input);
                todoListAdapter.notifyDataSetChanged();

            }
        });

        // change to a new page/ activity
        Button next = (Button) findViewById(R.id.buttonNextPage);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent2 = new Intent(this, Main2Activity.class);
                startActivity(new Intent(MainActivity.this, Activity2.class));
            }
        });



    }
    // change activity, page on the same screen
    public void openWindow(View view) {
        setContentView(R.layout.content_main2nd);
    }
}
