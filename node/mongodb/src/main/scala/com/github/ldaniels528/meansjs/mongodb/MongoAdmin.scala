package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Mongo Administrative Functions
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoAdmin extends js.Object {

  def profilingInfo(callback: js.Function): Unit = js.native

  def profilingLevel(callback: js.Function): Unit = js.native

  def setProfilingLevel(level: String, callback: js.Function): Unit = js.native

  def validateCollection(collectionName: String, callback: js.Function): Unit = js.native

}

/**
  * Mongo Administrative Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoAdmin {

  /**
    * Mongo Administrative Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoAdminEnrich(val admin: MongoAdmin) extends AnyVal {

    @inline
    def profilingInfoAsync(name: String) = callbackWithErrorToFuture[ProfilingInfo](admin.profilingInfo)

    @inline
    def profilingLevelAsync(name: String) = callbackWithErrorToFuture[String](admin.profilingLevel)

    @inline
    def setProfilingLevelAsync(level: String) = callbackWithErrorToFuture[String](admin.setProfilingLevel(level, _))

    @inline
    def validateCollection(collectionName: String) = callbackWithErrorToFuture[ValidationResult](admin.validateCollection(collectionName, _))

  }

}