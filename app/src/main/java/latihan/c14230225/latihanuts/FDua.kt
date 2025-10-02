package latihan.c14230225.latihanuts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FDua.newInstance] factory method to
 * create an instance of this fragment.
 */
class FDua : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtOpMtk = view.findViewById<TextView>(R.id.txtOpMtk)
        val btnBack = view.findViewById<Button>(R.id.btnBack)

        var angka1: Int = 0
        var angka2: Int = 0
        var operator: String = ""

        arguments?.let {
            angka1 = it.getInt("angka1")
            angka2 = it.getInt("angka2")
            operator = it.getString("operator").toString()
        }

        val hasil = when (operator) {
            "*" -> angka1 * angka2
            "/" -> if (angka2 != 0) angka1 / angka2 else 0
            else -> 0
        }
        txtOpMtk.text = "$angka1 $operator $angka2"

        btnBack.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            val fragmentSatu = FSatu()
            val bundleAngka = Bundle().apply {
                putInt("angka1", angka1)
                putInt("angka2", angka2)
            }
            fragmentSatu.arguments = bundleAngka

            val fragmentHasil = FHasil()
            val bundleHasil = Bundle().apply {
                putString("hasil", hasil.toString())
            }
            fragmentHasil.arguments = bundleHasil

            fragmentTransaction.replace(R.id.frag_operasi, fragmentSatu)
            fragmentTransaction.replace(R.id.frag_hasil, fragmentHasil)
            fragmentTransaction.commit()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_dua, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FDua.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FDua().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}