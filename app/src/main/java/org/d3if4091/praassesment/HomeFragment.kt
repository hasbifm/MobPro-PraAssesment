package org.d3if4091.praassesment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if4091.praassesment.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        binding.btnPersegi.setOnClickListener(View.OnClickListener { v : View -> v.findNavController().navigate(R.id.action_homeFragment_to_persegiPFragment)})
        binding.btnSegitiga.setOnClickListener(View.OnClickListener { v : View -> v.findNavController().navigate(R.id.action_homeFragment_to_segitigaFragment)})

        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.share).isVisible = false
        super.onPrepareOptionsMenu(menu)
    }

}
