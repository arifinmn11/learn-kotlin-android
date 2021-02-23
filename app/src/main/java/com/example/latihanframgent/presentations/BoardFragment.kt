package com.example.latihanframgent.presentations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.latihanframgent.R
import com.example.latihanframgent.interfaces.onNavigationListener
import com.example.latihanframgent.utils.*
import kotlinx.android.synthetic.main.fragment_board.*


class BoardFragment : Fragment() {
    var activePlayer = ""
    var listBoard = board

    private var player1: String? = PLAYER1_PARAM
    private var player2: String? = PLAYER2_PARAM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showPlayerName(STATUS_TURN)
        btn1.setOnClickListener { handleClickBoard(it) }
        btn2.setOnClickListener { handleClickBoard(it) }
        btn3.setOnClickListener { handleClickBoard(it) }
        btn4.setOnClickListener { handleClickBoard(it) }
        btn5.setOnClickListener { handleClickBoard(it) }
        btn6.setOnClickListener { handleClickBoard(it) }
        btn7.setOnClickListener { handleClickBoard(it) }
        btn8.setOnClickListener { handleClickBoard(it) }
        btn9.setOnClickListener { handleClickBoard(it) }
    }

    private fun showPlayerName(status: String) {
        tvPlayer.text = "$activePlayer $status"
    }

    private fun handleClickBoard(view: View) {
        var cellId = 0
        val buttonSelected = view as Button
        when (view?.id) {
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }

        writeBoard(cellId, buttonSelected)
    }

    private fun writeBoard(cellId: Int, buttonSelected: Button) {
        val propertyBtnSelected = updateProperty(cellId, buttonSelected)
        val isWinner = checkWinner(cellId, BoardState.valueOf(propertyBtnSelected.symbol))
        if (!isWinner) {
            switchPlayer()
            showPlayerName(STATUS_TURN)
        } else {
            showPlayerName(STATUS_WINNER)
        }
    }

    private fun updateProperty(cellId: Int, buttonSelected: Button): PropertyButton {
        val propertyButton = propertyButton();
        buttonSelected.text = propertyButton?.symbol!!
        buttonSelected.setBackgroundColor(propertyButton?.color.toInt())
        buttonSelected.isEnabled = propertyButton?.status!!

        return propertyButton
    }

    private fun propertyButton(): PropertyButton? {
        return if (activePlayer == player1) {
            PropertyButton(
                symbol = BoardState.X.toString(),
                color = context?.getResources()?.getColor(R.color.player2).toString(),
                status = false
            )
        } else {
            PropertyButton(
                symbol = BoardState.O.toString(),
                color = context?.getResources()?.getColor(R.color.player1).toString(),
                status = false
            )
        }
    }

    private fun switchPlayer() {
        activePlayer = if (activePlayer == player1) {
            player2!!
        } else {
            player1!!
        }
    }

    private fun checkWinner(cellId: Int, symbol: BoardState): Boolean {
        when (cellId) {
            1 -> board[0][0] = symbol
            2 -> board[0][1] = symbol
            3 -> board[0][2] = symbol
            4 -> board[1][0] = symbol
            5 -> board[1][1] = symbol
            6 -> board[1][2] = symbol
            7 -> board[2][0] = symbol
            8 -> board[2][1] = symbol
            9 -> board[2][2] = symbol
        }
        return boardCheckerData(cellId, board)
    }

}