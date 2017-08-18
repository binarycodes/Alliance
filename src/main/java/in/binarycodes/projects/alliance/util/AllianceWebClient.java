package in.binarycodes.projects.alliance.util;

import com.gargoylesoftware.htmlunit.WebClient;

public class AllianceWebClient extends WebClient {
	private static final long serialVersionUID = 4954800184874389288L;

	public AllianceWebClient() {
		super();
		this.getOptions().setCssEnabled(false);
		this.getOptions().setJavaScriptEnabled(false);
	}

}
