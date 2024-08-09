Description:

This is a RPN Calculator that does the basic arithmatic on both simple and complex math equations. It takes an input and turns it into a string using
a UI State and breaks down the string into a list of operators and numbers to perfom each math equation.

Architecture:
This application is using the MVVM (minus the Model) where the View is where I have created the Jetpack Composeables as well the Main Activity which is the 
application starting point. And the View Model is where we store the data that is to be presented as well as perform the buisness logic of the acutal 
calculations. I have also created Unit Test to ensure that the functionality works as inteded.

Trade Offs:
One trade off was the lack of a way to persist the data (such as a room database) that would allow the user to recall previous math equations. And if 
given more time I would have tried to add a power/square root functionality so the calculator could be more useful to the user.

How to Run:
 You must press each number button and when are done with an individual number you must press "Enter". When you want to calculate, you must press the "=" button.
 
 Example:
  "5" "Enter" "5" "Enter" "5" "Enter" "8" "+" "+" "=" : This will show you the proper result
  
  GitHub Link:
  https://github.com/GlennWhite250/CalExample