# Rent with Intent

**Author**: Dac Tung Duong Nguyen  

## Project Overview:

"**Rent with Intent**" is an Android application designed for renting musical instruments. The app allows users to browse through various instruments, view details such as name, rating, type, and price, listen to sound samples, and confirm their rental. This project showcases multiple Android development techniques, including multi-activity workflows, Parcelable data transfer, data persistence via SharedPreferences, and media playback for sound samples.

The app provides a simple and intuitive interface for users to explore and rent instruments dynamically, ensuring smooth data handling and user feedback throughout the process.

## Key Features:
 
1. **Instrument Browsing**:
   - Users can browse a list of available instruments one at a time.
   - Details such as the instrument’s name, rating, type (new or used), and price are displayed.
   - Users can navigate between instruments using "Next" and "Previous" buttons.
   - Users can listen to sound samples of the instruments before making a rental decision.
   
2. **Borrowing System**:
   - Users can click the "Borrow" button to move to the BorrowActivity, where they can confirm their rental.
   - Personal details (name and email) are entered and validated before completing the booking.
   - Upon successful submission, a confirmation message is shown to the user using **Toast** notifications.
   
3. **Data Persistence**:
   - **SharedPreferences** is used to store booking details locally on the device, allowing the app to maintain booking information across sessions.
   
4. **Sound Playback**:
   - The app uses the **MediaPlayer** class to play sound samples of the instruments, offering users the chance to hear the instrument before renting.
   
5. **Multi-Activity Workflow**:
   - The app employs Android **Intents** to pass data between different activities. For instance, when users choose an instrument and click "Borrow", the instrument’s details are passed from **MainActivity** to **BorrowActivity**.
   - The **Parcelable** interface is utilized to efficiently transfer complex objects between activities.

6. **Form Validation**:
   - Proper form validation is implemented to ensure users provide the required details (name and email) before confirming the booking.
   - Error messages are displayed using **Toast** notifications if any required fields are missing.

## Technology Stack:

- **Android SDK**: Android development framework.
- **Parcelable**: To efficiently transfer complex data objects between activities.
- **SharedPreferences**: To store user bookings locally on the device.
- **MediaPlayer**: For playing sound samples of musical instruments.
- **ChipGroup & RatingBar**: UI components used for selecting instrument attributes and displaying ratings.

## Design and UI Components:

### 1. Vertical Sequential Layout:
- The app uses a vertical sequential layout for displaying instrument details.
- **Instrument Image**: Displayed at the top, showcasing the instrument.
- **Instrument Name**: Shown under the image, using a `TextView`.
- **RatingBar**: Displays the instrument’s rating.
- **Attributes**: Displayed using `ChipGroup` to highlight features such as "New" or "Used".
- **Price**: Displayed below the attributes.
- **Navigation and Borrow Buttons**: Positioned at the bottom for easy access.

### 2. Horizontal Grid Layout (Future Work):
- In future updates, a horizontal grid layout may be added for displaying multiple instruments on the same screen.

### Styling and User Interface:
- Consistent design across activities.
- Custom styles applied using `styles.xml` for a cohesive look and feel.

## Development Process:

### 1. MainActivity:
   - Displays the instruments one at a time and allows users to browse through the list.
   - Contains buttons to navigate to the next or previous instrument.
   - Plays sound samples using MediaPlayer when a user clicks the "Play Sound" button.
   
### 2. BorrowActivity:
   - Displays details of the selected instrument.
   - Allows the user to input personal information to complete the booking.
   - Handles form validation to ensure all necessary fields are filled before submission.
   - Uses SharedPreferences to store booking details locally.

### 3. Data Transfer (Intents and Parcelable):
   - Instrument details are passed between activities using **Intents**.
   - For efficient data transfer, the **Parcelable** interface is implemented to pass entire instrument objects between activities instead of individual fields.

### 4. Sound Playback:
   - The **MediaPlayer** class is used to handle audio playback for instrument sound samples.
   - Proper lifecycle management ensures that resources are released when audio playback is no longer required.

## How to Run the Project:

1. Clone the repository:
   ```bash
   git clone <>
   ```

2. Open the project in **Android Studio**.

3. Build and run the project on an emulator or a physical Android device.

4. Features to Test:
   - Browse through the instruments using the "Next" and "Previous" buttons.
   - Play sound samples of each instrument.
   - Select an instrument to rent by clicking the "Borrow" button.
   - Enter personal details in the BorrowActivity and submit the booking.
   - Verify that a confirmation message is displayed upon successful booking.

## Testing:

### Espresso Testing:
- **Espresso** was used to test the app’s user interface, including:
  - Form submission validation.
  - Navigation between activities.
  - Interaction with UI elements like buttons and text inputs.

### Key Test Scenarios:
1. **Borrow Button Click**:
   - Tests the user’s ability to navigate from MainActivity to BorrowActivity and complete the rental process.
   
2. **Search Functionality**:
   - Ensures that the search bar correctly filters instruments based on user input.
   
3. **Image Navigation**:
   - Validates the "Next" and "Previous" buttons for navigating between instruments.

## Known Issues and Future Enhancements:

1. **Data Persistence**:
   - The app currently uses **SharedPreferences** for saving booking details. For a more scalable solution, consider implementing a local database (e.g., Room).

2. **UI Enhancements**:
   - Improvements in UI design, including better handling of screen orientations and sizes, will enhance the overall user experience.
   
3. **Authentication**:
   - A user authentication system can be added in future versions to allow users to create accounts and track their rental history.

4. **Enhanced Error Handling**:
   - Expand the current error handling system by providing detailed messages and feedback with action buttons for better user interaction.

5. **Payment Integration**:
   - A payment gateway can be integrated to allow users to complete the rental process with payments.

6. **Real-Time Inventory**:
   - In future iterations, support for real-time inventory updates and notifications about available instruments can further enhance the app’s usability.

## Reflection:

This project helped me understand Android development principles, including data management, multi-activity workflows, and UI design. I gained hands-on experience with **Intents**, **Parcelable**, **SharedPreferences**, and **Espresso** for testing. Future work will focus on improving performance, expanding test coverage, and enhancing the user interface.

## License:


---