package mx.edu.ittepic.ladm_u2_practica2_copos_lilianagonzalez

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

class Lienzo(este: MainActivity) : View(este) {
    val este = este
    val copos = Array<Copo>(400,{Copo(this)})
    val s = CoroutineScope(Job() + Dispatchers.Main)
    var cont = 0
    var nevar = 100
    var ventisca = 250

    val coroutina = s.launch(EmptyCoroutineContext, CoroutineStart.LAZY) {
        while (true) {
            (0..copos.size-1).forEach {
                copos[it].mover()
            }
            cont++
            este.runOnUiThread {
                invalidate()
            }
            delay(20L)
        }
    }


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()
        
        for (copito in copos) {
            copito.pintar(c)
            copito.mover()
        }


        // ------------------------ PAISAJE -------------------
        // Fondo
        p.color= Color.rgb(0,188,212)
        c.drawRect(0f,0f,720f,1033f,p)
        //sol
        p.color = Color.YELLOW
        c.drawCircle(620f,140f,60f,p)
        //nubesol
        p.color = Color.WHITE
        c.drawCircle(670f,170f,30f,p)
        c.drawCircle(630f,170f,30f,p)
        c.drawCircle(590f,170f,30f,p)
        //otra nube
        c.drawCircle(270f,300f,30f,p)
        c.drawCircle(230f,290f,40f,p)
        c.drawCircle(190f,300f,30f,p)

        //pasto
        p.color = Color.rgb(3,190,43)
        c.drawCircle(0f,900f,300f,p)
        c.drawCircle(350f,900f,300f,p)
        c.drawCircle(700f,900f,300f,p)

        //casa630f
        p.color = Color.rgb(255,193,7)
        c.drawRect(240f,740f,400f,840f,p)

        p.color = Color.rgb(244,67,55)
        c.drawRect(330f,765f,365f,840f,p)//puerta
        c.drawRect(270f,765f,305f,805f,p)//ventana
        c.drawRect(220f,680f,420f,740f,p)//techo
        c.drawRect(340f,630f,380f,740f,p)//chimenea
        p.color = Color.LTGRAY
        c.drawCircle(360f,625f,5f,p)
        c.drawCircle(370f,610f,10f,p)
        c.drawCircle(390f,590f,20f,p)


        //arbol
        p.color= Color.rgb(209,65,19)
        c.drawRect(105f,550f,120f,630f,p)
        p.color= Color.GREEN
        c.drawCircle(110f,530f,30f,p)
        c.drawCircle(110f,485f,20f,p)
        p.color = Color.WHITE
        c.drawCircle(111f,532f,2f,p)
        c.drawCircle(112f,489f,4f,p)
        c.drawCircle(109f,480f,3f,p)
        c.drawCircle(114f,532f,2f,p)
        c.drawCircle(105f,520f,4f,p)
        c.drawCircle(110f,490f,3f,p)

        //Árbol2
        p.color= Color.rgb(209,65,19)
        c.drawRect(605f,600f,620f,680f,p)
        p.color= Color.GREEN
        c.drawCircle(610f,580f,30f,p)
        c.drawCircle(610f,535f,20f,p)

        // Árbol 3
        p.color= Color.rgb(209,65,19)
        c.drawRect(550f,800f,565f,880f,p)
        p.color= Color.GREEN
        c.drawCircle(555f,780f,30f,p)
        c.drawCircle(555f,735f,20f,p)

        // Árbol 4
        p.color= Color.rgb(209,65,19)
        c.drawRect(200f,800f,215f,880f,p)
        p.color= Color.GREEN
        c.drawCircle(205f,790f,30f,p)
        c.drawCircle(205f,745f,20f,p)

        coroutina.start()
        nevada(c)
    }

    // funciona para que haga nevada fuerte y nevada baja
    fun nevada(c:Canvas) {
        if (cont >= 0 && cont < 250) {
            (0..nevar).forEach {
                copos[it].mover()
                copos[it].pintar(c)
            }
        }
        if (cont > 250 && cont < 500) {
            (0..ventisca).forEach {
                copos[it].mover()
                copos[it].pintar(c)
            }
        }
        if (cont == 500){
            cont = 1
        }
    }
}