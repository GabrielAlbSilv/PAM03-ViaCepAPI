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
    TextView lblCep;
    TextView lblLogradouro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCep = findViewById(R.id.txtCep);
        lblCep = findViewById(R.id.lblCep);
        lblLogradouro = findViewById(R.id.lblLogradouro);
        btnBuscarCep = findViewById(R.id.btnBuscaCep);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String endereco = txtCep.getText().toString().trim();

                try {
                    //preencher o cep no lblResposta do layout
                    CEP retorno = new HttpService(txtCep.getText().toString().trim()).execute().get();
                    lblCep.setText("CEP: " + retorno.getCep());
                    lblLogradouro.setText("Logradouro"+retorno.getLogradouro());
                    retorno.getBairro();
                    retorno.getLocalidade();
                    retorno.getUf();

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}