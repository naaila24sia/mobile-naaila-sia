package com.example.naailaapps.Message

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.naailaapps.Message.tutorial.TutorialMessageActivity
import com.example.naailaapps.R
import com.example.naailaapps.databinding.FragmentMessageBinding
import com.example.naailaapps.databinding.FragmentMoreBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=200&h=200&fit=crop"),
        MessageModel("Budi", "Sudah makan?", "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=200&h=200&fit=crop"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?w=200&h=200&fit=crop"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?w=200&h=200&fit=crop"),
        MessageModel("Eka", "Nice job kemarin!", "https://images.unsplash.com/photo-1544005313-94ddf0286df2?w=200&h=200&fit=crop"),
        MessageModel("Fajar", "Lagi ngapain?", "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=200&h=200&fit=crop"),
        MessageModel("Gita", "Boleh minta tolong?", "https://images.unsplash.com/photo-1554151228-14d9def656e4?w=200&h=200&fit=crop"),
        MessageModel("Hana", "Lihat email ya", "https://images.unsplash.com/photo-1544717297-fa154da09f51?w=200&h=200&fit=crop"),
        MessageModel("Irfan", "Oke noted", "https://images.unsplash.com/photo-1522075469751-3a6694fb2f61?w=200&h=200&fit=crop"),
        MessageModel("Joko", "Sampai jumpa besok", "https://images.unsplash.com/photo-1599566150163-29194dcaad36?w=200&h=200&fit=crop")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }

        setHasOptionsMenu(true)

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}