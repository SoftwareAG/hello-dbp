package caf.war.HelloDBOTasks.taskclient;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

@ManagedBean(name = "AnalyzeAlertRuleContext")
@SessionScoped
@DTManagedBean(displayName = "Analyze Alert Rule Context", beanType = BeanType.DEFAULT)
public class AnalyzeAlertRuleContext  extends  com.webmethods.caf.faces.data.task.impl.BaseTaskRuleContext {
}