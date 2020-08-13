class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (firstName != null) {
            this.firstName = firstName;
        } else {
            this.firstName = "";
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if (lastName != null) {
            this.lastName = lastName;
        } else {
            this.lastName = "";
        }
    }

    public String getFullName() {
        String fullName;
        if (!firstName.isEmpty()) {
            if (!lastName.isEmpty()) {
                fullName = firstName + " " + lastName;
            } else {
                fullName = firstName;
            }
        } else {
            if (!lastName.isEmpty()) {
                fullName = lastName;
            } else {
                fullName = "Unknown";
            }
        }
        return fullName; // write your code here
    }
}