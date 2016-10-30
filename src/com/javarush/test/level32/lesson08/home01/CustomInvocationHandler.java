package com.javarush.test.level32.lesson08.home01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
	private SomeInterfaceWithMethods siwm;

	public CustomInvocationHandler(SomeInterfaceWithMethods siwm) {
		this.siwm = siwm;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName() + " in");
		method.invoke(siwm, args);
		System.out.println(method.getName() + " out");
		return null;
	}
}
