package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        return username.length() > 3;
    }

    public boolean isValidPassword (String password1,String password2) {
        boolean validPass = password1.length() > 7 && password2.length() > 7 && password1.equals(password2);
        return  validPass;
    }

    public boolean isValidEmail(String email) {
        //Eltárolja a keresett indexeket,hogy ne keressen 2x
        int kukacIndex = email.indexOf("@");
        int pontIndex = email.indexOf(".");

        //Van-e benne kukac és index
        boolean hasAtAndDot = kukacIndex > -1 && pontIndex > -1;

        //A kukac nem az első és a pont nem az utolsó
        boolean atNotFirstAndDotNotLast =  kukacIndex > 0 && pontIndex + 1 < email.length();

        boolean hasAnythingBetweenAtAndDot = kukacIndex < pontIndex && kukacIndex + 1 != pontIndex;
        boolean validEmail = hasAtAndDot && atNotFirstAndDotNotLast && hasAnythingBetweenAtAndDot;
        return validEmail;
    }
}
