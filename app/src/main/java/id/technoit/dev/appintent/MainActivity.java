package id.technoit.dev.appintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel
    EditText txtNama;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi id dari layout ada 2 widget
        txtNama = (EditText) findViewById(R.id.txtNama);
        btnSubmit = findViewById(R.id.btnSubmit);

        //buat button ada event klik
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //buat string untuk mendapatkan data dari editext/ inputan
                String edt = txtNama.getText().toString();

                //buat kondisi
                if (edt.isEmpty()){
                    txtNama.setError("Data Tidak Bisa Kosong");
                } else {
                    //implementasi intent, panggil kelas Intent, objek intent
                    Intent kirimData = new Intent(MainActivity.this, MainActivity.class);

                    //mengirim data dengan key "nama"
                    kirimData.putExtra("nama", edt);

                    //setiap penggunaan intent harus di pakai start activity
                    startActivity(kirimData);

                    //finish utk mengakhiri activity
                    finish();
                }
            }
        });

    }
}
