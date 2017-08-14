package in.binarycodes.projects.alliance.service;

import java.io.IOException;
import java.net.InetAddress;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import in.binarycodes.projects.alliance.bean.Alliance;
import in.binarycodes.projects.alliance.util.AllianceXPATH;

public class AllianceService {

	private final String url;

	public AllianceService(final String url) {
		this.url = url;
	}

	public boolean checkGateway(String gatewayIP) throws IOException {
		InetAddress gatewayInetAddress = InetAddress.getByName(gatewayIP);
		return gatewayInetAddress.isReachable(4000);
	}

	public boolean login(final String userName, final String password) {
		boolean status = false;
		final WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			final HtmlPage page = client.getPage(this.url);
			AllianceXPATH.LOGIN_USER_NAME.setXpathValue(page, userName);
			AllianceXPATH.LOGIN_PASSWORD.setXpathValue(page, password);
			AllianceXPATH.LOGIN_BUTTON.clickXpath(page);
			status = true;
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		} finally {
			client.close();
		}
		return status;
	}

	public boolean logout() {
		boolean status = false;
		final WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			final HtmlPage page = client.getPage(this.url);
			AllianceXPATH.LOGOUT_BUTTON.clickXpath(page);
			status = true;
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		} finally {
			client.close();
		}
		return status;
	}

	public Alliance fetchUserData() {
		final Alliance alliance = new Alliance();

		final WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			final HtmlPage page = client.getPage(this.url);
			alliance.setUserName(AllianceXPATH.USER_NAME.getXpathText(page));
			alliance.setClientId(AllianceXPATH.CLIENT_ID.getXpathText(page));
			alliance.setPackageName(AllianceXPATH.PACKAGE_NAME.getXpathText(page));
			alliance.setExpiryDate(AllianceXPATH.EXPIRY_DATE.getXpathLocalDate(page, "MM.dd.yyyy"));
		} catch (final FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		} finally {
			client.close();
		}
		return alliance;
	}
}
