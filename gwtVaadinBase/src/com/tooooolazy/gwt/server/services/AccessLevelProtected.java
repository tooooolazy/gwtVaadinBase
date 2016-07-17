/**
 * 
 */
package com.tooooolazy.gwt.server.services;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * When a method is marked with this annotation that method must be declared to throw <code>AccessDeniedException</code>
 * @author tooooolazy
 *
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AccessLevelProtected {

}
