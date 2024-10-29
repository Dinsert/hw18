import static java.util.Objects.*;

public class Main {

    public static void main(String[] args) {
        String login = "masidmia";
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

    public static void checkLoginPasswordConfirmPassword(String login, String password, String confirmPassword) throws WrongLoginException {
        int maximumNumberByCharactersAllowed = 20;
        if (isNull(login) || login.length() > maximumNumberByCharactersAllowed || !checkingALineForCorrectnessOfEnteredData(login)) {
            throw new WrongLoginException();
        }
        if (isNull(password) || password.length() > maximumNumberByCharactersAllowed || !checkingALineForCorrectnessOfEnteredData(password)) {
            throw new WrongPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }


    }

    private static boolean checkingALineForCorrectnessOfEnteredData(String string) {
        boolean result = false;
        int count = 0;
        String allowedCharacters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0987654321_";
        for (int i = 0; i < allowedCharacters.length(); i++) {
            if (nonNull(string) && !string.isEmpty() && string.charAt(count) == allowedCharacters.charAt(i)) {
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
