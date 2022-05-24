package com.teammate.find.Tech;

import java.util.List;

public class Techs {
	private List<Tech> techs;
	
	public Techs() {
		
	}
	
	public Techs(List<Tech> techs) {
		super();
		this.techs = techs;
	}
	
	
	public List<Tech> getTechs() {
		return techs;
	}
	public void setTechs(List<Tech> techs) {
		this.techs = techs;
	}
}
