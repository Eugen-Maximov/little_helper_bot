package main.bot_users;

import data.InputStatus;
import org.telegram.telegrambots.meta.api.objects.User;

import static data.InputStatus.EMPTY;

public class BotUser extends User {

    private User user;
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String userUsername;
    private String userLocale;
    private final Double[] userLocation = new Double[2];
    private String userCity;
    private String userRegion;
    private Integer userCityId;
    private InputStatus inputStatus;
    private Long userChatID;

    public Long getUserId() {
        return userId;
    }

    public BotUser setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public BotUser setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
        return this;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public BotUser setUserLastName(String userLastName) {
        this.userLastName = userLastName;
        return this;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public BotUser setUserUsername(String userUsername) {
        this.userUsername = userUsername;
        return this;
    }

    public String getUserLocale() {
        return userLocale;
    }

    public BotUser setUserLocale(String userLocale) {
        this.userLocale = userLocale;
        return this;
    }

    public Double[] getUserLocation() {
        return userLocation;
    }

    public Double getUserLat() {
        return userLocation[0];
    }

    public Double getUserLon() {
        return userLocation[1];
    }

    public BotUser setUserLocation(Double lat, Double lon) {
        this.userLocation[0] = lat;
        this.userLocation[1] = lon;
        return this;
    }

    public String getUserCity() {
        return userCity;
    }

    public BotUser setUserCity(String userCity) {
        this.userCity = userCity;
        return this;
    }

    public Integer getUserCityId() {
        return userCityId;
    }

    public BotUser setUserCityId(Integer userCityId) {
        this.userCityId = userCityId;
        return this;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public BotUser setUserRegion(String userRegion) {
        this.userRegion = userRegion;
        return this;
    }

    public BotUser setUser(User user) {
        this.user = user;
        return this;
    }

    public InputStatus getInputStatus() {
        return inputStatus;
    }

    public BotUser setInputStatus(InputStatus inputStatus) {
        this.inputStatus = inputStatus;
        return this;
    }

    public Long getUserChatID() {
        return userChatID;
    }

    public BotUser setUserChatID(Long userChatID) {
        this.userChatID = userChatID;
        return this;
    }

    /**
     * Set up bot user:
     * Params:
     * - org.telegram.telegrambots.meta.api.objects.User
     * Return:
     * - package data.bot_users.BotUser
     **/
    public BotUser registerUser(User user) {
        setUserId(user.getId());
        setUserFirstName(user.getFirstName());
        if (user.getLastName() != null) setUserLastName(user.getLastName());
        if (user.getUserName() != null) setUserUsername(user.getUserName());
        setUserLocale(user.getLanguageCode());
        if (this.user != null) setUser(user);
        setInputStatus(EMPTY);
        UsersContainer.addUser(user, this);
        return this;
    }

    public boolean isHaveLocation() {
        return userLocation[0] != null && userLocation[1] != null;
    }

    public BotUser setUserGeo(Double[] coordinates, String city, String region) {
        setUserLocation(coordinates[0], coordinates[1]);
        setUserCity(city);
        setUserRegion(region);
        //setUserCityId(cityId);
        return this;
    }
}
