package me.sample.resource

import com.sun.jersey.spi.resource.Singleton
import javax.ws.rs.core.Response
import javax.ws.rs._
import me.sample._
import com.wordnik.swagger.core._

import sjson.json._
import scala.reflect.Manifest



trait ResourceUtil {
  def serializeAsJSON(obj: AnyRef): String  = new String(Serializer.SJSON.out(obj))
  
  /*def deserializeJSON[T](json: Array[Byte])(implicit m: Manifest[T]): AnyRef =
    Serializer.SJSON.in[T](json)(m)*/
  
}

/*
trait ResourcesUtil {
  def serializeAsJSON(obj: AnyRef): String = new String(Serialize.SJSON.out(obj))

  def deserializeJSON[T](json: Array[Byte])(implicit m: Manifest[T]): AnyRef =
    Serializer.SJSON.in[T](json)(m)

}*/

@Singleton
@Path("/hello")
class HelloWorldResource extends ResourceUtil{

  @GET
  @Path("/say")
  def say = {
    "Hello world"
  }

  @GET
  def say2 = {
    "who has the lead ?"
  }

  @GET
  @Path("/list")
  def list = {
    //List("alice", "bob")
    "alice"
  }
  
  
  @GET
  @Produces(Array("application/json"))
  @Path("/js")
  def sayJson = {
    Response.ok.entity(new MyJaxBean("Agamemnon", 32)).build 
  }

  @GET
  @Produces(Array("application/json"))
  @Path("users")
  def users = {
    //Response.ok.entity(new User("Alain", "Azerty")).build
    serializeAsJSON(new User("Alain", "Azerty"))
  }
  
  
  /*
  @GET
  @Produces(Array("application/json"))
  @Path("/js2")
  def sayJerkson = {
	  Json.generate(Person("Alain", "Azerty"))
  }*/  
}

/* Jerkson method
@Path("/user/")
class UserResource{
  
	@GET
	@ApiOperation(value = "Show user property", responseClass= "String")
	@ApiErrors(Array(new ApiError(code = 400, reason = "Invalid user")))	
	@Produces(Array("application/json"))	
	def show = {
	  Json.generate(Person("Alain", "Azerty"))
	}
}*/
