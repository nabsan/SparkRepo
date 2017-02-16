package main.scala.ex.basic

import java.io.File
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.scene.control._
import javafx.scene.image.ImageView
import javafx.embed.swing.SwingFXUtils
import javax.swing.filechooser.FileSystemView
import javax.swing.ImageIcon
import java.awt.image.BufferedImage


object RecursionDirTree3 {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[RecursionDirTree3App], args: _*)
  }
}

class RecursionDirTree3App extends Application{
  override def start(stage: Stage): Unit ={
    val dir = new File("/Users/manabu/Documents/workspace/SparkScalaTest/src/")
    val root=buildTree(dir)
    val treeView = new TreeView(root)
    val scene = new Scene(treeView, 400, 400)
    root.setExpanded(true)
    stage.setScene(scene)
    stage.show
  }

  def getIcon(f: File) ={
    val icon=FileSystemView.getFileSystemView().getSystemIcon(f)
    val img = new BufferedImage(16,16, BufferedImage.TYPE_INT_ARGB)
    val g = img.createGraphics()
    icon.paintIcon(null, g, 0,0)
    g.dispose()
    new ImageView(SwingFXUtils.toFXImage(img,null))

  }

  def buildTree(x: Any, folder: TreeItem[String]=null): TreeItem[String]={
    x match {
      case Nil => folder
      case a:File =>
        buildTree(a.listFiles().toList, if (folder != null) folder
        else new TreeItem[String](a.getName(),getIcon(a)))
      case (a:File)::aa => {
        if (a.isFile()) {
          folder.getChildren().add(
            new TreeItem[String](a.getName(), getIcon(a)))
        }else {
          val subfolder = new TreeItem[String](a.getName(),getIcon(a))
          folder.getChildren().add(subfolder)
          buildTree(a, subfolder)
        }
        buildTree(aa,folder)
      }
    }
  }




  //println("----")

}