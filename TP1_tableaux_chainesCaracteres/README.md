# **Lab Report 1: Arrays and Strings**


![][image1]

## ![][image2] **Completed by: Yassine IDRISSI**

## **Module: Object-Oriented Programming in Java**

## **Academic Year: 2024-2025**

1. **Objectives of the Practical Assignment:**

   The objective of this practical assignment is to manipulate arrays and strings in Java. This involves:

- **Manipulate arrays to store and process numerical data (students' grades).**

* Learn to sort an array.
* Calculate statistics from an array (average, maximum, minimum).
* Search for specific occurrences in an array.

- **Manipulate strings, particularly first-group verbs in French, for conjugation.**

* Identify and validate first-group verbs.
* Conjugate these verbs with different personal pronouns.

- **Perform various operations on a string entered by the user.**

* Implement an interactive menu for managing strings.
* Perform operations such as reversing a string and counting words.

- **Count occurrences of letters in a string without differentiating uppercase and lowercase.**

* Use an array to store and display the number of occurrences of each letter in the alphabet.

2. **Materials and Development Environment:**

- **Programming Language:** Java
- **Development Environment:** IntelliJ
- **JDK** : 17

3. **Description of Exercises and Results:**

- **Exercise 1: Manipulating Grades with an Array:**

_Class "NoteEtudiant": capture 1_

1. **Creation of the `’NoteEtudiant’`Class:**

   This class manages an array of grades and performs the required operations. The array is initialized with a fixed size corresponding to the number of students.

2. **Adding Grades:**

   Grades are added to the array through the ajouterNote() method, which checks if the array is full before adding a new grade.

_Class "NoteEtudiant": capture 2_

3. **Sorting Grades:**

   Grades are sorted using the `Arrays.sort()` method.

4. **Calculating the Average Grade:**

   The average is calculated by summing all the grades and dividing by the number of students.

**![][image3]**

_Class "NoteEtudiant": capture 3_

5. **Determining Maximum and Minimum Grades:**

   The maximum and minimum values are determined by iterating through the array.

6. **Searching for a Specific Grade Occurrence:**

   The number of occurrences of a specific grade is counted using a for loop.

_Class "NoteEtudiant": capture de la fonction main_

- **Results Obtained:**

  The results obtained from running the program:

_Class "NoteEtudiant": capture de résultat de l’exécution du programme_

- **Exercise 2: Conjugating a First-Group Verb:**

1. **Creation of the `’Conjugaison’` Class:**

   This class manages the conjugation of first-group verbs in the present tense. The verb is passed as a parameter when creating the object and is stored in a private attribute.

2. **Conjugating in the Present Tense:**

   The `conjuguerAuPresent()` method checks if the verb belongs to the first group by verifying if it ends in "er." If so, the stem is extracted, and the appropriate endings are added for each personal pronoun.

3. **`Main` Class:**

   The main class interacts with the user to enter the verb and displays the conjugation. An object of the `Conjugaison` class is created, and the `conjuguerAuPresent()` method is called to generate and display the conjugation.

- **Results Obtained:**

  Here are some examples of results obtained from running the program:

* **Exercise 3: String Manipulation:**

1. **Creation of the `’StringManipulator’`Class:**

   This class contains three main methods: one to reverse the string, one to count the number of words, and another to display the entered string. A constructor is used to initialize the string.

2. **Reversing the String:**

   The `inverserChaine()` method iterates through the string and reconstructs it in reverse using a `for` loop.

3. **Calculating Word Count:**

   The `calculerNombreMots()` method uses the regular expression `[,\\.\\s]+` to split the string into words and returns the length of the resulting array.

4. **`Main` Class:**

   The `Main` class contains the logic for the interactive menu. The user can enter a string, display it, reverse it, or count the words through the menu. A `StringManipulator` object is created for each entered string.

- **Results Obtained:**

  Here are examples of results obtained from the program:

- **Entering:**

- **Displaying:**
- **Reversing:**

- **Word Count:**

* **Exercise 4: Calculating Letter Occurrences in the Alphabet:**

1. **Creation of the `’OccurenceAlphabet’` Class:**

   This class contains a main method that takes a string, iterates through it, and counts the occurrences of each letter in the alphabet.

2. **`calculerOccurencesLettres()` Method:**

   The `calculerOccurencesLettres()` method iterates through the string provided by the user, counts the occurrences of each letter in the alphabet (ignoring case), and displays these occurrences.

3. **`Main` class:**

   The main class interacts with the user to enter the string, then uses the `OccurenceAlphabet` object to display the letter occurrences.

- **Results Obtained:**

  Here are the results obtained from the program:

4. **Conclusion:**

   This practical assignment allowed us to strengthen our knowledge of manipulating arrays and strings in Java. We developed programs capable of performing common operations, such as sorting, counting, and reversing strings, while enhancing our Java programming skills.
