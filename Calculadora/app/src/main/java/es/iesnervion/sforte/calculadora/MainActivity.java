package es.iesnervion.sforte.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text;
    TextView prevNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.numbers);
        prevNumber = findViewById(R.id.prevNumber);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn0 = findViewById(R.id.btn0);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubstract = findViewById(R.id.btnSubstract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnOperate = findViewById(R.id.btnOperate);
        Button btnErase = findViewById(R.id.btnErase);
        Button btnComma = findViewById(R.id.btnComma);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubstract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnOperate.setOnClickListener(this);
        btnErase.setOnClickListener(this);
        btnComma.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        float number = 0;

        switch (view.getId()){

            case R.id.btn1:

                text.setText(text.getText() + "1");

                break;

            case R.id.btn2:

                text.setText(text.getText() + "2");

                break;

            case R.id.btn3:

                text.setText(text.getText() + "3");

                break;

            case R.id.btn4:

                text.setText(text.getText() + "4");

                break;

            case R.id.btn5:

                text.setText(text.getText() + "5");

                break;

            case R.id.btn6:

                text.setText(text.getText() + "6");


                break;

            case R.id.btn7:

                text.setText(text.getText() + "7");

                break;

            case R.id.btn8:

                text.setText(text.getText() + "8");

                break;

            case R.id.btn9:

                text.setText(text.getText() + "9");

                break;

            case R.id.btn0:

                text.setText(text.getText() + "0");

                break;

            case R.id.btnErase:

                text.setText(null);

                break;

            case R.id.btnComma:

                text.setText(text.getText() + ".");

                break;

            case R.id.btnAdd:

                text.setText(text.getText() + "+");

                break;

            case R.id.btnSubstract:

                text.setText(text.getText() + "-");


                break;

            case R.id.btnMultiply:

                text.setText(text.getText() + "*");

                break;

            case R.id.btnDivide:

                text.setText(text.getText() + "/");


                break;

            case R.id.btnOperate:

                String operation = (String) text.getText();
                String[] result = operation.split("(?<=[^\\d.])(?=\\d)|(?<=\\d)(?=[^\\d.])");
                String operator = null; //Inicia en null para la primera instancia
                float answer = 0;

                for (String s : result) {
                    if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ) { //Aqui comprobamos si es un numero o un signo
                        operator = s; //En caso de serlo lo guardamos
                    }
                    else {
                        if (operator == null) { //Esto es para el caso de la primera operacion, para guardar el primer numero
                            answer = Float.parseFloat(s);
                        } else { //En caso de ser un numero operamos con el signo que se ha debido guardar previamente
                            if (operator.equals("+")) {
                                answer = answer + Float.parseFloat(s);
                            } else if (operator.equals("-")) {
                                answer = answer - Float.parseFloat(s);
                            } else if (operator.equals("*")) {
                                answer *= Float.parseFloat(s);
                            } else if (operator.equals("/")) {
                                answer /= Float.parseFloat(s);
                            }


                        }
                    }
                }

                text.setText(Float.toString(answer));

                break;
        }

    }
}