package com.example.examen.db;

import com.example.examen.R;
import com.example.examen.db.db.MyAppDataSource;
import com.example.examen.db.model.Compra;


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

public class ComprasActivity extends Activity {
	
	 private MyAppDataSource ds;
     private Compra compraToUpdate;
     


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compras);
		
		
		 setupActionBar();


         
         ds = new MyAppDataSource(this);
     ds.open();
     
     Intent i = this.getIntent();
     
     
     if(i.hasExtra(CompraActivity.EXTRA_COMPRA))
     {
             Compra co = (Compra) i.getSerializableExtra(CompraActivity.EXTRA_COMPRA);
             
             EditText compra = (EditText) this.findViewById(R.id.EditText4);
             compra.setText(co.getCompra());
                 
                 EditText descriptions = (EditText) this.findViewById(R.id.EditText5);
                 descriptions.setText(co.getDescriptions());
                 
                 
                 Button saveButton = (Button) this.findViewById(R.id.saveButton);
                 saveButton.setText("Update");
                 
                 Button deleteButton = (Button) this.findViewById(R.id.deleteButton);
                 deleteButton.setVisibility(Button.VISIBLE);
                 
                 this.setTitle("Update Note");
                 
                 this.compraToUpdate = co;
     }
     else
     {
             Button saveButton = (Button) this.findViewById(R.id.saveButton);
             
             saveButton.setText("Create");
             
             Button deleteButton = (Button) this.findViewById(R.id.deleteButton);
             deleteButton.setVisibility(Button.VISIBLE);
             
             this.setTitle("Create Compra");
             
             this.compraToUpdate = null;
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
		getMenuInflater().inflate(R.menu.compras, menu);
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
            EditText compra = (EditText) this.findViewById(R.id.EditText4);
            String compra1 = compra.getText().toString();
            
            EditText descriptions = (EditText) this.findViewById(R.id.EditText5);
            String descriptions1 = descriptions.getText().toString();
            
            
            if(compra1.isEmpty() || descriptions1.isEmpty())
            {
                    Toast.makeText(this, "Complete the form before saving", Toast.LENGTH_LONG).show();
                    return;
            }
            
            Compra co = null;
            
            if(this.compraToUpdate != null)
            {
                    co = ds.updateCompra(this.compraToUpdate, compra1, descriptions1);
            }
            else
            {
                    
                co = ds.createCompra(compra1, descriptions1); 
            
                    
            }
            
            Intent i = new Intent();
            i.putExtra(CompraActivity.EXTRA_COMPRA, co);
            i.putExtra(CompraActivity.EXTRA_REMOVE, false);
            this.setResult(RESULT_OK, i);
            
            this.finish();
    }
    
    public void onDeleteButtonClicked(View view) {
            
            Compra co = ds.deleteCompra(this.compraToUpdate);
            
            Intent i = new Intent();
            i.putExtra(CompraActivity.EXTRA_COMPRA, co);
            i.putExtra(CompraActivity.EXTRA_REMOVE, true);
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
