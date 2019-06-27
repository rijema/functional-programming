import org.w3c.dom.*
import kotlin.browser.*
import kotlin.math.*


val canvas = initializeCanvas()
fun initializeCanvas(): HTMLCanvasElement {
    val canvas = document.createElement("canvas") as HTMLCanvasElement
    val ctx = canvas.getContext("2d") as CanvasRenderingContext2D
    ctx.canvas.width = 480
    ctx.canvas.height = 320
    document.body!!.appendChild(canvas)
    var x = canvas.width/2
    var y = canvas.height-30
    val dx = 2
    val dy = -2
    fun drawBall(){
        ctx.beginPath()
        ctx.arc(x*1.0, y*1.0, 10.0, 0.0, PI*2)
        ctx.fillStyle = "#000000"
        ctx.fill()
        ctx.closePath()
    }
    fun draw(){
        ctx.clearRect(0.0, 0.0, canvas.width*1.0, canvas.height*1.0)
        drawBall()
        x += dx
        y += dy
    }
    window.setInterval(draw(),10)
    return canvas
}


