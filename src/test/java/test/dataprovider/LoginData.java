package test.dataprovider;

import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider
    public static Object[][] validLoginData() {
        return new Object[][]{
                {"hotelfriend", "hotelfriendpasssword"}
        };
    }

    @DataProvider
    public static Object[][] invalidEmailData() {
        return new Object[][]{
                {"", "Введите адрес электронной почты или номер телефона"},
                {"       ", "Введите адрес электронной почты или номер телефона"},
                {"hotelfriend @gmail.com", "Введите адрес электронной почты или номер телефона"},
                {"hotelfriend@gmail", "Введите адрес электронной почты или номер телефона"},
                {"hotelfriend@gmail..com", "Введите адрес электронной почты или номер телефона"},
                {"hotelfriend@@gmail.com", "Введите адрес электронной почты или номер телефона"}
        };
    }

    @DataProvider
    public static Object[][] invalidPasswordData() {
        return new Object[][]{
                {"hotelfriend", "", "Введите пароль"},
                {"hotelfriend", "          ", "Введите пароль"},
                {"hotelfriend", "    hotelfriendpasssword", "Неверный пароль."},
                {"hotelfriend", "hotelfriendpasssword     ", "Неверный пароль."},
                {"hotelfriend", "HOTELfriendpasssword", "Неверный пароль."}
        };
    }
}
