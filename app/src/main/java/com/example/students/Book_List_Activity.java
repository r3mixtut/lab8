package com.example.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import  android.content.Intent;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;

public class Book_List_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book__list_);
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String author = ((Books_genre) adapterView.getItemAtPosition(i)).toString();
                Intent intent =new Intent(Book_List_Activity.this, genreBooksActivity.class);
                intent.putExtra(BooksListActivity.AUTHOR, author);
                startActivity(intent);
            }
        };
        ListView listView = (ListView) findViewById(R.id.author_list);
        listView.setOnItemClickListener(listener);
        ArrayAdapter<Books_genre> adapter = new ArrayAdapter<Books_genre>(
                this,
                android.R.layout.simple_list_item_1,
                Books_genre.getGenreList()
        );
        listView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView listView = (ListView) findViewById(R.id.author_list);
        ArrayAdapter<Books_genre> adapter = new ArrayAdapter<Books_genre>(
          this,
                android.R.layout.simple_list_item_1,
                Books_genre.getGenreList()
        );
        listView.setAdapter(adapter);
    }

    public void onGenerAddClick(View view){
        startActivity(
                new Intent(this, AddAuthor.class)
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.author_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_Author:
                startActivity(
                        new Intent(this, AddAuthor.class)
                );
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}