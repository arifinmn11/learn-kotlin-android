package com.example.latihanframgent.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.databinding.FragmentFormBinding

class FormFragment : Fragment() {
    private var itemValue: Item? = null
    private lateinit var binding: FragmentFormBinding
    private lateinit var viewModel: FormViewModel
    private lateinit var loadingDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            itemValue = it.getParcelable<Item>("edit_item")
//        }
//        initModel()
//        subscribe()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        loadingDialog = LoadingDialog.build(requireContext())
        binding = FragmentFormBinding.inflate(layoutInflater)
        binding.apply {

//            itemValue?.apply {
//                submitBtn.text = "UPDATE"
//                titleItem.text = "EDIT ITEM"
//
//                dateTiet.setText(date)
//                nameTiet.setText(name)
//                quantityTiet.setText(quantity.toString())
//                noteTiet.setText(note)
//            }
//
//            dateTiet.inputType = InputType.TYPE_NULL
//            val calendar = Calendar.getInstance()
//            val year = calendar.get(Calendar.YEAR)
//            val month = calendar.get(Calendar.MONTH)
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//            dateTiet.setOnClickListener(View.OnClickListener {
//                val datePickerDialog = activity?.let { it1 ->
//                    DatePickerDialog(
//                        it1, DatePickerDialog.OnDateSetListener
//                        { view, year, monthOfYear, dayOfMonth ->
//                            val date = "$dayOfMonth/$monthOfYear/$year"
//                            dateTiet.setText(date)
//                        }, year, month, day
//                    )
//                }
//                datePickerDialog?.show()
//            })
//
//            submitBtn.setOnClickListener {
//                val quantity: Int = if (quantityEt.editText?.text.toString().isNullOrEmpty()) {
//                    0
//                } else {
//                    quantityEt.editText?.text.toString().toInt()
//                }
//
//                if (itemValue == null) {
//                    //add
//                    itemValue = Item(
//                        note = noteEt.editText?.text.toString(),
//                        name = nameEt.editText?.text.toString(),
//                        date = dateEt.editText?.text.toString(),
//                        quantity = quantity,
//                        id = 0
//                    )
//                } else {
//                    //update
//                    itemValue?.id?.let { it ->
//                        itemValue = Item(
//                            note = noteEt.editText?.text.toString(),
//                            name = nameEt.editText?.text.toString(),
//                            date = dateEt.editText?.text.toString(),
//                            quantity = quantity,
//                            id = it
//                        )
//                    }
//                }
//                viewModel.validation(itemValue!!)
//            }
//            cancelBtn.setOnClickListener {
//                Navigation.findNavController(requireView()).popBackStack()
//            }
        }
        return binding.root
    }

//    private fun initModel() {
//        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                val itemDao = ItemDatabase.getDatabase(requireContext()).itemDao()
//                val userRepository = ItemRepository(itemDao)
//                return FormViewModel(userRepository) as T
//            }
//        }).get(FormViewModel::class.java)
//    }
//
//    private fun subscribe() {
//        viewModel.itemLiveData.observe(this) {
//            findNavController().navigate(R.id.action_formFragment_to_listFragment)
//        }
//
//        viewModel.isValid.observe(this) {
//            when (it.status) {
//                ResourceStatus.LOADING -> {
//                    loadingDialog.show()
//                }
//                ResourceStatus.SUCCESS -> {
//                    viewModel.save(itemValue!!)
//                    loadingDialog.hide()
//                }
//                ResourceStatus.FAIL -> {
//                    loadingDialog.hide()
//                    Toast.makeText(
//                        requireContext(),
//                        it.message,
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//
//            }
//        }
//    }


    companion object {

        @JvmStatic
        fun newInstance() = FormFragment()
    }
}