/**
 * 
 */
package com.alpha.dto;

/**
 * @author Anchal.Mathur
 *
 */
public class UserAgentDetails {
	
	private String browserName;
	private String browserVersion;
	private String engineName;
	private String osName;
	private int osVersion;
	private String deviceModel;
	private String deviceType;
	
	
	public UserAgentDetails(String browserName, String browserVersion, String engineName, String osName, int osVersion,
			String deviceModel, String deviceType) {
		super();
		this.browserName = browserName;
		this.browserVersion = browserVersion;
		this.engineName = engineName;
		this.osName = osName;
		this.osVersion = osVersion;
		this.deviceModel = deviceModel;
		this.deviceType = deviceType;
	}
	
	
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getBrowserVersion() {
		return browserVersion;
	}
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	public String getEngineName() {
		return engineName;
	}
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public int getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(int osVersion) {
		this.osVersion = osVersion;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	
	

}
