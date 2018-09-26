package id.technoit.dev.appintent;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView txtUser;
    Button btnToast;
    Button btnAlert;
    Button btnInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //inisialisasi setiap id yang ada di layout
        txtUser = (TextView) findViewById(R.id.txtUser);
        btnToast = (Button) findViewById(R.id.btnToast);
        btnInput =(Button) findViewById(R.id.btnInput);
        btnAlert = (Button) findViewById(R.id.btnAlert);

        //buat get intent untuk menangkap kiriman intent dari IntroActivity
        Intent getData = getIntent();
        txtUser.setText(getData.getStringExtra("nama"));

        //buat event klik pada button toast
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuActivity.this, "Ini Event Toast",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //buat event btnalert
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MenuActivity.this);

                //icon untuk alert
                alert.setIcon(R.mipmap.ic_launcher);

                // judul alert
                alert.setTitle("Ini Contoh Alert Dialog!");
                //pesan pada alertalert.setMessage("isikan isi pesan alert apa aja ya ?");
                // buat alert button ok
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                //jangan lupa alert di show
                alert.show();
            }
        });

        //buat evnt pada btn input
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //berikan intent ke activity lain
                // sebelumnya buat activity baru, namanya InputdataActivity
                startActivity(new Intent(MenuActivity.this, InputActivity.class));
            }
        });
    }
}
