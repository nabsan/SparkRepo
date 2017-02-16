package main.scala.ex.basic

import java.io.File
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.scene.layout.StackPane
import javafx.scene.canvas._
import javafx.scene.shape._
import javafx.scene.text._
import javafx.scene.effect._
import javafx.scene.control._
import javafx.geometry._
import javafx.scene.paint.Color




import scala.collection.mutable.Map
import scala.collection.mutable.Set

object RecursionNetwork {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[RecursionNetworkApp], args: _*)
  }
}

class RecursionNetworkApp extends Application {

  val webLinkInfo =
    """
      トップ -> 製品 サービス　問い合わせE
      製品   -> トップ　PC サーバ ソフトウェアE
      サービス -> トップ　ネットワーク　システム開発E
      問い合わせ -> トップE
      PC        ->  トップ　製品　サーバソフトウェアE
      サーバ -> トップ　製品　PC ソフトウェアE
      ソフトウェア -> トップ　製品　PC サーバE
      ネットワーク -> トップ　サービス　システム開発E
      システム開発 -> トップ　サービス　ネットワークE
    """.split("E").map(_.trim).filter(_!="")
      .map(_.split("[ ]+").toList).toList

  override def start(stage: Stage): Unit = {
    println(webLinkInfo)
    val pane = new StackPane()
    val canvas = new Canvas(600, 400)
    pane.getChildren().add(canvas)
    stage.setScene(new Scene(pane))
    stage.show()

    val all = build(webLinkInfo)
    calc(all, canvas)
    draw(all, canvas)


    //println("----")

  }


  def build(x: List[List[String]]) = {
    val m = Map[String, Webpage]()
    x.foreach(buildLink(_, m))
    val all = m.map { case (k, v) => v }.toList.sortBy(_.no)
    all.foreach(p => p.linkCnt = countLink(p))
    all
  }

  def calc(all: List[Webpage], c: Canvas): Unit = {
    println("allsize="+all.size)
    val maxLevel = all.map(_.level).max
    //val maxLevel=2
    val dh = (c.getHeight / (maxLevel + 1)).toInt
    for (i <- 1 to maxLevel) {
      val grp = all.filter(_.level == i).toArray
      val n = grp.length
      val dw = (c.getWidth / (n + 1)).toInt
      for (j <- 1 to n) {
        val p = grp(j - 1)
        p.w = 90
        p.h = 25
        p.x = j * dw + (dw / 10) * (i % 2)
        p.y = i * dh + (dh / 5) * (j % 3 - 1)
      }
    }
  }

  def draw(all: List[Webpage], c: Canvas): Unit = {
    val g = c.getGraphicsContext2D
    g.setLineWidth(0.7)
    all.foreach(_.drawLink(g, c.getWidth))
    all.foreach(_.draw(g))
  }

  def addNewPage(s: String, m: Map[String, Webpage], level: Int) = {
    if (m.contains(s)) {
      m(s)
    } else {
      val p = new Webpage(s)
      m(s) = p
      p.no = m.size
      p.level = level
      println("plevel="+p.level)
      p
    }
  }

  def buildLink(x: List[String], m: Map[String, Webpage]): Unit = {
    x match {
      case page::"->"::links => {
        val p = addNewPage(page, m, 1)
        links.foreach(link =>
          p.makeLink(addNewPage(link, m, p.level + 1)))
      }
      case _ =>
    }
  }

  def countLink(p: Webpage, temp: Set[Webpage] = Set()): Int = {
    if (temp.contains(p)) {
      0
    } else {
      temp += p
      for (x <- p.linkTo if x.level >= p.level) {
        countLink(x, temp)
      }
      temp.size - 1
    }
  }
}


class Webpage (s: String){
  val name =s
  var no = 0
  var level =0
  var linkCnt = 0
  var linkTo: List[Webpage] = Nil
  var x,y,w,h = 0


  def makeLink(to: Webpage): Unit ={
    linkTo = to::linkTo
  }

  def draw(g: GraphicsContext): Unit ={
    val x1 = x- w/2
    val y1 = y-h/2
    g.setFill(Color.rgb(230,230,230))
    g.fillRoundRect(x1,y1,w,h,15,15)
    g.strokeRoundRect(x1,y1,w,h,15,15)
    g.setTextAlign(TextAlignment.CENTER)
    g.setTextBaseline(VPos.CENTER)
    g.setFill(Color.rgb(0,0,0))
    g.fillText(name + " " + linkCnt, x,y)
  }

  def drawLink(g: GraphicsContext, s: Double): Unit ={
    linkTo.foreach{ to =>
      val dx = to.x - x
      val dy = to.y - y
      val r = math.min(0.5, math.sqrt(dx*dx + dy*dy)/s)
      val q = (0.5 -r) * 0.2
      val rx = dx*r
      val ry = dy*r
      val qx = dx*q
      val qy = dy*q
      g.beginPath()
      g.moveTo(x,y)
      g.bezierCurveTo(x+rx+qy, y+ry-qx, to.x-rx+qy, to.y-ry-qx, to.x,to.y)
      g.stroke()
    }
  }


}






