package validate_exception;

public class ValidateCheckChoice {
    public void validateChoice(int numOfChoice, int numIn) throws ExceptionCheckChoice {
        if (numIn <= 0 || numIn > numOfChoice) {
            throw new ExceptionCheckChoice("co cac lua chon tu 1 den " + numOfChoice);
        }
    }

    public boolean checkChoice(String choice, int numOfChoice) {
        try {
            validateChoice(numOfChoice, Integer.parseInt(choice));
            return true;
        } catch (ExceptionCheckChoice m) {
            System.out.println(m + "\n-----" +
                    "\nhay nhap lai");
            return false;
        } catch (Exception e) {
            System.out.println("loi nhap" +
                    "\nhay nhap lai");
            return false;
        }
    }
}
