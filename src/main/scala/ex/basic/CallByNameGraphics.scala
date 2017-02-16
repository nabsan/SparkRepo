package main.scala.ex.basic
import my.Util
import javax.swing._
import java.awt._


//値渡しと名前渡し
object CallByNameGraphics  extends JFrame with App{
 
    val data = Array(500, 463, 300, 280, 80, 280, 200, 400, 480, 500)
    
    val color1 = new Color(150,180,230)
    val color2 = new Color(120,150,200)
    val color3 = new Color(20,120,50)
    
    val solid  = new BasicStroke(1.0f)
    val solid2 = new BasicStroke(2.0f)
    val dash   = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, Array(1.0f), 0.0f)
    
    setBounds(100, 100, 600, 600)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setVisible(true)
    
    println("add")
    add(new JPanel {
      override def paintComponent(g: Graphics){
        super.paintComponent(g)
        val g2 = g.asInstanceOf[Graphics2D]
        val w  = getWidth()
        val h  = getHeight()
        println("add inside")
        //my.Util.stopWatchMsecToLog("data/log.txt"){
        //my.Util.stopWatchMsec(){
            grid(g2, w, h , 10, color1 ,dash)
            grid(g2, w, h , 50, color2 ,solid)
            plot(g2, data,  50, color3 ,solid)
        //}
      }
    })
    println("add end")
    
    def grid(g: Graphics2D, w: Int, h: Int, d: Int, color: Color, stroke: BasicStroke){
      g.setColor(color)
      g.setStroke(stroke)
      for ( i <- 0 to h/d){
        val y = i * d
        //println(y)
        g.drawLine(0, y, w, y)
      }
      for (i <- 0 to w/d){
        val x = i * d
        g.drawLine(x, 0, x, h)
      }
    }
    
    def plot(g: Graphics2D, data: Array[Int], d: Int, color: Color, stroke: BasicStroke){
      g.setColor(color)
      g.setStroke(stroke)
      for(i <- 0 to data.length -1){
        val x1 =(i+1)*d
        val y1 = data(i)
        if (i <  data.length-1){
          val y2 =data(i+1)
          val x2 =(i+2)*d
          g.drawLine(x1,y1,x2,y2)
        }
        g.fillRect(x1-4, y1 -4, 9,9)
      }
    }
   //def main(args: Array[String]): Unit = {
   //    println("Hello Scala2")
   //}
}