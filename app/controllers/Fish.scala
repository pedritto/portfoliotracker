package controllers

import play.api.mvc._

object Fish extends Controller {

  def fish = Action {
	  Ok(views.html.fisheye());
  }
  
}