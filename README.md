# Task S1.03

## Level 1 Exercise 1
**Description**:
Create a class named Month with an attribute `name` that stores the name of the month.
Add 11 Month objects to an ArrayList, leaving out "August". Insert this month in the
corresponding position and verify that the order of the months is correct.

Then convert the ArrayList into a HashSet and verify that duplicates are not allowed.

Finally, iterate over the collection with a for loop and with an Iterator.

## Level 1 Exercise 2
**Description**:
Create and fill a List<Integer>.
Create a second list and insert the same elements but in reverse order.
Use a ListIterator to read the elements of the first list and add them to the second.

## Level 1 Exercise 3
**Description**:
In this exercise we will practice reading files, using collections such as HashMap,
and interacting with the user through a small quiz game.

## Level 2 Exercise 1
**Description**:
Create a class named Restaurant with two attributes: name (String) and rating (int).
Implement the necessary methods (equals() and hashCode()) so that Restaurant objects
with the same name and the same rating cannot be added to a HashSet.

## Level 2 Exercise 2
**Description**:
Based on the Restaurant class from the previous program, implement the functionality
so that the objects can be ordered alphabetically by name and, if they match,
by rating in descending order.

## Level 3 Exercise 1
**Description**:
Create an application capable of reading a CSV file. This file has 3 fields: first name,
last name and DNI, for each record. The task is to sort the people read from the file
by their first name, last name or DNI. You may use the list you consider most appropriate.

## Technologies
- Backend: Java

## Installation and Execution
1. Clone the repository: `git clone https://github.com/Quint3in/Tasca_S1.03.git`
2. Go into the project folder: `cd Tasca_S1.03`
3. Build the module you want (from the root). Example for `n2exercici1`:
   `mvn -pl n2exercici1 -am package`
4. Run it (from the root):
   `java -cp n2exercici1/target/classes org.example.Main`
