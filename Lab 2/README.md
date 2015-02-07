Things to do:

readFile() method declaration includes 'throws TooManyRecordsException'. However this function does not throw the exception. checked records size here itself and thrown the exception instead of in main(). Or since your stu[] array is of size 40, adding the 41st element to it would give ArrayIndexOutOfBoundsException. Caught that and thrown out TooManyRecordsException at that point.

Write test program separately to ensure code reusability 

Adequate test cases for a file with more than 40 records.

Class diagram not provided.
