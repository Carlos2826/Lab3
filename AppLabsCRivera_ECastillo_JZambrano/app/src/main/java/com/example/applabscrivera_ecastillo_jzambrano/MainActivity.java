package com.example.applabscrivera_ecastillo_jzambrano;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applabscrivera_ecastillo_jzambrano.helpers.CustomDialog;

public class MainActivity extends AppCompatActivity {
    
    EditText txtNum1, txtNum2;
    TextView lblRes;
    RadioGroup rbgOper;
    RadioButton rbtSuma, rbtResta, rbtMult, rbtDiv;
    CheckBox chkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.InicializarControles();
    }

    private void InicializarControles() {
        txtNum1=(EditText)findViewById(R.id.txtNum1);
        txtNum2=(EditText)findViewById(R.id.txtNum2);
        rbgOper=(RadioGroup)findViewById(R.id.rbgOper);
        rbtSuma=(RadioButton)findViewById(R.id.rbtSuma);
        rbtResta=(RadioButton)findViewById(R.id.rbtResta);
        rbtMult=(RadioButton)findViewById(R.id.rbtMult);
        rbtDiv=(RadioButton)findViewById(R.id.rbtDiv);
        chkBox=(CheckBox)findViewById(R.id.chkBox);

        lblRes=(TextView)findViewById(R.id.lblResultado);
    }

    public void CalcularValor(View view)
    {

        try{
            String val = txtNum1.getText().toString();
            String val2 = txtNum2.getText().toString();
            if(val.isEmpty() || val2.isEmpty()){
                CustomDialog dialog = new CustomDialog("No deje espacios vacio");
                dialog.show(getSupportFragmentManager(),"");
            }
            int n1 = Integer.parseInt(txtNum1.getText().toString());
            int n2 = Integer.parseInt(txtNum2.getText().toString());

            int resultado = 0;

            int operacion = rbgOper.getCheckedRadioButtonId();

            if(operacion == R.id.rbtSuma)
                resultado = n1 + n2;
            else if(operacion == R.id.rbtResta)
                resultado = n1 - n2;
            else if(operacion == R.id.rbtMult)
                resultado = n1 * n2;
            else if(operacion == R.id.rbtDiv)
                resultado = n1 / n2;

            if(chkBox.isChecked()) {
                CustomDialog dialog = new CustomDialog("El resultado es: "+ resultado);
                dialog.show(getSupportFragmentManager(),"");
            }
            else
                lblRes.setText("El resultado de la operacion es: "+resultado);
        }
        catch (Exception e)
        {
            CustomDialog dialog = new CustomDialog("Hemos encontrado este error: " + e.getMessage());
            dialog.show(getSupportFragmentManager(),"");
        }

    }

}