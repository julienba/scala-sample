package me.sample

import javax.xml.bind.annotation.{XmlRootElement}
import scala.reflect.BeanInfo


/**
 * @BeanInfo is not enough for jersey serialization, all the java boilerplate is require :/
 */
@BeanInfo
@XmlRootElement(name= "test")
class MyJaxBean(n:String, a:Int){
  
  def this() = this(null, 0)
  
  private var name:String = n
  private var age:Int = a
  
  def getName():String = this.name
  
  def setName(name:String) = this.name = name
  
  def getAge():Int = this.age
  
  def setAge(age:Int) = this.age = age
}


/**
 * Suffisent for sjson
 */
@BeanInfo
case class User(firstName: String, lastName: String)

/*
case class Person(private var firstName: String, private var lastName: String){
  private def this() = this(null, null)
  
  def getFirstName():String = return this.firstName
  def getLastName():String = return this.lastName
  
  def setFirstName(firstName:String) = this.firstName = firstName
  def setLastName(lastName:String) = this.lastName = lastName
}*/
