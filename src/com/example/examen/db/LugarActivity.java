package com.example.examen.db;

import com.example.examen.R;
import com.example.examen.db.db.MyAppDataSource;
import com.example.examen.db.model.Lugar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LugarActivity extends Activity {
	
	private MyAppDataSource ds;
	private Lugar lugarToUpdate;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lugar);
		// Show the Up button in the action bar.
		setupActionBar();
		
		ds = new MyAppDataSource(this);
	    ds.open();
	    
	    Intent i = this.getIntent();
	    
	    if(i.hasExtra(PrimerActivity.EXTRA_LUGAR))
	    {
	    	Lugar l = (Lugar) i.getSerializableExtra(PrimerActivity.EXTRA_LUGAR);
	    	
	    	EditText name = (EditText) this.findViewById(R.id.EditText2);
			name.setText(l.getName());
			
			EditText description = (EditText) this.findViewById(R.id.EditText3);
			description.setText(l.getDescription());
			
			Button saveButton = (Button) this.findViewById(R.id.saveButton);
			saveButton.setText("Update");
			
			Button deleteButton = (Button) this.findViewById(R.id.deleteButton);
			deleteButton.setVisibility(Button.VISIBLE);
			
			this.setTitle("Update Lugar");
			
			this.lugarToUpdate = l;
	    }
	    else
	    {
	    	Button saveButton = (Button) this.findViewById(R.id.saveButton);
	    	saveButton.setText("Create");
	    	
	    	Button deleteButton = (Button) this.findViewById(R.id.deleteButton);
	    	deleteButton.setVisibility(Button.VISIBLE);
	    	
	    	this.setTitle("Create Lugar");
	    	
	    	this.lugarToUpdate = null;
	    }
	}

/**
* Set up the {@link android.app.ActionBar}.
*/
private void setupActionBar() {

getActionBar().setDisplayHomeAsUpEnabled(true);

}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lugar, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onSaveButtonClicked(View view) {
		
		EditText name = (EditText) this.findViewById(R.id.EditText2);
		String name1 = name.getText().toString();
		
		EditText description = (EditText) this.findViewById(R.id.EditText3);
		String description1 = description.getText().toString();
		
		
		if(name1.isEmpty() || description1.isEmpty())
		{
			Toast.makeText(this, "Complete the form before saving", Toast.LENGTH_LONG).show();
			return;
		}
		
		Lugar l = null;
		
		if(this.lugarToUpdate != null)
		{
			l = ds.updateLugar(this.lugarToUpdate, name1, description1);
		}
		else
		{
			l = ds.createLugar(name1, description1);
		}
		
		Intent i = new Intent();
		i.putExtra(PrimerActivity.EXTRA_LUGAR, l);
		i.putExtra(PrimerActivity.EXTRA_REMOVE, false);
		this.setResult(RESULT_OK, i);
		
		this.finish();
	}
	
	public void onDeleteButtonClicked(View view) {
		
		Lugar l = ds.deleteLugar(this.lugarToUpdate);
		
		Intent i = new Intent();
		i.putExtra(PrimerActivity.EXTRA_LUGAR, l);
		i.putExtra(PrimerActivity.EXTRA_REMOVE, true);
		this.setResult(RESULT_OK, i);
		
		this.finish();
	}
	
	@Override
	protected void onResume() {
		ds.open();
		super.onResume();
	}

	@Override
	protected void onPause() {
		ds.close();
		super.onPause();
	}

}



