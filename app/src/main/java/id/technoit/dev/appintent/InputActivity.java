package id.technoit.dev.appintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    //deklarasi variebel
    EditText txtInput;
    Button btnSubmit;
    TextView txtCetak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        txtInput = (EditText) findViewById(R.id.txtInput);
        txtCetak = (TextView)findViewById(R.id.txtCetak);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //berikan event pada button input data
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //buat string unutk menangkap inputan dan mengubahnya ke data String
                String edtInput = txtInput.getText().toString();
                //kondisi jika data kosong akan ada pesan errror
                if (edtInput.isEmpty()){
                    txtInput.setError("Data harus di Isi");
                } else {

                    //toast untuk menampilkan data berhasil
                    Toast.makeText(InputActivity.this, "Succses !!", Toast.LENGTH_SHORT).show();

                    //data inputan di set pada text view
                    txtCetak.setText(edtInput);
                }
            }
        });


    }
}
