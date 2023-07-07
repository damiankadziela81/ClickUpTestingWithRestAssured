package org.example.url;

public class ClickUpUrl {

    private static final String BASE_URL = "https://api.clickup.com/api/v2";
    private static final String TEAM = "/team";
    private static final String SPACE = "/space";
    private static final String LIST = "/list";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getTeamsUrl() {
        return TEAM;
    }

    public static String getTeamUrl(String teamId) {
        return TEAM + "/" + teamId;
    }

    public static String getSpaceUrl(String spaceId) {
        return SPACE + "/" + spaceId;
    }

    public static String getSpacesUrl(String teamId) {
        return getTeamUrl(teamId) + SPACE;
    }

    public static String getListsUrl(String spaceId) {
        return getSpaceUrl(spaceId) + LIST;
    }
}
