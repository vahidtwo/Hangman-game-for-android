package com.dclxvi.vahid.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  TextView btnA;
  TextView btnB;
  TextView btnC;
  TextView btnD;
  TextView btnE;
  TextView btnF;
  TextView btnG;
  TextView btnH;
  TextView btnI;
  TextView btnJ;
  ImageView imgView;
  TextView btnK;
  TextView txtEmtiaz;
  TextView btnL;
  TextView btnM;
  TextView btnN;
  TextView btnO;
  TextView btnP;
  TextView btnQ;
  TextView btnR;
  TextView btnS;
  TextView btnT;
  TextView btnU;
  TextView txtView ;
  TextView btnV;
  TextView btnW;
  TextView btnX;
  TextView btnY;
  TextView btnZ;
  TextView btnRestart;
  private String word_dashed;
  private int eshtebah;
  private int emtiaz =0;
  private ArrayList<String> list = new ArrayList<String>();
  private ArrayList<String> newArraylist = new ArrayList<String>();
  private String selectWord() {
    Intent getEx = getIntent();
    if(getEx.hasExtra("list")){
       newArraylist = getEx.getStringArrayListExtra("list");
    }
    if (newArraylist.size() == 0) {
      list.add("kuchulu");
      list.add("gusale");
      list.add("Selite");
      list.add("aghrab");
      list.add("Nargil");
      list.add("susAno");
      list.add("daftare mashgh");
      list.add("shomal");
      list.add("yeki bud yeki nabud");
      list.add("khale ghezi");
      list.add("shahin");
    } else {
      list.clear();
      list = newArraylist;
    }
    return list.get((int) (Math.random() * list.size()));
  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    txtEmtiaz = (TextView) findViewById(R.id.txtEmtiaz);
    Intent getEx = getIntent();
    if(getEx.hasExtra("emtiaz"))
      emtiaz = getEx.getIntExtra("emtiaz", 0);
    if (emtiaz != 0) {
      txtEmtiaz.setText("emtiaz hast :" + emtiaz);
    }
    final Intent intent = new Intent(MainActivity.this,finish.class);

    final String notLowerCaseWord = selectWord();
    final String loweCaseWordInput =notLowerCaseWord.toLowerCase();
    eshtebah = 0 ;
    word_dashed = "";
    for (int i = 0; i < loweCaseWordInput.length(); i++) {
      if (loweCaseWordInput.charAt(i)!= ' ') {
        word_dashed+="-";
      }
      else
        word_dashed+=" ";
    }
    txtView =(TextView) findViewById(R.id.txtView);
    txtView.setText(word_dashed);
    imgView = (ImageView)findViewById(R.id.imgView);
    btnA = (TextView) findViewById(R.id.btnA);
    btnB = (TextView) findViewById(R.id.btnB);
    btnC = (TextView) findViewById(R.id.btnC);
    btnD = (TextView) findViewById(R.id.btnD);
    btnE = (TextView) findViewById(R.id.btnE);
    btnF = (TextView) findViewById(R.id.btnF);
    btnG = (TextView) findViewById(R.id.btnG);
    btnH = (TextView) findViewById(R.id.btnH);
    btnI = (TextView) findViewById(R.id.btnI);
    btnJ = (TextView) findViewById(R.id.btnJ);
    btnK = (TextView) findViewById(R.id.btnK);
    btnL = (TextView) findViewById(R.id.btnL);
    btnM = (TextView) findViewById(R.id.btnM);
    btnN = (TextView) findViewById(R.id.btnN);
    btnO = (TextView) findViewById(R.id.btnO);
    btnP = (TextView) findViewById(R.id.btnP);
    btnQ = (TextView) findViewById(R.id.btnQ);
    btnR = (TextView) findViewById(R.id.btnR);
    btnS = (TextView) findViewById(R.id.btnS);
    btnT = (TextView) findViewById(R.id.btnT);
    btnU = (TextView) findViewById(R.id.btnU);
    btnV = (TextView) findViewById(R.id.btnV);
    btnW = (TextView) findViewById(R.id.btnW);
    btnX = (TextView) findViewById(R.id.btnX);
    btnY = (TextView) findViewById(R.id.btnY);
    btnZ = (TextView) findViewById(R.id.btnZ);
    btnRestart = (TextView) findViewById(R.id.btnRestart);
    View.OnClickListener listener = new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(word_dashed.contains("-")) {
          if (eshtebah < 8) {
            TextView textView = (TextView) view;
            String textInput = textView.getText().toString();
            String LowertextInput = textInput.toLowerCase();
            textView.setVisibility(View.INVISIBLE);
            if (loweCaseWordInput.contains(LowertextInput)) {
              for (int i = 0; i < loweCaseWordInput.length(); i++)
                if (loweCaseWordInput.charAt(i) == LowertextInput.charAt(0)) {
                  char[] wordDashedCharArray = word_dashed.toCharArray();
                  wordDashedCharArray[i] = notLowerCaseWord.charAt(i);
                  word_dashed = new String(wordDashedCharArray);

                }
              txtView.setText(word_dashed);
              if (!word_dashed.contains("-")) {
                emtiaz++;
                intent.putExtra("result", "برنده شدی  ");
                intent.putExtra("list", list);
                intent.putExtra("emtiaz", emtiaz);
                intent.putExtra("javab", notLowerCaseWord);
                MainActivity.this.startActivity(intent);
                finish();
              }
            } else
              eshtebah++;

            int img = R.drawable.face_1;
            switch (eshtebah) {
              case 0:
                img = R.drawable.face_1;
                break;
              case 1:
                img = R.drawable.face_2;
                break;
              case 2:
                img = R.drawable.face_3;
                break;
              case 3:
                img = R.drawable.face_4;
                break;
              case 4:
                img = R.drawable.face_5;
                break;
              case 5:
                img = R.drawable.face_6;
                break;
              case 6:
                img = R.drawable.face_7;
                break;
              case 7:
                img = R.drawable.face_8;
                break;
              case 8:
                img = R.drawable.face_9;
                break;
              default:
                img = R.drawable.face_9;

            }
            imgView.setImageResource(img);

          } else {

            intent.putExtra("result", "باخته شدی  ");
            intent.putExtra("list", list);
            intent.putExtra("emtiaz", emtiaz);
            MainActivity.this.startActivity(intent);
            finish();
          }

        }
      }
    };
    btnA.setOnClickListener(listener);
    btnB.setOnClickListener(listener);
    btnC.setOnClickListener(listener);
    btnD.setOnClickListener(listener);
    btnE.setOnClickListener(listener);
    btnF.setOnClickListener(listener);
    btnG.setOnClickListener(listener);
    btnH.setOnClickListener(listener);
    btnI.setOnClickListener(listener);
    btnJ.setOnClickListener(listener);
    btnK.setOnClickListener(listener);
    btnL.setOnClickListener(listener);
    btnM.setOnClickListener(listener);
    btnN.setOnClickListener(listener);
    btnO.setOnClickListener(listener);
    btnP.setOnClickListener(listener);
    btnQ.setOnClickListener(listener);
    btnR.setOnClickListener(listener);
    btnS.setOnClickListener(listener);
    btnT.setOnClickListener(listener);
    btnU.setOnClickListener(listener);
    btnV.setOnClickListener(listener);
    btnW.setOnClickListener(listener);
    btnX.setOnClickListener(listener);
    btnY.setOnClickListener(listener);
    btnZ.setOnClickListener(listener);
    btnRestart.setOnClickListener(listener);

  }
}
