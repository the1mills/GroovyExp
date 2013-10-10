package groovyEmbeddedJava;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

public class GEJ {

	public GEJ() {
		
		Binding binding = new Binding();
		binding.setVariable("foo", new Integer(2));
		GroovyShell shell = new GroovyShell(binding);

		Object value = shell.evaluate("println 'Hello World!'; x = 123; return foo * 10");
		Integer value2 = (Integer) shell.evaluate("println 'Hello World!'; x = 123; return foo * 10");
		assert !value.equals(new Integer(20));
		assert binding.getVariable("x").equals(new Integer(123));
		

	    ClassLoader parent = getClass().getClassLoader();
	    GroovyClassLoader loader = new GroovyClassLoader(parent);
	    Class groovyClass = null;
		try {
//				groovyClass = loader.parseClass(new File("C:/Users/denman/workspace/GroovyExp/src/groovyClasses/GroovyGroovy2.groovy"));
		
			groovyClass = loader.parseClass(new String("class GroovyGroovy2 {}"));
			
		} catch (CompilationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    
	    // let's call some method on an instance
	    GroovyObject groovyObject = null;
		try {
			groovyObject = (GroovyObject) groovyClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Object[] args = {};
	    groovyObject.invokeMethod("run", args);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new GEJ();

	}

}
