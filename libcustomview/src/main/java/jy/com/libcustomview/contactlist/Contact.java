package jy.com.libcustomview.contactlist;

/*
 * created by taofu on 2019-05-14
 **/
public class Contact {
    private String name;
    private String phoneNumber;
    private String pinyin;
    private String fistChar;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
        fistChar = pinyin.substring(0, 1);
    }


    public String getFistChar() {
        return fistChar;
    }


}
