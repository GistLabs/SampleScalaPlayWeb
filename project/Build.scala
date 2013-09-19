import sbt._
import Keys._
import PlayProject._

import com.github.play2war.plugin._

object ApplicationBuild extends Build {
    val appName         = "SampleScalaPlayWeb"
    val appVersion      = "1.0-SNAPSHOT"

    scalaVersion := "2.10.2"

    val appDependencies = Seq(
      // Add your project dependencies here,
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here      
        Play2WarKeys.servletVersion := "3.0"
    ).settings(Play2WarPlugin.play2WarSettings: _*)

}
