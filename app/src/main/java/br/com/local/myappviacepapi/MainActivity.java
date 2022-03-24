package br.com.local.myappviacepapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button btnBuscarCep;
    EditText txtCep;
    TextView lblResposta;
    TextView lblResposta2;
    TextView lblResposta3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCep = findViewById(R.id.txtCep);
        lblResposta = findViewById(R.id.lblResposta);
        lblResposta2 = findViewById(R.id.lblResposta2);
        lblResposta3 = findViewById(R.id.lblResposta3);
        btnBuscarCep = findViewById(R.id.btnBuscaCep);

        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String endereco = txtCep.getText().toString().trim();

                try {
                    //preencher o cep no lblResposta do layout
                    CEP retorno = new HttpService(txtCep.getText().toString().trim()).execute().get();
                    lblResposta.setText(retorno.toString());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //preencher o cep no lblResposta2 do layout
                    CEP retorno = new HttpService(txtCep.getText().toString().trim()).execute().get();
                    lblResposta2.setText(retorno.toString2());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //preencher o cep no lblResposta2 do layout
                    CEP retorno = new HttpService(txtCep.getText().toString().trim()).execute().get();
                    lblResposta3.setText(retorno.toString3());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}