package com.dclxvi.vahid.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class finish extends AppCompatActivity {
  private int emtiaz=0;
private ArrayList<String> arrayListNotRemove;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_finish);
    TextView txtResult=(TextView)findViewById(R.id.txtResult);
    Button btnExit=(Button)findViewById(R.id.btnExit);
    Button btnRestart=(Button)findViewById(R.id.btnRestart);
    Intent intent = getIntent();
    emtiaz=intent.getIntExtra("emtiaz",0);

    String Result = intent.getStringExtra("result");
    arrayListNotRemove = intent.getStringArrayListExtra("list");
    final String javab = intent.getStringExtra("javab");
    if(emtiaz<11)
    txtResult.setText(Result+"\n"+"javab is :\n"+javab);
    else
    txtResult.setText("خیلی برنده شدی همه شو فهمیدی :)"+"\n"+"javab is :\n"+javab);
    arrayListNotRemove.remove(arrayListNotRemove.indexOf(javab));
    btnExit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
    btnRestart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(finish.this,MainActivity.class);
        intent.putExtra("javab",javab);
        intent.putExtra("emtiaz", emtiaz);
        intent.putExtra("list",arrayListNotRemove);
        finish.this.startActivity(intent);
        finish();
      }
    });

  }

}
