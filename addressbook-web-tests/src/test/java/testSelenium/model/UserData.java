package testSelenium.model;

public class UserData {
    private final String name;
    private final String secondName;
    private final String nickName;
    private final String homePhone;
    private final String mobilePhone;
    private final String birthdayDay;
    private final String birthdayMonth;
    private final String birthdayYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (name != null ? !name.equals(userData.name) : userData.name != null) return false;
        return secondName != null ? secondName.equals(userData.secondName) : userData.secondName == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }

    private int id;

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", id=" + getId() +
                '}';
    }

    public UserData(String name, String secondName, String nickName, String homePhone, String mobilePhone, String birthdayDay, String birthdayMonth, String birthdayYear) {
        this.name = name;
        this.secondName = secondName;
        this.nickName = nickName;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
        this.setId(Integer.MAX_VALUE);
    }
    public UserData(int id, String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
        this.nickName = "nickName";
        this.homePhone = "homePhone";
        this.mobilePhone = "mobilePhone";
        this.birthdayDay = "birthdayDay";
        this.birthdayMonth = "birthdayMonth";
        this.birthdayYear = "birthdayYear";
        this.id=id;
    }
    public UserData(int id, String name, String secondName, String nickName, String homePhone, String mobilePhone, String birthdayDay, String birthdayMonth, String birthdayYear) {
        this.name = name;
        this.secondName = secondName;
        this.nickName = nickName;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
        this.setId(id);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
