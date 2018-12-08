package id.co.aminfaruq.belajarintent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PindahBawaObject extends AppCompatActivity {

    @BindView(R.id.txtData)
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_bawa_object);
        ButterKnife.bind(this);

        //TODO membuat variable untuk menampung  dan mengisi object dari intent sebelumnya
        Person person = getIntent().getParcelableExtra(MainActivity.OBJ);

        //TODO membuat variable penampung data dari dalam object
        String isiData = "Nama : " + person.getNama() + "\n umur : " + person.getAge() +
                "\n alamat : " + person.getAlamat() + "\n asal : " + person.getAsal() +
                "\n pekerjaan : " + person.getPekerjaan();
        //TODO menampilkan data ke widget textview
        txtData.setText(isiData);
    }
}
