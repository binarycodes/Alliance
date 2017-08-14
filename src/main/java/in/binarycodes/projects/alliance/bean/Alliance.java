package in.binarycodes.projects.alliance.bean;

import java.time.LocalDate;

public class Alliance {

	private String userName;
	private String packageName;
	private String clientId;
	private LocalDate expiryDate;

	@Override
	public String toString() {
		final StringBuilder text = new StringBuilder();
		text.append("Name: ").append(this.userName).append(System.getProperty("line.separator"));
		text.append("Client ID: ").append(this.clientId).append(System.getProperty("line.separator"));
		text.append("Package: ").append(this.packageName).append(System.getProperty("line.separator"));
		text.append("Expiry Date: ").append(this.expiryDate).append(System.getProperty("line.separator"));
		return text.toString();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

}
