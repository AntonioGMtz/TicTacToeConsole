fun main() {
    var cad = readLine()!!.toString()
    var cd = cad.split(" ").toTypedArray()
    var con = 0
    var letra = 0
    var imp = 0
    for(i in 0..cd.size-1){
        if(cd[con].lenght> letra) {
            letra = cd[con].lenght
            imp = con
        }
        con++
    }
    print(cd[imp])
}
