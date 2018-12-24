package com.example.lenovo.testdatabase;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lenovo.testdatabase.Friend;
import com.example.lenovo.testdatabase.DBHelper;

import java.util.List;


public class MainActivity extends ListActivity {

    DBHelper mHelper;
    List<String> friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHelper = new DBHelper(this);
        friends = mHelper.getFriendList();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, friends);

        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            Intent addFriend = new Intent(this, AddFriendActivity.class);

            startActivity(addFriend);
            overridePendingTransition(android.R.anim.fade_in,
                    android.R.anim.fade_out);
        }
        return super.onOptionsItemSelected(item);
    }
}


