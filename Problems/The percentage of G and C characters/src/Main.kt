fun main() {
    var n = readLine()!!.toString()
    var div = n.length
    var con =0.0
    for(i in n){
        if(i.toString().toLowerCase() == "c" || i.toString().toLowerCase() == "g") con++
    }
    var f = (con / div) * 100 
    print(f)
}
