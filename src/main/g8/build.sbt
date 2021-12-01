ThisBuild / version       := "$version$"
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / organization  := "io.github.scottweaver"
ThisBuild / description   := "$project_description$"
ThisBuild / homepage      := Some(url("$homepage$"))
ThisBuild / licenses      := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / scmInfo       := Some(
  ScmInfo(
    url("$scm-homepage$"),
    "$scm-clone-url$"
  )
)

ThisBuild / developers    := List(
  Developer(
    id = "scottweaver",
    name = "Scott T Weaver",
    email = "scott.t.weaver@gmail.com",
    url = url("https://scottweaver.github.io/")
  )
)

val scala213Version            = "2.13.7"
val scala212Version            = "2.12.15"
val supportedScalaVersions     = List(scala213Version, scala212Version)

lazy val stdScalacOptions = Seq(
  "-encoding",
  "UTF-8",
  "-explaintypes",
  "-Yrangepos",
  "-feature",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps",
  "-Xlint:_,-type-parameter-shadow",
  "-Xsource:2.13",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-unchecked",
  "-deprecation",
  "-Xfatal-warnings"
)

lazy val scala213Options  = Seq(
  "-Xlint:_,-type-parameter-shadow,-byname-implicit",
  "-Xsource:2.13",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  // "-Wunused:imports", <-- Generally more irritating than useful during the development cycle.  Best enforced during CI or as a commit hook.
  "-Wvalue-discard",
  "-Wunused:patvars",
  "-Wunused:privates",
  "-Wunused:params"
)

ThisBuild / scalacOptions := stdScalacOptions ++ scala213Options

lazy val commonSettings = Seq[Setting[_]](
  scalaVersion := scala213Version
)

lazy val `core-module-name` =
  project
    .in(file("modules/core-module-name"))
    .settings(
      name := "core-module-name"
    )
    .settings(commonSettings)
