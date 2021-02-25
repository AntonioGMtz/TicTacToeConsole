package tictactoe
var contParImpar = 1
fun main() {
    var tic = arrayOf(" "," "," "," "," "," "," "," "," ")
    game(tic)
}
fun game(tic: Array<String>){
    var contV =0
    var X =0
    var O =0
    println("---------")
    (tic.indices).forEach { i ->
        if (i % 3 == 0) print("| ")
        print(tic[i] + " ")
        if (i == 2 || i == 5 || i == 8) println("|")
        if(tic[i].toString() == " ") contV += 1
        if(tic[i].toString() == "X") X += 1
        if(tic[i].toString() == "O") O +=1
    }
    println("---------")
    contParImpar++
    if(X >= 3 || O >= 3 ) gameResult(tic, contV,X,O)
    else screen(tic, X, O, contV, contParImpar)
}
fun screen(tic: Array<String>, X: Int,O: Int, contV: Int, contParImpar:Int){
    var open = 0
    do{
        print("Enter the coordinates: ")
        var coor = readLine()!!.toString().toLowerCase().split(" ")
        for(i in coor){
            if(i.toInt() >= 4){
                println("Coordinates should be from 1 to 3!")
                open = 0
                break;
            }
            else if(i.toLowerCase() in "a".."z"){
                println("You should enter numbers!")
                open = 0
                break;
            }
            else open = 1
        }
        var co2 = coor.toTypedArray()
        if(open == 1){
            if(co2[0] == "1"&& tic[co2[1].toInt()-1] == " " && contParImpar%2== 0) tic[co2[1].toInt()-1] = "X"
            else if(co2[0] == "1"&& tic[co2[1].toInt()-1] == " " && contParImpar%2!= 0) tic[co2[1].toInt()-1] = "O"
            else if(co2[0] == "2" && tic[co2[1].toInt()+2] == " " && contParImpar%2 == 0) tic[co2[1].toInt()+2] = "X"
            else if(co2[0] == "2" && tic[co2[1].toInt()+2] == " " && contParImpar%2 != 0) tic[co2[1].toInt()+2] = "O"
            else if(co2[0] == "3" && tic[co2[1].toInt()+5] == " " && contParImpar%2==0) tic[co2[1].toInt()+5] = "X"
            else if(co2[0] == "3" && tic[co2[1].toInt()+5] == " " && contParImpar%2!=0) tic[co2[1].toInt()+5] = "O"
            else{
                println("This cell is occupied! Choose another one!")
                open = 0
            }
        }
    }while(open == 0)
   game(tic)
}
fun gameResult(tic: Array<String>, contV:Int, X:Int, O:Int){
    var contX =0
    var contO =0
    for(i in 0..2){
        if(tic[i]== tic[i+3] && tic[i]==tic[i+6]){
            if(tic[i]== "X") contX += 1
            if(tic[i]=="O") contO+=1
        }
    }
    for(i in 0..6 step 3){
        if(tic[i]== tic[i+1] && tic[i]==tic[i+2]){
            if(tic[i]== "X") contX += 1
            if(tic[i]=="O") contO+=1
        }
    }
    for(i in 0..2 step 2) {
        if (tic[i] == tic[4] && tic[i] == tic[8 - i]) {
            if (tic[i] == "X") contX += 1
            if (tic[i] == "O") contO += 1
        }
    }
    if(contX > 0) println("X wins")
    else if(contO > 0) println("O wins")
    else if(X >3 && O >3 && contV == 0) println("Draw")
    else screen(tic, X, O, contV, contParImpar)
}
