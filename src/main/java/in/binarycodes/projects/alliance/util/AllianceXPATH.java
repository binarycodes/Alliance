package in.binarycodes.projects.alliance.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public enum AllianceXPATH {
	LOGIN_USER_NAME("//*[@id='username']"), //
	LOGIN_PASSWORD("//*[@id='password']"), //
	LOGIN_BUTTON("//*[@id='loginform']/form/div/button"), //
	LOGOUT_BUTTON("/html/body/div[1]/form/input"), //

	EXPIRY_DATE("//*[@id='thesmalltable']/tbody/tr[5]/td[2]/text()"), //
	PACKAGE_NAME("//*[@id='thesmalltable']/tbody/tr[4]/td[2]/text()"), //
	CLIENT_ID("//*[@id='thesmalltable']/tbody/tr[3]/td[2]/text()"), //
	USER_NAME("//*[@id='thesmalltable']/tbody/tr[1]/td[2]/text()");

	private String xpath;

	private AllianceXPATH(final String xpath) {
		this.xpath = xpath;
	}

	public String getXpath() {
		return this.xpath;
	}

	public String getXpathText(final HtmlPage page) {
		final DomText domText = page.getFirstByXPath(this.xpath);
		return Optional.ofNullable(domText).map(DomText::asText).orElse(null);
	}

	public LocalDate getXpathLocalDate(final HtmlPage page, final String datePattern) {
		final String dateString = this.getXpathText(page);
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
		return Optional.ofNullable(dateString).map(dString -> LocalDate.parse(dString, formatter)).orElse(null);
	}

	public void setXpathValue(final HtmlPage page, final String value) {
		final HtmlInput htmlInput = page.getFirstByXPath(this.xpath);
		if (htmlInput != null) {
			htmlInput.setValueAttribute(value);
		}
	}

	public void clickXpath(final HtmlPage page) throws IOException {
		final HtmlElement htmlElement = page.getFirstByXPath(this.xpath);
		if (htmlElement != null) {
			htmlElement.click();
		}
	}

}
