package org.d3if4091.praassesment


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.d3if4091.praassesment.databinding.FragmentPersegiBinding

class PersegiPFragment : Fragment() {
    private lateinit var binding : FragmentPersegiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_persegi, container, false)

        if (savedInstanceState != null){
        binding.luasP.text = savedInstanceState.getString("luas")
        binding.KelilingP.text = savedInstanceState.getString("keliling")
        }

        binding.btnHitungPersegiP.setOnClickListener(View.OnClickListener { hituung() })
        binding.btnshareP.setOnClickListener(View.OnClickListener { share() })

        setHasOptionsMenu(true)

        return binding.root
    }

    fun hituung(){
        if(binding.numLebarP.text.toString()==""
            ||binding.numPanjangP.text.toString()==""){
            Toast.makeText(context,"Kolom tidak boleh kosong",Toast.LENGTH_SHORT).show()
        }else{
            val panjang = binding.numPanjangP.text.toString().toDouble()
            val lebar = binding.numLebarP.text.toString().toDouble()
            val luas : Double
            val keliling : Double

            luas = panjang*lebar
            keliling = 2*(panjang+lebar)

            binding.luasP.text = getString(R.string.hasil_luas_bd,luas)
            binding.KelilingP.text = getString(R.string.hasil_keliling_bd,keliling)

        }
    }


    fun share(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,binding.luasP.text.toString() + "\n" + binding.KelilingP.text.toString())
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("luas",binding.luasP.text.toString())
        outState.putString("keliling",binding.KelilingP.text.toString())
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
