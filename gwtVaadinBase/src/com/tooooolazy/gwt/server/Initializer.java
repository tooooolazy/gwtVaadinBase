package com.tooooolazy.gwt.server;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.tooooolazy.gwt.shared.interfaces.UserController;
import com.tooooolazy.gwt.widgets.shared.SelectItem;
import com.tooooolazy.util.TLZUtils;

/**
 * Main initializer object used to initialize/create controllers.<br>
 * Can be extended to provide extra creation methods for components like controllers.<br>
 * Also provides a generic creation function so that extending this class is not a requirement.<br>
 * 
 * @author tooooolazy
 *
 */
public class Initializer {
	public static final String DTO_HELPER_CLASS = "dtoHelperClass";
	public static final String USER_CONTROLLER_CLASS = "userControllerClass";
	public static final String LANGUAGE_CONTROLLER_CLASS = "languageControllerClass";
	public static final String INITIALIZATION_CONTROLLER_CLASS = "initializationControllerClass";
	public static final String SECURITY_CONTROLLER_CLASS = "securityControllerClass";
	public static final String ADDRESS_CONTROLLER_CLASS = "addressControllerClass";
	public static final String ADDRESS_DATA_FILE_KEY = "addressDataFile";
	public static final String CR_DATE_FIELD = "crDate";
	public static final String ED_DATE_FIELD = "edDate";
	public static final String CR_USER_FIELD = "crUser";
	public static final String ED_USER_FIELD = "edUser";
	/**
	 * Make sure that base url is correct for test (gwt or tomcat)
	 */
	public static final String BASE_URL_KEY = "baseURL";
	public static final String EMAIL_VERIFICATION_REQUIRED_KEY = "emailVerificationRequired";
	public static final String EMAIL_VERIFICATION_URL_KEY = "emailVerificationURL";

	protected static Properties properties;
	protected static Initializer _INITIALIZER;
	protected Map<String, Object> controllers = new HashMap<String, Object>();
	protected String initializerClass;

	protected Initializer() {
		properties = TLZUtils.loadProperties( "config.properties" );
	}
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	public boolean getPropertyAsBoolean(String key) {
		try {
			return Boolean.parseBoolean(properties.getProperty(key));
		} catch (Exception e) {
			// looks like no such property is defined!!
			return false;
		}
	}
	public Properties getProperties() {
		return properties;
	}

	public static Initializer singleton() {
		if (_INITIALIZER == null) {
			_INITIALIZER = new Initializer();
			_INITIALIZER.initializerClass = Initializer.class.getName();
		}
		return _INITIALIZER;
	}

	public static Initializer singleton(String initializerClass) {
		try {
			if (_INITIALIZER == null)
				_INITIALIZER = (Initializer)TLZUtils.loadObject( initializerClass );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_INITIALIZER.initializerClass = initializerClass;

		return _INITIALIZER;
	}

	/**
	 * Generic method the creates (if needed) and returns the requested DataController. Casting is required on the return value.
	 * @param controllerClass
	 * @return
	 */
	public final Object getController(String controllerClass) {
		if (controllers.containsKey( controllerClass ))
			return controllers.get( controllerClass );
		else {
//			Object c = Initializer.initialize( initializerClass, getCreateMethod( controllerClass ), new Object[] { controllerClass } );
//			Object c = Initializer.initialize( initializerClass, "createController", new Object[] { controllerClass } );
			Object c = createController(controllerClass);
			controllers.put(controllerClass, c);
			return c;
		}
	}
	/**
	 * Helper function that constructs and returns the method name that creates the requested Controller.
	 * @param controllerClass
	 * @return
	 */
	private String getCreateMethod(String controllerClass) {
		String method = null;
		method = controllerClass.substring( controllerClass.lastIndexOf('.')+1 );
		method = controllerClass.substring( controllerClass.lastIndexOf('_')+1 );
		method = "create" + method;

		return method;
	}
	
	public static UserController createUserController(String userControllerClass) {
		UserController uc = null;
		try {
			uc = (UserController)TLZUtils.loadObject(userControllerClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uc;
	}
	public static Object createController(String controllerClass) {
		try {
			return TLZUtils.loadObject(controllerClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Object initialize(String initializerClass, String component, Object[] params) {
		Class c = null;
		try {
			c = Class.forName( initializerClass );
			return TLZUtils.invokeMethod(c, component, params);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<SelectItem> getSelectList(Object controller, String method, Object[] arguments) {
		try {
			return (List<SelectItem>)TLZUtils.invokeMethod(controller, method, arguments );
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
