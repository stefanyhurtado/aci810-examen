package com.example.examen.db;

import java.util.List;

import com.example.examen.R;
import com.example.examen.db.Listerner.ListViewItemClickListerner;
import com.example.examen.db.db.MyAppDataSource;
import com.example.examen.db.model.Compra;



import android.os.Bundle;

import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CompraActivity extends ListActivity {
	

	public static final int REQUEST_CODE_ADD_COMPRA = 1;
	public static final int REQUEST_CODE_UPDATE_COMPRA = 2;
	
	public static final String EXTRA_COMPRA = "compra";
	public static final String EXTRA_REMOVE = "remove";

	private MyAppDataSource ds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compra);
		
		ds = new MyAppDataSource(this);
	    ds.open();
	    
	    List<Compra> values = ds.getCompras();
	   
	    // use the SimpleCursorAdapter to show the elements in a ListView
	    ArrayAdapter<Compra> adapter = new ArrayAdapter<Compra>(
	    		this,
	    		android.R.layout.simple_list_item_1, 
	    		values
	    	);
         this.setListAdapter(adapter);
	    
	    ListView liv = (ListView) this.findViewById(android.R.id.list);
	    liv.setOnItemClickListener(new ListViewItemClickListerner(this));
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(data.hasExtra(EXTRA_COMPRA))
		{
			List<Compra> values = ds.getCompras();
		    
		    // use the SimpleCursorAdapter to show the elements in a ListView
		    ArrayAdapter<Compra> adapter = new ArrayAdapter<Compra>(
		    		this,
		    		android.R.layout.simple_list_item_1, 
		    		values
		    	);
		    
		    ListView lv = (ListView) this.findViewById(android.R.id.list);
		    lv.setAdapter(adapter);
		    
			if(requestCode == REQUEST_CODE_ADD_COMPRA) {
				// do something here when a person is added
			}
			else if(requestCode == REQUEST_CODE_UPDATE_COMPRA)
			{
				Boolean remove = data.getBooleanExtra(EXTRA_REMOVE, false);
				
				if(remove) {
					// do something here when a lugar is removed
				}
				else {
					// do something here when a lugar is updated
				}
			}
			adapter.notifyDataSetChanged();
		}
	}

	



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compra, menu);
		return true;
	}
	public void onAddButtonClicked(View view) {
		Intent i = new Intent(this, ComprasActivity.class);
		this.startActivityForResult(i, REQUEST_CODE_ADD_COMPRA);
	}

}
