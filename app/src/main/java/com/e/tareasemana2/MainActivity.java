package com.e.tareasemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private DatePicker picker;
    private Button botonok;
    private Button botoncancel;
    private Button botonsiguiente;
    private EditText etNombre;
    private TextView tvFechaNacimiento;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String email;
    private String descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();

        if (parametros == null){
            etNombre = (EditText) findViewById(R.id.etNombre);
            tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
            picker = (DatePicker) findViewById(R.id.datePicker);
            etTelefono = (EditText) findViewById(R.id.etTelefono);
            etEmail = (EditText) findViewById(R.id.etEmail);
            etDescripcion = (EditText) findViewById(R.id.etDescripcion);
            botoncancel = (Button) findViewById(R.id.btnCancel);
            botonok = (Button) findViewById(R.id.btnOk);
            botonsiguiente = (Button) findViewById(R.id.btnSiguiente);
        }
        else {
            nombre = parametros.getString("nombre");
            fechaNacimiento = parametros.getString("fechaNacimiento");
            telefono = parametros.getString("telefono");
            email = parametros.getString("email");
            descripcion = parametros.getString("descripcion");


            etNombre = (EditText) findViewById(R.id.etNombre);
            tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
            picker = (DatePicker) findViewById(R.id.datePicker);
            etTelefono = (EditText) findViewById(R.id.etTelefono);
            etEmail = (EditText) findViewById(R.id.etEmail);
            etDescripcion = (EditText) findViewById(R.id.etDescripcion);
            botoncancel = (Button) findViewById(R.id.btnCancel);
            botonok = (Button) findViewById(R.id.btnOk);
            botonsiguiente = (Button) findViewById(R.id.btnSiguiente);

            etNombre.setText(nombre);
            tvFechaNacimiento.setText(fechaNacimiento);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        }

        botoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFechaNacimiento.setText("28/09/2020");
            }
        });


        botonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFechaNacimiento.setText(agregarCeros(picker.getDayOfMonth())+"/"+agregarCeros(picker.getMonth()+1)+"/"+picker.getYear());
                fechaNacimiento = tvFechaNacimiento.getText().toString();
            }
        });

        botonsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = etNombre.getText().toString();
                telefono = etTelefono.getText().toString();
                email = etEmail.getText().toString();
                descripcion = etDescripcion.getText().toString();

                Intent intent = new Intent(MainActivity.this, ConfirmarContacto.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("fechaNacimiento", fechaNacimiento);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);
                startActivity(intent);
                finish();
            }
        });
    }



    private String agregarCeros(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }
}