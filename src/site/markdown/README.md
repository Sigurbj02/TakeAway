# some documentation for this program


## translations for some of the names:
- vidmot: more or less frontend/inteface
- vinnsla: logic


## How to run the jar file:
The jar file that was created from the maven package
command can be run easiy with the help of the runjar.cmd
file:

- $ source runjar.cmd

## How the program works:
After starting, you are presented with the menu. Select
an item from the list below the word Menu you wish to
order and click on the "Add to basket"
button to have it available during the checkout process.
If you decide that you do not want one of the items, select
the item in question from the basket and click on "Remove
from basket" to have it disappear. Before being able to
continue with the payment process, you have to click on "
Sign up". Enter your name and address in the corresponding
fields and click "OK". Once you are happy with the selection,
click on "Pay" to view a summary of the entered information.
Clicking on "Confirm" then finishes the ordering process by
clearing the basket and taking the user back to the main
screen.


## Other:
- This project is licensed under: [license](LICENSE.md)
- This project's structure looks like: [UML](classDiagram.jpg)
- supported maven goals are:
  - $ mvn javafx:run (run fxml program)
  - $ mvn compile (build)
  - $ mvn clean (remove target/ directory)
  - $ mvn package (create jar file to distribute)
  - $ mvn site (generate documentation)
    vidmot "listening" to actions done by the user in the GUI)
