/**
 * 
 */
package caf.war.HelloDBOTasks.analyzealertoverview;

/**
 * @author jagt
 *
 */

import com.webmethods.caf.faces.data.task.TaskDisplayProvider;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

@ManagedBean(name = "AnalyzeAlertOverviewDefaultviewView")
@SessionScoped
@ExpireWithPageFlow
@DTManagedBean(displayName = "AnalyzeAlertOverview/default", beanType = BeanType.PAGE)
public class AnalyzeAlertOverviewDefaultviewView extends com.webmethods.caf.faces.bean.BasePageBean {


	private static final long serialVersionUID = 1L;
	private static final String[][] INITIALIZE_PROPERTY_BINDINGS = new String[][] {
		{"#{activePreferencesBean.currentTab}", "TaskData"},
	};

	// binding the Task Display Provider to the current taskID (passed to the Portlet Bean via the URL)
	private TaskDisplayProvider taskDisplayProvider = null;
	private static final String[][] TASKDISPLAYPROVIDER_PROPERTY_BINDINGS = new String[][] { {
			"#{TaskDisplayProvider.taskID}", "#{AnalyzeAlertOverview.taskID}" }, };
	private transient caf.war.HelloDBOTasks.analyzealertoverview.AnalyzeAlertOverview analyzeAlertOverview = null;
	private caf.war.HelloDBOTasks.taskclient.AnalyzeAlert analyzeAlert = null;
	private static final String[][] ANALYZEALERT_PROPERTY_BINDINGS = new String[][] {
		{"#{AnalyzeAlert.taskID}", "#{AnalyzeAlertOverview.taskID}"},
	};

	/**
	 * Initialize page
	 */
	public String initialize() {
		try {
		    resolveDataBinding(INITIALIZE_PROPERTY_BINDINGS, null, "initialize", true, false);
		} catch (Exception e) {
			error(e);
			log(e);
		}
		return null;	
	}

	/*
	 * Get the Task Display Provider for the current taskID
	 */
	public TaskDisplayProvider getTaskDisplayProvider() {
		if (taskDisplayProvider == null) {
			taskDisplayProvider = (TaskDisplayProvider) resolveExpression("#{TaskDisplayProvider}");
		}
		resolveDataBinding(TASKDISPLAYPROVIDER_PROPERTY_BINDINGS,
				taskDisplayProvider, "taskDisplayProvider", false, false);
		return taskDisplayProvider;
	}

	public caf.war.HelloDBOTasks.analyzealertoverview.AnalyzeAlertOverview getAnalyzeAlertOverview()  {
		if (analyzeAlertOverview == null) {
		    analyzeAlertOverview = (caf.war.HelloDBOTasks.analyzealertoverview.AnalyzeAlertOverview)resolveExpression("#{AnalyzeAlertOverview}");
		}
		return analyzeAlertOverview;
	}

	public caf.war.HelloDBOTasks.taskclient.AnalyzeAlert getAnalyzeAlert()  {
		if (analyzeAlert == null) {
		    analyzeAlert = (caf.war.HelloDBOTasks.taskclient.AnalyzeAlert)resolveExpression("#{AnalyzeAlert}");
		}
	
	    resolveDataBinding(ANALYZEALERT_PROPERTY_BINDINGS, analyzeAlert, "analyzeAlert", false, false);
		return analyzeAlert;
	}

}