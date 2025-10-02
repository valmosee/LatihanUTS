package latihan.c14230225.latihanuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _txtSatu = findViewById<EditText>(R.id.txtInSatu)
        val _txtDua = findViewById<EditText>(R.id.txtInDua)
        val _btnAdd = findViewById<Button>(R.id.btnTambah)

        if (savedInstanceState == null) {
            val fsatu = FSatu()
            val bundle = Bundle().apply {
                putInt("angka1", 0)
                putInt("angka2", 0)
            }
            fsatu.arguments = bundle

            replaceFragmentOp(fsatu)
            replaceFragmentHasil(FHasil())
        }


        _btnAdd.setOnClickListener {
            val angka1 = _txtSatu.text.toString().toInt()
            val angka2 = _txtDua.text.toString().toInt()
            val hasilOp = angka1 + angka2

            val fragmentHasil = FHasil()
            val bundleHasil = Bundle().apply {
                putString("hasil", "$hasilOp")
            }
            fragmentHasil.arguments = bundleHasil
            replaceFragmentHasil(fragmentHasil)

            val fsatu = FSatu()
            val bundleOp = Bundle().apply {
                putInt("angka1", angka1)
                putInt("angka2", angka2)
            }
            fsatu.arguments = bundleOp
            replaceFragmentOp(fsatu)
        }
    }

    private fun replaceFragmentOp(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frag_operasi, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun replaceFragmentHasil(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frag_hasil, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}