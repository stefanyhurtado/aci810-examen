package com.example.examen.db;



import com.example.examen.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class Editar_TitleActivity extends Activity {
	
	public final static String EDITAR_TITULO ="com.example.examen.db.EDITAR_TITULO";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar__title);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar__title, menu);
		return true;
	}
	public void onGuardarButtonClicked(View view) {
        Intent intent=new Intent(this,Guardar_TitleActivity.class);
        
        EditText EditartEditText = (EditText) findViewById(R.id.EditText1);
        String Editar_Titulo = EditartEditText.getText().toString();
        TextView EditartTextView = (TextView) findViewById(R.id.TextView1);
        EditartTextView.setText(Editar_Titulo);
      
        
        SharedPreferences sharedPref = getSharedPreferences("app-data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(EDITAR_TITULO, Editar_Titulo);
      
        editor.commit();

 		
        startActivity(intent);
     }
        
       
}

	




