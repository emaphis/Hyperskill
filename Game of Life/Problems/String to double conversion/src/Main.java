class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        try {
            if (input != null) {
                return Double.parseDouble(input);
            } else  {
                return 0.0;
            }
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }
}