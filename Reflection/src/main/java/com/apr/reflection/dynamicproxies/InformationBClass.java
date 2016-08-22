package com.apr.reflection.dynamicproxies;

import com.apr.reflection.dynamicproxies.interfaces.InformationBInterface;

public class InformationBClass implements InformationBInterface {

	public String getMoreInfo(String part) {
		return "more information" + part;
	}

}
