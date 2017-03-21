package com.alaa.restaurant;

import android.app.Activity;
import android.app.FragmentManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.*;


public class MainActivity extends Activity implements FragmentA.Communicator{
	FragmentA fa;
	FragmentB fb;
	FragmentManager manager;
	Button btn;
	EditText txt;
	DatabaseHelper dbh;
	SQLiteDatabase db;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getFragmentManager();
        
        fa=(FragmentA) manager.findFragmentById(R.id.fragment1);
        fa.setComm(this);
        dbh=new DatabaseHelper(this);
        db = dbh.getWritableDatabase();
        dbh.onCreate(db);
        btn=(Button)findViewById(R.id.btn_addCategory);
        txt=(EditText)findViewById(R.id.txt_addCategory);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
                if (validation()) {
					boolean status;
					status=dbh.AddCategory(txt.getText().toString());
					if(status)
						printMsg("New Category Added");
                }
            }
		});
    }
    public boolean validation(){
        if (txt.getText().toString().equals("")) {
    	{
    		printMsg("Name is required");
    		return false;
    	}	
    	return true;
    }

    public void printMsg(String msg){
    	Toast.makeText(this, msg,Toast.LENGTH_LONG).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void respond(int index) {
		fb=(FragmentB) manager.findFragmentById(R.id.fragment2);
		fb.ChangeData(index);
	}
}
