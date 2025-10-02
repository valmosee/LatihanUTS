package latihan.c14230225.latihanuts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FSatu.newInstance] factory method to
 * create an instance of this fragment.
 */
class FSatu : Fragment() {
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

        val _btnKali = view.findViewById<Button>(R.id.btnMultiply)
        val _btnBagi = view.findViewById<Button>(R.id.btnDivide)

        var angka1: Int = 0
        var angka2: Int = 0

        arguments?.let {
            angka1 = it.getInt("angka1")
            angka2 = it.getInt("angka2")
        }

        _btnKali.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            val operator = "*"
            val hasil = angka1 * angka2

            val fragmentDua = FDua()
            val bundleAngka = Bundle().apply {
                putInt("angka1", angka1)
                putInt("angka2", angka2)
                putString("operator", operator)
            }
            fragmentDua.arguments = bundleAngka

            val fragmentHasil = FHasil()
            val bundleHasil = Bundle().apply {
                putString("hasil", hasil.toString())
            }
            fragmentHasil.arguments = bundleHasil

            fragmentTransaction.replace(
                R.id.frag_operasi, fragmentDua
            )
            fragmentTransaction.replace(
                R.id.frag_hasil, fragmentHasil
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        _btnBagi.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            val operator = "/"
            val hasil = if (angka2 != 0) angka1 / angka2 else 0

            val fragmentDua = FDua()
            val bundleAngka = Bundle().apply {
                putInt("angka1", angka1)
                putInt("angka2", angka2)
                putString("operator", operator)
            }
            fragmentDua.arguments = bundleAngka

            val fragmentHasil = FHasil()
            val bundleHasil = Bundle().apply {
                putString("hasil", hasil.toString())
            }
            fragmentHasil.arguments = bundleHasil

            fragmentTransaction.replace(
                R.id.frag_operasi, fragmentDua
            )
            fragmentTransaction.replace(
                R.id.frag_hasil, fragmentHasil
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_satu, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FSatu.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FSatu().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}