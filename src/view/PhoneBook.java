package view;

import controller.TestPhoneList;

/**
 * Main entry point for the Phone Book System application.
 * This class serves as the view layer in the MVC architecture,
 * providing the user interface to launch and execute the phone book test suite.
 * 
 * <p>This application demonstrates a hierarchical phone book structure
 * where names are organized alphabetically by first letter, with efficient
 * operations for adding, updating, and retrieving contact information.</p>
 *
 * @author Gabriel
 * @version 1.0
 * @since 2024
 */
public class PhoneBook {

    /**
     * Main method that serves as the entry point for the Phone Book System.
     * Creates a TestPhoneList instance and executes the comprehensive test suite
     * that demonstrates the hierarchical organization and name update functionality
     * of the phone book system.
     * 
     * <p><b>Application Output:</b></p>
     * The test will display the phone book structure before and after a name update,
     * showing how the system maintains alphabetical order while allowing safe
     * modifications to contact information.
     * 
     * <p><b>Expected Output Example:</b></p>
     * <pre>
     * Lista: W
     * WbRsaldo - 1191234567
     * Wesley - 1193216549
     * 
     * Lista: Z
     * Ziraldo - 1191234568
     * 
     * Lista: W
     * Waldo - 1191234567
     * Wesley - 1193216549
     * 
     * Lista: Z
     * Ziraldo - 1191234568
     * </pre>
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        try {
            TestPhoneList newTest = new TestPhoneList();

            newTest.beginTest();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
