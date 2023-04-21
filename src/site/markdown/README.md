# some documentation for this program


## translations for some of the names:
- vidmot: more or less frontend/inteface
- vinnsla: logic

## design pattern:
We use the Observer behavioural pattern, by using listeners, event handlers and bindings. This can be seen in several places, usually to make the interface reflect changes as they happen

#Listeners
The object that the listener is put on is observed, and is therefore called an observable.
The object that is updated within the listener is observing, and is therefore called an observer.
- Listener on getProducts() of Basket basket in OrderingController, which returns an ObservableList<Product>, and ListView<Product> fxBasket is updated
- Listener on getProducts() of Basket basket in TransactionController, ListView<Product> fxBasket is updated
- Listener on ObservableList<Product> (from getProducts()) in Basket, which is inherited from Menu, and IntegerProperty totalPrice in Basket is updated
- Listener on BooleanProperty loggedIn in OrderingController, text on the fxLoginButton is updated

#Bindings
When using single-direction bindings, the observer is bound to the observable, usually with observer.bind(observable)
- The text of fxTotalPrice (in the interface) is bound to the totalPriceProperty of the basket instance, both in OrderingController
- The Button fxPayButton in OrderingController is bound to the totalPriceProperty of the basket in Ordering, to disable it
- The Button fxLoginButton in OrderingController is bound to BooleanProperty loggedIn in OrderingController, to disable it
- The ok button in CustomerDialog is bound to the content of the textfields in the interface (to disable it)
- The nameProperty and addressProperty of the customer in CustomerDialog are bound to their respective textfields in the interface
- The text of the label fxName in TransactionController is bound to the nameProperty of the customer field in OrderingController
- The text of the label fxAddress in TransactionController is bound to the addressProperty of the customer field in OrderingController
- getProducts() of the basket field in TransactionController, which returns an ObservableList<Product>, is bound to getProducts() of the basket field in OrderingController
- The text of the label fxTotalPrice in TransactionController is bound to the totalPriceProperty of the basket field in TransactionController

#Handlers
Event handlers i.e. in OrderingController and TransactionController observe objects in the GUI and react when they are interacted with
The object in the interface which the handler is put on is the observable
The observable is presumably within the code of the handler, whatever is updated


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
   - $ mvn fxml:run (run fxml program)
   - $ mvn compile (build)
   - $ mvn clean (remove target/ directory)
   - $ mvn package (create jar file to distribute)
   - $ mvn site (generate documentation)
     vidmot "listening" to actions done by the user in the GUI)