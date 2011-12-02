name := "sbtWithJetty"

version := "1.0"

scalaVersion := "2.9.1"

seq(webSettings :_*)

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided->default"
                                                                                                                                                                                                    
//port in container.Configuration := 8002

// Jetty & friends
libraryDependencies ++= {
	val jettyVersion = "7.1.6.v20100715"
	Seq(
	    "org.eclipse.jetty" % "jetty-plus" % jettyVersion % "container",
	    "org.eclipse.jetty" % "jetty-util" % jettyVersion % "container",
	    "org.eclipse.jetty" % "jetty-start" % jettyVersion % "container",
	    "org.eclipse.jetty" % "jetty-webapp" % jettyVersion % "container",
	    "org.eclipse.jetty" % "jetty-deploy" % jettyVersion % "container",
	    "commons-lang" % "commons-lang" % "2.4" % "container"
	)
}

libraryDependencies += "javax.ws.rs" % "jsr311-api" % "1.1.1"

// Jersey
libraryDependencies ++= {
	val jerseyVersion = "1.7"
	Seq(
    	"com.sun.jersey" % "jersey-server" % jerseyVersion,
    	"com.sun.jersey" % "jersey-json" % jerseyVersion,
    	"com.sun.jersey" % "jersey-client" % jerseyVersion,
    	"com.sun.jersey" % "jersey-server" % jerseyVersion,
    	"com.sun.jersey" % "jersey-core" % jerseyVersion
	)
}

// sjson - https://github.com/debasishg/sjson
resolvers += "Scala Tools Releases" at "https://repository.jboss.org/nexus/content/repositories/scala-tools-releases"

libraryDependencies += "net.debasishg" % "sjson_2.9.1" % "0.15"                                                                          


// // Jerkson
// resolvers += "Jerkson Repository" at "http://repo.codahale.com"
// 
// libraryDependencies += "com.codahale" % "jerkson_2.9.1" % "0.5.0"

// Log  
libraryDependencies ++= Seq(
    "org.slf4j" % "slf4j-simple" % "1.5.8" % "container",
    "org.slf4j" % "slf4j-api" % "1.5.8" % "container"
)

// Swagger
libraryDependencies += "com.wordnik" % "swagger-core" % "1.1-SNAPSHOT.121026"        

