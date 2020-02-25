package org.d3if4091.praassesment


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi.*
import org.d3if4091.praassesment.databinding.FragmentSegitigaBinding

class SegitigaFragment : Fragment() {
    private lateinit var binding : FragmentSegitigaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_segitiga, container, false)
        if (savedInstanceState != null){
            binding.luasS.text = savedInstanceState.getString("luas")
            binding.kelilingS.text = savedInstanceState.getString("keliling")
        }

        binding.btnHitungPersegiS.setOnClickListener(View.OnClickListener { hituung() })
        binding.btnshareS.setOnClickListener(View.OnClickListener { share() })

        setHasOptionsMenu(true)

        return binding.root

    }

    fun hituung(){
        if(binding.numAlasS.text.toString()==""
            ||binding.numTinggiS.text.toString()==""){
            Toast.makeText(context,"Kolom tidak boleh kosong", Toast.LENGTH_SHORT)
        }else{
            val alas = binding.numAlasS.text.toString().toDouble()
            val tinggi = binding.numTinggiS.text.toString().toDouble()
            val luas : Double
            val keliling : Double

            luas = (alas*tinggi)/2
            keliling = 3*(alas)

            binding.luasS.text = getString(R.string.hasil_luas_bd,luas)
            binding.kelilingS.text = getString(R.string.hasil_keliling_bd,keliling)

        }
    }

    fun share(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,binding.luasS.text.toString())
        intent.putExtra(Intent.EXTRA_TEXT,binding.kelilingS.text.toString())
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("luas",binding.luasS.text.toString()+"\n"+binding.kelilingS.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share->{
                share()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.aboutFragment).isVisible = false
        super.onPrepareOptionsMenu(menu)
    }

}
