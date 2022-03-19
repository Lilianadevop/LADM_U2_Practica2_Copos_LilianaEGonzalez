package mx.edu.ittepic.ladm_u2_practica2_copos_lilianagonzalez

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Copo(l:Lienzo) {
    val l = l
    var x = 0f
    var y = 0f
    var tam = 0f
    var color = Color.WHITE

    init {
        x = rand(700) //por lo que mide mi pantalla
        y = rand(1000)
        tam = rand(15)+5
        //movY = rand(6)+2

    }

    private fun rand(hasta:Int): Float{
        return Random.nextInt(hasta).toFloat()
    }

    fun mover(){
        y += rand(5)+3
        if (y>1080)
            y= rand(1000)*-1
    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color = Color.WHITE
        canvas.drawCircle(x,y,tam,p)
    }

}