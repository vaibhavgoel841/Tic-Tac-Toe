package com.example.tictactoe

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


 class MainActivity : AppCompatActivity(), View.OnClickListener {
var countTurns=0
    var activePlayer=true
lateinit  var board:Array<Array<Button>>
var gameEnd:Boolean=false
var boardStatus=Array(3){IntArray(3){-1}}


// -1->empty
     // 1 x
     // 2 o
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

board= arrayOf(
    arrayOf(button1,button2,button3), arrayOf(button4,button5,button6), arrayOf(button7,button8,button9)
)
resetBtn.setOnClickListener {
    gameEnd=false;
    textview.text="Player X Turn"
    countTurns=0
    for (i in 0..2) {
        for (j in 0..2)
            boardStatus[i][j] = -1
activePlayer=true;
        for(i in board ){
            for(but in i)
                but.text="";
        }
    }
}
for(i in board ){
    for(but in i)
        but.setOnClickListener(this)
}


    }
fun updateItem(r:Int, c:Int, activePlayer:Boolean){
    Log.d("arr1",boardStatus[1][0].toString());
    Log.d("arr2",boardStatus[1][1].toString());
    Log.d("arr3",boardStatus[1][2].toString());

 if(boardStatus[r][c]==-1&&!gameEnd){
        if(activePlayer) {
         boardStatus[r][c]=1
            board[r][c].text = "X"
            countTurns++
            textview.text="Player O Turn"
            Log.d("find",findWinner().toString())
        this.activePlayer =!(activePlayer)
        if(findWinner()==1) {
            textview.text = "Player X has Won"
        gameEnd=true
        }
            if(findWinner()==2){
            textview.text="Player O has Won"
                gameEnd=true
            }
        }
        else{
            board[r][c].text="O";
            this.activePlayer=!(activePlayer)
            countTurns++
            boardStatus[r][c]=2
            Log.d("find",findWinner().toString())
            textview.text="Player X Turn"
            if(findWinner()==1) {
                textview.text = "Player X has Won"
                gameEnd = true;
            }
            if(findWinner()==2) {
                textview.text = "Player O has Won"
                gameEnd = true;
            }
        }
    if(countTurns==9&&!gameEnd) {
        textview.text = "Game Drawn"
    gameEnd=true
    }
    }
}
     fun findWinner():Int{
         for(i in 0..2){
             var c=boardStatus[i][0];
             if(boardStatus[i][0]==boardStatus[i][1]&&boardStatus[i][1]==boardStatus[i][2]&&c!=-1)
                 return c;
         }
         for(i in 0..2){
             var c=boardStatus[0][i];
           if(boardStatus[0][i]==boardStatus[1][i]&&boardStatus[1][i]==boardStatus[2][i]&&c!=-1)
               return c;


         }
         if(boardStatus[0][0]==boardStatus[1][1]&&boardStatus[1][1]==boardStatus[2][2]&&boardStatus[2][2]!=-1)
             return boardStatus[0][0]
         if(boardStatus[0][2]==boardStatus[1][1]&&boardStatus[1][1]==boardStatus[2][0]&&boardStatus[2][0]!=-1)
             return boardStatus[0][2]
  return -1
     }
    override fun onClick(v: View?) {
         if (v != null) {
             when(v.id){
                 R.id.button1->{
updateItem(0,0,activePlayer);

                 }R.id.button2->{
                 updateItem(0,1,activePlayer);
             }R.id.button3->{
                 updateItem(0,2,activePlayer);
             }R.id.button4->{
                 updateItem(1,0,activePlayer);
             }R.id.button5->{
                 updateItem(1,1,activePlayer);
             }R.id.button6->{
                 updateItem(1,2,activePlayer);
             }R.id.button7->{
                 updateItem(2,0,activePlayer);
             }R.id.button8->{
                 updateItem(2,1,activePlayer);
             }R.id.button9->{
                 updateItem(2,2,activePlayer);
             }
             }
         }
     }
    }
