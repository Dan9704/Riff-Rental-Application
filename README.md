# Riff Rental App

Riff Rental is an Android application that allows users to browse, listen to, and borrow musical instruments. The app provides detailed information on each instrument, allowing users to experience sample sounds and book their favorite instruments with ease.

## Features

- **Browse Instruments**: View a list of available musical instruments with details such as type, price, and condition (new or used).
- **Play Sound**: Listen to sample sounds of each instrument directly within the app.
- **Favorite Instruments**: Mark your favorite instruments for easy access later.
- **Search Functionality**: Search for instruments by name using the search bar.
- **Multi-Activity Navigation**: Click the "Borrow" button to navigate to a new activity where users can enter their details and submit a request to borrow an instrument.
- **Data Sharing**: Share instrument details between activities using Parcelable objects.
- **User Details Submission**: Enter your name and email when borrowing an instrument and receive a confirmation.
- **Persist User Data**: Save and retrieve user data using SharedPreferences.

## Screenshots

Loading ...

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/riff-rental-app.git
   ```
2. **Open the project in Android Studio**:
   - File > Open > Select the project directory.

3. **Build the project**:
   - Ensure you have an Android emulator or a physical device connected.
   - Click on the green "Run" button in Android Studio.

## How to Use

1. **Browse Instruments**: On the main screen, scroll through available instruments.
2. **Play Sound**: Tap the "Play Sound" button to listen to the instrument’s sample sound.
3. **Favorite**: Click the heart icon to mark an instrument as your favorite.
4. **Search**: Use the search bar at the top to find specific instruments.
5. **Borrow an Instrument**:
   - Tap the "Borrow" button to navigate to the borrowing screen.
   - Enter your name and email, then click "Submit."
   - Use the "Back to Home" button to return to the main screen.

## Dependencies

This project uses the following dependencies:
- AndroidX Core, AppCompat, ConstraintLayout
- Material Components
- Espresso for UI Testing
- JUnit for Unit Testing

Add these dependencies in your `build.gradle` file:

```groovy
dependencies {
    implementation 'androidx.core:core-ktx:1.8.0'
    implementation 'androidx.appcompat:appcompat:1.4.2'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

    // Testing Dependencies
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}
```

## Testing

- The app includes unit tests and UI tests written with JUnit and Espresso.
- To run the tests, go to **Run > Run 'All Tests'** in Android Studio or use the command line:
  ```bash
  ./gradlew testDebugUnitTest
  ./gradlew connectedAndroidTest
  ```

## Future Improvements

- **User Authentication**: Allow users to create accounts and save their favorite instruments.
- **Expanded Instrument Database**: Add more instruments with detailed descriptions and sounds.
- **Payment Integration**: Implement payment options for borrowing instruments.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries, please contact [your email](mailto:tungduong9704@gmail.com).

---

Feel free to adjust the content according to your specific project requirements, screenshots, and GitHub repository details! Let me know if you need further modifications or additions.
