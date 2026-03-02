public class TestUser {
    public static void main(String[] args) {
        // Valid user
        User user1 = new User("John Doe", "john@example.com", "password123");
        System.out.println(user1);
        user1.displayInfo();
        
        // Test validation - these should throw exceptions
        try {
            User user2 = new User("J", "john@example.com", "pass123"); // Name too short
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Name validation works: " + e.getMessage());
        }
        
        try {
            User user3 = new User("John", "invalid-email", "pass123"); // No @
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Email validation works: " + e.getMessage());
        }
        
        try {
            User user4 = new User("John", "john@example.com", "pass"); // Password too short
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Password validation works: " + e.getMessage());
        }
    }
}
