

package org.apache.struts2.dispatcher.mapper;

import java.util.Map;

import com.opensymphony.xwork2.Result;

/**
 * 持有用于调用一个Struts action的action映射信息的简单类。 name和namespace是必需的，但参数map
 * 是可选的，因此参数可能是空的。如果提供了一个参数map， 它必须是一个可变的map，比如HashMap
 * <p>
 * Simple class that holds the action mapping information used to invoke a
 * Struts action. The name and namespace are required, but the params map is
 * optional, and as such may be null. If a params map is supplied, it
 * <b>must</b> be a mutable map, such as a HashMap.
 * 
 * <pre>
 *<action name="loadNavigatorTree" class="businessConfigAction"
			method="loadNavigatorTree">
			<result type="json" name="success" />
		</action>
 * </pre>
 */
public class ActionMapping {

	/**
	 * name
	 */
	private String name;
	/**
	 * 命名空间
	 */
	private String namespace;
	/**
	 * acton执行的方法
	 */
	private String method;
	/**
	 * 扩大
	 */
	private String extension;
	/**
	 * 参数
	 */
	private Map<String, Object> params;
	/**
	 * 执行结果
	 */
	private Result result; 

	/**
	 * Constructs an ActionMapping
	 */
	public ActionMapping() {
	}

	/**
	 * Constructs an ActionMapping with a default result
	 *
	 * @param result
	 *            The default result
	 */
	public ActionMapping(Result result) {
		this.result = result;
	}

	/**
	 * Constructs an ActionMapping with its values
	 *
	 * @param name
	 *            The action name
	 * @param namespace
	 *            The action namespace
	 * @param method
	 *            The method
	 * @param params
	 *            The extra parameters
	 */
	public ActionMapping(String name, String namespace, String method, Map<String, Object> params) {
		this.name = name;
		this.namespace = namespace;
		this.method = method;
		this.params = params;
	}

	/**
	 * @return The action name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return The action namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @return The extra parameters
	 */
	public Map<String, Object> getParams() {
		return params;
	}

	/**
	 * @return The method
	 */
	public String getMethod() {
		if (null != method && "".equals(method)) {
			return null;
		} else {
			return method;
		}
	}

	/**
	 * @return The default result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * @return The extension used during this request
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param result
	 *            The result
	 */
	public void setResult(Result result) {
		this.result = result;
	}

	/**
	 * @param name
	 *            The action name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param namespace
	 *            The action namespace
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * @param method
	 *            The method name to call on the action
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @param params
	 *            The extra parameters for this mapping
	 */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	/**
	 * @param extension
	 *            The extension used in the request
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
}
