package com.example.examen.db;


import com.example.examen.PrincipalActivity;
import com.example.examen.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Guardar_TitleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guardar__title);
		
		SharedPreferences sharedPref = getSharedPreferences("app-data", Context.MODE_PRIVATE);
		String Editar_Titulo = sharedPref.getString(Editar_TitleActivity.EDITAR_TITULO, "not set");
		 
		
		 TextView EditartTextView = (TextView) findViewById(R.id.TextView2);
	        EditartTextView.setText(Editar_Titulo);
	       
	        setupActionBar();
    }
	private void setupActionBar() {


        getActionBar().setDisplayHomeAsUpEnabled(true);


}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.guardar__title, menu);
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

	public void onEditarButtonClicked(View view) {
		Intent i = new Intent(this, Editar_TitleActivity.class);
		this.startActivity(i);
	}
	
	
	
	
	public void onNextButtonClicked(View view) {
        Intent intent=new Intent(this,PrincipalActivity.class);
        startActivity(intent);
       
}
}


