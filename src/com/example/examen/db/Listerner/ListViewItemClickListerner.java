package com.example.examen.db.Listerner;


import com.example.examen.db.CompraActivity;
import com.example.examen.db.ComprasActivity;
import com.example.examen.db.LugarActivity;

import com.example.examen.db.PrimerActivity;

import com.example.examen.db.model.Compra;
import com.example.examen.db.model.Lugar;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

public class ListViewItemClickListerner implements AdapterView.OnItemClickListener{


    private Activity activity;

public ListViewItemClickListerner(Activity activity) {
	this.activity = activity;
}

public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	  Object o = parent.getItemAtPosition(position);



	  if(o instanceof Lugar)
	  {
	    Lugar lugar = (Lugar) o;
	    Intent i = new Intent(this.activity, LugarActivity.class);
	    i.putExtra("lugar", lugar);
	    this.activity.startActivityForResult(i, PrimerActivity.REQUEST_CODE_UPDATE_LUGAR);
	  }
	  else if(o instanceof Compra)
	  {
	    Compra compra = (Compra) o;
	    Intent i = new Intent(this.activity, ComprasActivity.class);
	    i.putExtra("compra", compra);
	    this.activity.startActivityForResult(i, CompraActivity.REQUEST_CODE_UPDATE_COMPRA);
	  }


}
}

    





