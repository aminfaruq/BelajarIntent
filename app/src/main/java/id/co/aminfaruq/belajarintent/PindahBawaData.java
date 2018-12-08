package id.co.aminfaruq.belajarintent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PindahBawaData extends AppCompatActivity {

    @BindView(R.id.txtData)
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_bawa_data);
        ButterKnife.bind(this);

        //TODO membuat variable penampung dan mengisinya dengan data dari intent
        //TODO membuat variable string dan mengambil data dari intent dengan tipe data string
        String nama = getIntent().getStringExtra(MainActivity.nama);
        //TODO membuat variable int dan mengambil data dari intent dengan tipe data integer
        Integer umur = getIntent().getIntExtra(MainActivity.umur, 0);//fungsinya di masukkan 0 hanya untuk defaultnya saja
        //TODO membuat variable double dan mengambil data dari intent dengan tipe data double
        Double berat = getIntent().getDoubleExtra(MainActivity.berat, 0);
        //TODO membuat variable boolean dan mengambil data dari intent dengan tipe data boolean
        Boolean jenis_kelamin = getIntent().getBooleanExtra(MainActivity.jenis_kelamin, true);

        //TODO mengeset/menampilkan text kedalam widget textview
        txtData.setText("Nama : " + nama + "\n" +"Umur : " + umur + "\n" + "Berat : " + berat + "\n" + "Jenis kelamin : " + jenis_kelamin);
    }
}
