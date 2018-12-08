package id.co.aminfaruq.belajarintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String OBJ = "OBJ";
    public static final int REQUEST_CODE = 1;
    public static final String EXTRA_DATA = "data";
    @BindView(R.id.btnPindahHalaman)
    Button btnPindahHalaman;
    @BindView(R.id.btnPindahBawadata)
    Button btnPindahBawadata;
    @BindView(R.id.btnPindahBawaObject)
    Button btnPindahBawaObject;
    @BindView(R.id.btnCallPhone)
    Button btnCallPhone;
    @BindView(R.id.btnEmail)
    Button btnEmail;
    @BindView(R.id.btnCallBack)
    Button btnCallBack;
    public static final String nama = "nama";
    public static final String umur = "umur";
    public static final String berat = "berat";
    public static final String jenis_kelamin = "jenis_kelamin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnPindahHalaman, R.id.btnPindahBawadata, R.id.btnPindahBawaObject, R.id.btnCallPhone, R.id.btnEmail, R.id.btnCallBack})
    public void onViewClicked(View view) {
        //TODO membuat variable intend global
        Intent pindah;
        switch (view.getId()) {
            case R.id.btnPindahHalaman:
                //TODO membuat perpindahan
                pindah = new Intent(this,PindahHalaman.class);
                startActivity(pindah);
                break;
            case R.id.btnPindahBawadata:
                //TODO membuat object intent untuk berpindah ke activity tujuan
                pindah = new Intent(this,PindahBawaData.class);
                //TODO mengisi data ke intent
                pindah.putExtra(nama,"amin faruq");
                pindah.putExtra(umur,17);
                pindah.putExtra(berat,60.0);
                pindah.putExtra(jenis_kelamin,true);
                //TODO jalankan intent
                startActivity(pindah);
                break;
            case R.id.btnPindahBawaObject:
                //TODO membuat object dari data class person
                Person person = new Person();

                //TODO masukkan data ke dalam object
                person.setNama("amin faruq");
                person.setAge(17);
                person.setAlamat("kalimantan");
                person.setAsal("samarinda");
                person.setPekerjaan("software enginering");

                //TODO membuat object intent
                pindah = new Intent(this,PindahBawaObject.class);


                //TODO mengisikan object person ke dalam intent
                pindah.putExtra(OBJ,person);

                startActivity(pindah);
                break;
            case R.id.btnCallPhone:
                //TODO membuat variable untuk menampung no hp yang kita inginkan
                String noTelp = "081346504123";

                //TODO membuat object intent untuk memanggil intent telpon
                pindah = new Intent(Intent.ACTION_DIAL);
                //TODO menset no telp ke dalam intent
                pindah.setData(Uri.parse("tel:"+ noTelp));
                //TODO menjalankan intent
                startActivity(pindah);
                break;
            case R.id.btnEmail:
                //TODO membuat intent untuk memanggil email
                pindah = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","ziadsm24@gmail.com",null));

                //TODO memasukkan subject dan isi pesan ke dalam intent
                pindah.putExtra(Intent.EXTRA_SUBJECT,"Surat cinta untuk starla");
                pindah.putExtra(Intent.EXTRA_TEXT,"Kutuliskan kenangan tentang caraku menemukan dirimu" +
                "\n tentang apa yang membuat ku mudah berikan kasihku padamu");

                //TODO mencek apakah user memiliki aplikasi email
                if (pindah.resolveActivity(getPackageManager()) != null){
                    //TODO memanggil intent dan memunculkan popup memilih aplikasi
                    startActivity(Intent.createChooser(pindah,"pilih email client"));
                }else {
                    Toast.makeText(this,"tidak ada email client",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCallBack:
                //TODO membuat object intent untuk berpindah halaman ke tujuan
                pindah = new Intent(this,PindahCallBack.class);
                //TODO jalankan intent dan membawa name key untuk request data
                startActivityForResult(pindah, REQUEST_CODE);//klik comand + alt + c
                break;
        }
    }

    //klik control + o
    // pilih on activity result

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //TODO mencek request apakah sama dengan yang di kirimkan
        if (requestCode == REQUEST_CODE){
            //TODO cek lagi request code apakah ok
            if (resultCode == RESULT_OK){
                //TODO menampung data dari callback
                String menampilkanData = data.getStringExtra(EXTRA_DATA);//klik comand + alt + c lalu ketik EXTRA_DATA
                //TODO menampilkan data ke toast
                Toast.makeText(this,"Ini data callnya adalah" + menampilkanData,Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Tidak ada hasil", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
