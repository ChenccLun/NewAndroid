package com.example.newandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BookListActivity extends AppCompatActivity {

    private Button toIsbnBtn = null;
    private Button toBookListBtn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get component
        toIsbnBtn = findViewById(R.id.homeButton1);
        toBookListBtn = findViewById(R.id.homeButton2);

        //bind event
        toIsbnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookListActivity.this,ISBNActivity.class);
                startActivity(intent);
            }
        });
    }
}