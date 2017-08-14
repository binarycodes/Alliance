package in.binarycodes.projects.alliance;

import java.io.IOException;

import in.binarycodes.projects.alliance.bean.Alliance;
import in.binarycodes.projects.alliance.service.AllianceService;

public class App {

	public static void main(final String[] args) throws IOException {
		final AllianceService allianceService = new AllianceService("alliance-link");
		allianceService.login("username", "password");
		final Alliance alliance = allianceService.fetchUserData();
		System.out.println(alliance.toString());
		allianceService.logout();
		System.out.println(allianceService.checkGateway("xxx.xxx.xxx.xxx"));
	}
}
