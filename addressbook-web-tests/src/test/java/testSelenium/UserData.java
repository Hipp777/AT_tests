package testSelenium;

public class UserData {
    private final String name;
    private final String secondName;
    private final String nickName;
    private final String homePhone;
    private final String mobilePhone;
    private final String birthdayDay;
    private final String birthdayMonth;
    private final String birthdayYear;

    public UserData(String name, String secondName, String nickName, String homePhone, String mobilePhone, String birthdayDay, String birthdayMonth, String birthdayYear) {
        this.name = name;
        this.secondName = secondName;
        this.nickName = nickName;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getBirthdayDay() {
        return birthdayDay;
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }
}
