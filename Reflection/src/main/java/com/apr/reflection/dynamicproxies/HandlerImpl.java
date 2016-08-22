package com.apr.reflection.dynamicproxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.apr.reflection.dynamicproxies.interfaces.InformationBInterface;
import com.apr.reflection.dynamicproxies.interfaces.InformationInterface;

public class HandlerImpl implements InvocationHandler {

	@Override
	public Object invoke(Object obj, Method method, Object[] arguments) throws Throwable {
		System.out.println("using proxy: " + obj.getClass().getName());
		System.out.println("method: " + method.getName() + " from interface: " + method.getDeclaringClass().getName());

		// we can check dynamically the interface and load the implementation
		// that we want
		if (method.getDeclaringClass().getName().equals(InformationInterface.class.getCanonicalName())) {
			InformationClass informationImpl = InformationClass.class.newInstance();
			return method.invoke(informationImpl, arguments);
		} else if (method.getDeclaringClass().getName().equals(InformationBInterface.class.getCanonicalName())) {
			InformationBClass informationBImpl = InformationBClass.class.newInstance();
			return method.invoke(informationBImpl, arguments);
		}

		return null;
	}

}
