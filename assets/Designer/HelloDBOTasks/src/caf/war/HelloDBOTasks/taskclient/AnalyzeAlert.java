package caf.war.HelloDBOTasks.taskclient;


import com.webmethods.caf.faces.data.task.ITaskData;
import com.webmethods.caf.faces.data.ContentProviderException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

/**
 * Task Client bean for 'Analyze Alert' task.
 */
@ManagedBean(name = "AnalyzeAlert")
@SessionScoped
@ExpireWithPageFlow
@DTManagedBean(beanType = BeanType.DEFAULT)
public class AnalyzeAlert extends com.webmethods.caf.faces.data.task.impl.TaskContentProviderExtended {

	private static final long serialVersionUID = 469419913707736064L;
	
	/**
	 * Globally unique task type id
	 */
	private static final String TASK_TYPE_ID = "8F1E0ACC-B24C-DEA0-84AF-6DE85CD1C620";

	/**
	 * Default constructor
	 */
	public AnalyzeAlert() {
		super();
		setTaskTypeID(TASK_TYPE_ID);
	}
	
	/**
	 * Task Data Object
	 */
	public static class TaskData extends com.webmethods.caf.faces.data.task.impl.TaskData {

		private static final long serialVersionUID = 5088479112326336512L;
		
		public static String[][] FIELD_NAMES = new String[][] {{"thingAlert", "ThingAlert"},
		};

		private caf.war.HelloDBOTasks.taskclient.is.document.HelloDBP_HelloEvents_ThingAlert thingAlert = null;

		public static final String[] INPUTS = new String[] {"thingAlert", };

		public static final String[] OUTPUTS = new String[] {"thingAlert", };

		public TaskData() {
		}

		public caf.war.HelloDBOTasks.taskclient.is.document.HelloDBP_HelloEvents_ThingAlert getThingAlert()  {
			if (thingAlert == null) {
				thingAlert = new caf.war.HelloDBOTasks.taskclient.is.document.HelloDBP_HelloEvents_ThingAlert();
			}
			return thingAlert;
		}

		public void setThingAlert(caf.war.HelloDBOTasks.taskclient.is.document.HelloDBP_HelloEvents_ThingAlert thingAlert)  {
			this.thingAlert = thingAlert;
		}
		
	}
	
	/**
	 * Return current task data object
	 * @return current task data
	 */
	public TaskData getTaskData() {
		return (TaskData)getValue(PROPERTY_KEY_TASKDATA);
	}

	/**
	 * Creates new task data object
	 * @return newly created task data object
	 */	
	protected ITaskData newTaskData() throws ContentProviderException {
		return new TaskData();
	}

}