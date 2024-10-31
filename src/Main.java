import static java.util.Objects.*;

public class Main {

    public static void main(String[] args) {
        String login = "mkasmkdsamk";
        String password = "123";
        String confirmPassword = "123";

        try {
            checkLoginPasswordConfirmPassword(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Неверный логин");
        } catch (WrongPasswordException e) {
            System.out.println("Неверный пароль или пароль не подтверждён");
        }

    }

    public static void checkLoginPasswordConfirmPassword(String login, String password, String confirmPassword) {
        checkLogin(login);
        checkPassword(password);
        checkConfirmPassword(password,confirmPassword);
    }

    private static void checkLogin(String login) {
        int maximumNumberByCharactersAllowed = 20;
        if (isNull(login) || login.isBlank() || login.length() > maximumNumberByCharactersAllowed || !checkingALineForCorrectnessOfEnteredData(login)) {
            throw new WrongLoginException();
        }
    }

    private static void checkPassword(String password) {
        int maximumNumberByCharactersAllowed = 20;
        if (isNull(password) || password.isBlank() || password.length() > maximumNumberByCharactersAllowed || !checkingALineForCorrectnessOfEnteredData(password)) {
            throw new WrongPasswordException();
        }
    }

    private static void checkConfirmPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }

    private static boolean checkingALineForCorrectnessOfEnteredData(String string) {
        boolean result = false;
        int count = 0;
        String allowedCharacters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0987654321_";
        for (int i = 0; i < allowedCharacters.length(); i++) {
            if (nonNull(string) && !string.isBlank() && string.charAt(count) == allowedCharacters.charAt(i)) {
                if (count < string.length() - 1) {
                    count++;
                    i = 0;
                    result = true;
                } else {
                    break;
                }
            } else if (i == allowedCharacters.length() - 1) {
                result = false;
                break;
            }
        }
        return result;
    }

}
