package com.example.examen;

import com.example.examen.db.CompraActivity;
import com.example.examen.db.PrimerActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class PrincipalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}
	public void onClickLugar(View view){
        Intent lugar = new Intent(this,PrimerActivity.class);
        this.startActivity(lugar);
}

public void onClickCompra(View view){
        Intent compra = new Intent(this,CompraActivity.class);
        this.startActivity(compra);
}


}
