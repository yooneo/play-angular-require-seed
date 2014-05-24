import PlayKeys._
import com.typesafe.sbt.web.SbtWeb.autoImport.WebJs._

//
// Project Setup
//

// Enable Play-Scala via its sbt auto-settings
lazy val root = (project in file(".")).enablePlugins(PlayScala)

// TODO Replace with your project's/module's name
name := "play-angular-require-seed"

// TODO Set your organization here
organization := "your.organization"

version := "2.3.0-RC2"

// Scala Version, Play supports both 2.10 and 2.11
scalaVersion := "2.10.4"
//scalaVersion := "2.11.1"

// Dependencies
libraryDependencies ++= Seq(
  // WebJars (i.e. client-side) dependencies
  "org.webjars" % "requirejs" % "2.1.11-1",
  "org.webjars" % "underscorejs" % "1.6.0-3",
  "org.webjars" % "jquery" % "1.11.1",
  "org.webjars" % "bootstrap" % "3.1.1-1" exclude("org.webjars", "jquery"),
  "org.webjars" % "angularjs" % "1.2.16-2" exclude("org.webjars", "jquery")
)

//
// Scala Compiler Options
// If this project is only a subproject, add these a common project setting.
 //
scalacOptions ++= Seq(
  "-target:jvm-1.7",
  "-encoding", "UTF-8",
  "-deprecation", // warning and location for usages of deprecated APIs
  "-feature", // warning and location for usages of features that should be imported explicitly
  "-unchecked", // additional warnings where generated code depends on assumptions
  "-Xlint", // recommended additional warnings
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver
  "-Ywarn-value-discard" // Warn when non-Unit expression results are unused
)

//
// sbt-web configuration
// https://github.com/sbt/sbt-web
//

// Configure the steps of the asset pipeline (used in stage and dist tasks)
// rjs = RequireJS, uglifies, shrinks to one file, replaces WebJars with CDN
// digest = Adds hash to filename
// gzip = Zips all assets, Asset controller serves them automatically when client accepts them
pipelineStages := Seq(rjs, digest/*, gzip*/)

// RequireJS, https://github.com/sbt/sbt-rjs#sbt-rjs

//RjsKeys.mainModule := "main"

//RjsKeys.webJarModuleIds := Set("requirejs", "underscorejs", "jquery", "bootstrap", "angular", "angular-route", "angular-cookies", "jsRoutes")
// Cannot use a simple build.js
//val pathMap = Map("jsRoutes" -> j"empty:") ++ (RjsKeys.buildProfile.value.get("paths").getOrElse(Seq.empty[String]))
//val paths = pathMap.toJS
//RjsKeys.buildProfile := Map("paths" -> paths) // ++  RjsKeys.webJarModuleIds.value.map(m => m -> j"empty:").toMap.toJS

// The main config file
// See http://requirejs.org/docs/optimization.html#mainConfigFile
//requireJsShim := "build.js"

// sbt-digest (https://github.com/sbt/sbt-digest)
// md5 | sha1
//DigestKeys.algorithms := "md5"
//includeFilter in digest := "..."
//excludeFilter in digest := "..."

// sbt-gzip (https://github.com/sbt/sbt-gzip)
// includeFilter in GzipKeys.compress := "*.html" || "*.css" || "*.js"
// excludeFilter in GzipKeys.compress := "..."

// sbt-jshint (https://github.com/sbt/sbt-jshint)
// JshintKeys.config := ".jshintrc"
