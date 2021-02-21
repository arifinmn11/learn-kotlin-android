package com.example.latihanframgent.presentations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.latihanframgent.R
import com.example.latihanframgent.utils.Item
import com.example.latihanframgent.utils.ItemList
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), OnNavigationListener {
    private lateinit var addItemFragment: AddItemFragment;
    private lateinit var listItemFragment: ListItemFragment;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()

        val addItemFragment = AddItemFragment.newInstance(this)
        val listItemFragment = ListItemFragment.newInstance(this)

        switchFragment(addItemFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_add -> switchFragment(addItemFragment)
                R.id.nav_list -> switchFragment(listItemFragment)
            }
            false
        }
    }

    companion object {
        const val ADD_ITEM_FRAGMENT_TAG = "ADD_ITEM_FRAGMENT"
        const val LIST_ITEM_FRAGMENT_TAG = "LIST_ITEM_FRAGMENT"
    }


    private fun switchFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }

    override fun menuItem() {
        addItemFragment = AddItemFragment.newInstance(this)
        switchFragment(addItemFragment)
    }

    override fun showItems() {
        listItemFragment = ListItemFragment.newInstance(this)
        switchFragment(listItemFragment)
    }

    override fun addItem(item: Item) {
        ItemList.add(item)
    }
}
