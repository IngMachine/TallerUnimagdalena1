package co.edu.unimagdalena.appmoviles.tallerunimagdalena1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText n1,n2;
    Button sumar,restar,multiplicar,dividir,mcd,mnm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        n1 = findViewById(R.id.edtn1);
        n2 = findViewById(R.id.edtn2);
        sumar = findViewById(R.id.btnsumar);
        restar = findViewById(R.id.btnrestar);
        multiplicar = findViewById(R.id.btnmultiplicar);
        dividir = findViewById(R.id.btndividir);
        mcd = findViewById(R.id.btnmcd);
        mnm = findViewById(R.id.btnmnm);
        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
        mcd.setOnClickListener(this);
        mnm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String number1 = n1.getText().toString();
        String number2 = n2.getText().toString();

        if(number1.isEmpty() || number2.isEmpty()){
            Toast.makeText(this,"Vacio", Toast.LENGTH_LONG).show();
        }else{
            int num1 = Integer.parseInt(n1.getText().toString());
            int num2 = Integer.parseInt(n2.getText().toString());
            switch (view.getId()){
                case R.id.btnsumar:
                    Toast.makeText(this,"Suma ="+ (num1 + num2) , Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnrestar:
                    Toast.makeText(this,"Restar =" + (num1 - num2) , Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnmultiplicar:
                    Toast.makeText(this,"Multiplicar ="+ (num1 * num2) , Toast.LENGTH_LONG).show();
                    break;
                case R.id.btndividir:
                    if(num2==0){
                        Toast.makeText(this,"No se pudo realizar la division", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this,"Division = "+ (num1 / num2) , Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btnmcd:
                    while(num1 != num2)
                        if(num1 > num2)
                            num1 = num1-num2;
                        else
                            num2 = num2 - num1;
                    Toast.makeText(this,"El MCD es =" + num1 , Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnmnm:
                    int mcm , i;
                    mcm = 1;
                    i = 2;
                    while(i <= num1 || i <= num2)
                    {
                        if(num1 % i == 0 || num2 % i == 0)
                        {
                            mcm=mcm*i;
                            if(num1 % i == 0) num1 = num1 / i;
                            if(num2 % i == 0) num2 = num2 / i;
                        }
                        else
                            i = i + 1;
                    }
                    Toast.makeText(this,"El MCM es =" + mcm , Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}