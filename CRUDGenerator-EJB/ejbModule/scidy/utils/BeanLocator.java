package scidy.utils;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class BeanLocator {
	public static <T> T lookup(Class<T> clazz, String jndiName) {
		Object bean = lookup(jndiName);
		return clazz.cast(PortableRemoteObject.narrow(bean, clazz));
	}
	
	/* MODIFIE */
	public static <T> T defaultLookup(Class<T> clazz) {
		Object bean = lookup("CRUDGenerator/"+clazz.getSimpleName()+"Bean/remote");
		return clazz.cast(PortableRemoteObject.narrow(bean, clazz));
	}

	public static Object lookup(String jndiName) {
		Context context = null;
		try {
			context = new InitialContext();
			return context.lookup(jndiName);
		} catch (NamingException ex) {
			throw new IllegalStateException("...");
		} finally {
			try {
				context.close();
			} catch (NamingException ex) {
				throw new IllegalStateException("...");
			}
		}
	}
}