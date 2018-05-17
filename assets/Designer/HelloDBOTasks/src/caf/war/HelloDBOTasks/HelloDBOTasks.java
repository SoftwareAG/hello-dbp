/**
 * 
 */
package caf.war.HelloDBOTasks;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

/**
 * @author jagt
 *
 */
@ManagedBean(name = "HelloDBOTasks")
@ApplicationScoped
@DTManagedBean(displayName = "HelloDBOTasks", beanType = BeanType.APPLICATION)
public class HelloDBOTasks extends com.webmethods.caf.faces.bean.BaseApplicationBean 
{
	public HelloDBOTasks()
	{
		super();
		setCategoryName( "CafApplication" );
		setSubCategoryName( "HelloDBOTasks" );
	}
}