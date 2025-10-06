package controller;

import model.*;

/**
 * Test class for demonstrating the PhoneBook functionality and name update feature.
 * This class provides a test scenario that showcases the alphabetical organization
 * of names and the safe name update operation while maintaining proper ordering.
 * 
 * <p>The test demonstrates both the initial insertion of names and the update
 * operation that preserves alphabetical order after modifying a name.</p>
 *
 * @author Gabriel
 * @version 1.0
 * @since 2024
 */
public class TestPhoneList {

    /**
     * Default constructor for TestPhoneList.
     * Calls the superclass constructor.
     */
    public TestPhoneList() {
        super();
    }

    /**
     * Executes a comprehensive test of the PhoneBook system.
     * This test demonstrates:
     * <ul>
     *   <li>Adding names with phone numbers to the phone book</li>
     *   <li>Automatic alphabetical organization by first letter</li>
     *   <li>Safe name update operation while maintaining order</li>
     *   <li>String representation of the phone book structure</li>
     * </ul>
     * 
     * <p><b>Test Scenario:</b></p>
     * <ol>
     *   <li>Add three names: "WbRsaldo", "Ziraldo", "Wesley"</li>
     *   <li>Display the initial phone book state</li>
     *   <li>Update "WbRsaldo" to "Waldo" (correcting typo)</li>
     *   <li>Display the updated phone book state</li>
     * </ol>
     * 
     * <p><b>Expected Behavior:</b></p>
     * The names should be organized alphabetically by their first letter.
     * After the update, "Waldo" should appear in the correct alphabetical
     * position within the 'W' group, demonstrating that the update operation
     * properly maintains the sorted structure.
     */
    public void beginTest() {
        PhoneBook newPB = new PhoneBook();

        // Add test names with phone numbers
        newPB.addName("WbRsaldo", 1191234567);
        newPB.addName("Ziraldo", 1191234568);
        newPB.addName("Wesley", 1193216549);

        // Display initial state
        String list = newPB.toString();
        System.out.println(list);

        // Update a name (correcting typo)
        newPB.updateName("WbRsaldo", "Waldo");

        // Display updated state
        list = newPB.toString();
        System.out.println(list);
    }
}
