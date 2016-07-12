

package org.apache.struts2.dispatcher.mapper;

import java.util.Map;

import com.opensymphony.xwork2.Result;

/**
 * �������ڵ���һ��Struts action��actionӳ����Ϣ�ļ��ࡣ name��namespace�Ǳ���ģ�������map
 * �ǿ�ѡ�ģ���˲��������ǿյġ�����ṩ��һ������map�� ��������һ���ɱ��map������HashMap
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
	 * �����ռ�
	 */
	private String namespace;
	/**
	 * actonִ�еķ���
	 */
	private String method;
	/**
	 * ����
	 */
	private String extension;
	/**
	 * ����
	 */
	private Map<String, Object> params;
	/**
	 * ִ�н��
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
