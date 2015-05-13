package com.servlet;

import java.io.Serializable;

public class StudentBean implements Serializable {
	  private static final long serialVersionUID = 1L;
	  private String id = "id missing";
	  private String name = "name missing";
	  private String lesson = "lesson missing";
	 
	  public String getId () {
	    return(id);	  
	  }
	  
	  public void setID (String id) {
		  if (!isMissing(id)) {
			  this.id = id;
		  }
	  }
	  
	  public String getName () {
	    return(name);	  
	  }
			  
	  public void setName (String name) {
	    if (!isMissing(name)) {
	    	 this.name = name;
	    }
	  }
			  
	  public String getLesson () {
	    return(lesson);	  
	  }
				  
	  public void setLesson (String lesson) {
	    if (!isMissing(lesson)) {
	    	 this.lesson = lesson;
	    }
	  }
					  
	  private boolean isMissing(String value) {
		 return ((value == null) || (value.trim().equals("")));
	  }
}
