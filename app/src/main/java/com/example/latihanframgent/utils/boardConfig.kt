package com.example.latihanframgent.utils

var board = arrayOf(
    arrayOf(BoardState.BLANK, BoardState.BLANK, BoardState.BLANK),
    arrayOf(BoardState.BLANK, BoardState.BLANK, BoardState.BLANK),
    arrayOf(BoardState.BLANK, BoardState.BLANK, BoardState.BLANK)
)


class PropertyButton(val symbol: String, val color: String, val status: Boolean)

fun boardCheckerData(cellId: Int, data: Array<Array<BoardState>>): Boolean {
    println()
    for (i in data) {
        for (j in i) {
            print("${j.toString()}, ")
        }
        println()
    }
    if ((cellId == 1 || cellId == 2 || cellId == 3) && (data[0][0] == data[0][1] && data[0][1] == data[0][2])) {
        println("1")
        return true
    } else if ((cellId == 1 || cellId == 5 || cellId == 9) && data[0][0] == data[1][1] && data[1][1] == data[2][2]) {
        println("2")
        return true
    } else if ((cellId == 1 || cellId == 4 || cellId == 7) && data[0][0] == data[1][0] && data[1][0] == data[2][0]) {
        println("3")
        return true
    } else if ((cellId == 3 || cellId == 5 || cellId == 7) && data[0][2] == data[1][1] && data[1][1] == data[2][0]) {
        return true
    } else if ((cellId == 3 || cellId == 6 || cellId == 9) && data[0][2] == data[1][2] && data[1][2] == data[2][2]) {
        return true
    } else if ((cellId == 2 || cellId == 5 || cellId == 8) && data[0][1] == data[1][1] && data[1][1] == data[2][1]) {
        return true
    } else if ((cellId == 4 || cellId == 5 || cellId == 6) && data[1][0] == data[1][1] && data[1][1] == data[1][2]) {
        return true
    } else if ((cellId == 7 || cellId == 8 || cellId == 9) && data[2][0] == data[2][1] && data[2][1] == data[2][2]) {
        return true
    }
    return false
}

const val STATUS_WINNER = " is a winner"
const val STATUS_TURN = "'s turn"

var PLAYER1_PARAM = "player1"
var PLAYER2_PARAM = "player2"

